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
import java.util.Scanner;

/**
 * Created by xiaofeng on 2018/4/9
 * Description:
 */
public class ChatServer implements Runnable {

    @Override
    public void run() {
        try {
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private ServerSocketChannel serverSocketChannel;

    private SocketChannel sc;

    public void start() throws IOException {
        serverSocketChannel = ServerSocketChannel.open();
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

                        this.sc = socketChannel;
                    }
                }
                if( key.isReadable()){
                    SocketChannel socketChannel = (SocketChannel) key.channel();
                    MsgUtil.recieveMsg(socketChannel);
                }
            }
        }
    }

    public void send(String line){
        MsgUtil.sendMsg(sc,line);
    }

    public static void main(String[] args) {
        ChatServer chatServer = new ChatServer();
        Thread thread = new Thread(chatServer);
        thread.start();
        Scanner scanner = new Scanner(System.in);
        while (true){
            String line = scanner.nextLine();
            chatServer.send(line);
        }
    }
}
