package com.xiaofeng.nio.mychat;

import com.google.common.base.Strings;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by xiao on 2018/4/9.
 */
public class MsgUtil {

	public static void sendMsg(SocketChannel socketChannel,String line){
		int port = socketChannel.socket().getLocalPort();
		String ip = socketChannel.socket().getLocalAddress().toString();
		final String tag = ip + ":" + port;

		if(Strings.isNullOrEmpty(line)){
			System.err.println( tag + "empyt msg!!!");
			return;
		}

		final String req = line;
		ByteBuffer byteBuffer = ByteBuffer.allocate(req.length());
		byteBuffer.clear();
		byteBuffer.put(req.getBytes());
		byteBuffer.flip();
		try {
			socketChannel.write(byteBuffer);
			//System.out.println(tag + ":" + req);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void recieveMsg(SocketChannel socketChannel){
		int port = socketChannel.socket().getPort();
		String ip = socketChannel.socket().getRemoteSocketAddress().toString();
		final String tag = ip + ":" + port;

		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		byteBuffer.clear();
		int count;
		try {
			while ( (count = socketChannel.read(byteBuffer)) > 0){
				byteBuffer.flip();
				System.out.println(tag+ ":" + new String(byteBuffer.array(),0,count));
				byteBuffer.clear();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}