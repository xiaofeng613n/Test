package com.xiaofeng.nio.mychat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

import java.util.Scanner;

/**
 * Created by xiaofeng on 2018/4/10
 * Description:
 */
public class NettyChatClient implements Runnable {
    @Override
    public void run() {
        start();
    }

    private MsgHandler msgHandler = new MsgHandler();
    private Channel channel;

    public void start(){
        EventLoopGroup workerGroup = new NioEventLoopGroup(1);

        Bootstrap client = new Bootstrap();
        client.group(workerGroup)
                .channel(NioSocketChannel.class)
                .handler(msgHandler);
        try {
            channel = client.connect("127.0.0.1",8888).sync().channel();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void send(String line){
        channel.writeAndFlush(line);
    }
    public static void main(String[] args) {
        NettyChatClient client = new NettyChatClient();
        Thread thread = new Thread(client);
        thread.start();
        Scanner scanner = new Scanner(System.in);
        while (true){
            String line = scanner.nextLine();
            client.send(line);
        }
    }
}