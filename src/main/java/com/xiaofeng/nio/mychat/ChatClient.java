package com.xiaofeng.nio.mychat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by xiaofeng on 2018/4/9
 * Description:
 */
public class ChatClient {
    public void sendMsg(SocketChannel socketChannel){
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        buffer.clear();
        buffer.put("hello , this is client!\r\n".getBytes());
        buffer.flip();
        try {
            socketChannel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void readMsg(SocketChannel socketChannel){
        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
        buffer.clear();
        int count;
        try {
            while ( (count = socketChannel.read(buffer)) > 0){
                buffer.flip();
                byte[] b = new byte[buffer.remaining()];
                buffer.get(b,0,b.length);
                System.out.println("recieve from client:"+new String(b));
                buffer.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void start() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        Selector selector = Selector.open();
        socketChannel.configureBlocking(false);
        if (socketChannel.connect(new InetSocketAddress("127.0.0.1",8888))){
            socketChannel.register(selector, SelectionKey.OP_READ);
            sendMsg(socketChannel);
        }else {
            socketChannel.register(selector,SelectionKey.OP_CONNECT);
        }

        while (true) {
            if( selector.select() == 0){
                continue;
            }
            Iterator it = selector.selectedKeys().iterator();
            while (it.hasNext()){
                SelectionKey key = (SelectionKey) it.next();
                SocketChannel sc = (SocketChannel) key.channel();
                it.remove();
                if( key.isConnectable()){
                    if( sc.finishConnect()){
                        System.out.println("finsh connnect");
                        socketChannel.register(selector, SelectionKey.OP_READ);
                        sendMsg(sc);
                    }
                }
                if( key.isReadable()){
                   readMsg(socketChannel);
                }

            }
        }
    }

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
        try {
            chatClient.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}