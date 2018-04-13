package com.xiaofeng.nio.mychat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * Created by xiaofeng on 2018/4/10
 * Description:
 */
public class MsgHandler extends ChannelInboundHandlerAdapter {

    public ChannelHandlerContext getCtx() {
        return ctx;
    }

    public void setCtx(ChannelHandlerContext ctx) {
        this.ctx = ctx;
    }

    private ChannelHandlerContext ctx;

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        //super.channelRead(ctx, msg);
        this.ctx = ctx;
        System.out.println(msg);
    }

}