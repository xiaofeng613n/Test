package com.xiaofeng.nio.mychat;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.util.Scanner;

/**
 * Created by xiaofeng on 2018/4/10
 * Description:
 */
public class NettyChatServer implements Runnable{

    @Override
    public void run() {
        start();
    }

    public void send(String line){
        msgHandler.getCtx().writeAndFlush(line);
    }

    private MsgHandler msgHandler = new MsgHandler();

    public void start(){
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup(2);

        try {
            ServerBootstrap server = new ServerBootstrap();
            server.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            ch.pipeline().addLast(msgHandler);
                        }
                    })
                    .childOption(ChannelOption.SO_BACKLOG.SO_KEEPALIVE, true);

            ChannelFuture f = server.bind(8888).sync();
            f.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    public static void main(String[] args) {
        NettyChatServer server = new NettyChatServer();
        Thread thread = new Thread(server);
        thread.start();
        Scanner scanner = new Scanner(System.in);
        while (true){
            String line = scanner.nextLine();
            server.send(line);
        }
    }
}