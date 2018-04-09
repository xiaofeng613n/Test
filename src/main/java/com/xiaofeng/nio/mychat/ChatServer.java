package com.xiaofeng.nio.mychat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

/**
 * Created by xiaofeng on 2018/4/9
 * Description:
 */
public class ChatServer {

    public void start() throws IOException {
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        ServerSocket server = serverSocketChannel.socket();
        Selector selector = Selector.open();
        server.bind(new InetSocketAddress(8888));
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("start waiting for connection...");
        while (true){
            if( selector.select() == 0){
                continue;
            }
            Iterator it = selector.selectedKeys().iterator();
            while (it.hasNext()){
                SelectionKey key = (SelectionKey) it.next();
                it.remove();
                if( key.isAcceptable()){
                    ServerSocketChannel s = (ServerSocketChannel) key.channel();
                    SocketChannel socketChannel = s.accept();
                    if( null != socketChannel){
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector,SelectionKey.OP_READ);

                        ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
                        buffer.clear();
                        buffer.put("Hi there!\r\n".getBytes());
                        buffer.flip();
                        socketChannel.write(buffer);
                    }
                }
                if( key.isReadable()){
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    readMsg(socketChannel);
                }
            }
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

        buffer.clear();
        buffer.put("hei,I got the msg!\r\n".getBytes());
        buffer.flip();
        try {
            socketChannel.write(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        try {
            chatServer.start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
