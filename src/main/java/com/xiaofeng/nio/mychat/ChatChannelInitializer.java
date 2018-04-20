package com.xiaofeng.nio.mychat;

import com.xiaofeng.nio.mychat.codec.ByteToCharDecoder;
import com.xiaofeng.nio.mychat.codec.CharToByteEncoder;
import com.xiaofeng.nio.mychat.codec.ChatHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

/**
 * Created by xiaofeng on 2018/4/20
 * Description:
 */
public class ChatChannelInitializer extends ChannelInitializer<SocketChannel> {

    private ChatHandler chatHandler;

    public ChatChannelInitializer(ChatHandler chatHandler){
        this.chatHandler = chatHandler;
    }

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
//        pipeline.addLast("decoder", new ByteToCharDecoder())
//                .addLast("encoder", new CharToByteEncoder())
//                .addLast("handler", chatHandler);
        pipeline.addLast("decoder", new StringDecoder())
                .addLast("encoder", new StringEncoder())
                .addLast("handler", chatHandler);
    }
}