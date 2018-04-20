package com.xiaofeng.nio.mychat.codec;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import lombok.Getter;

/**
 * Created by xiaofeng on 2018/4/20
 * Description:
 */
public class ChatHandler extends SimpleChannelInboundHandler<String> {

    @Getter
    private Channel channel;

//    @Override
//    public void channelActive(ChannelHandlerContext ctx) throws Exception {
//        super.channelActive(ctx);
//        this.channel = ctx.channel();
//    }


    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        super.handlerAdded(ctx);
        this.channel = ctx.channel();
        System.out.println("recieve a ...from " + channel.remoteAddress());
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println("recieve a message:" + msg);
    }
}