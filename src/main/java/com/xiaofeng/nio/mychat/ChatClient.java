package com.xiaofeng.nio.mychat;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by xiaofeng on 2018/4/9
 * Description:
 */
public class ChatClient implements Runnable {
    @Override
    public void run() {
        try {
            start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private SocketChannel socketChannel;
    private Selector selector;

    public void start() throws IOException {
        selector = Selector.open();
        socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        if (socketChannel.connect(new InetSocketAddress("127.0.0.1",8888))){
            socketChannel.register(selector, SelectionKey.OP_READ);
            //sendMsg(socketChannel);
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
                    }
                }
                if( key.isReadable()){
                   MsgUtil.recieveMsg(socketChannel);
                }
            }
        }
    }

    public void send(String line){
        MsgUtil.sendMsg(socketChannel,line);
    }

    public static void main(String[] args) {
        ChatClient chatClient = new ChatClient();
        Thread thread = new Thread(chatClient);
        thread.start();

        Scanner scanner = new Scanner(System.in);
        while (true){
            String line = scanner.nextLine();
            chatClient.send(line);
        }
    }
}