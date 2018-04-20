package com.xiaofeng.nio.mychat.codec;

import io.netty.channel.CombinedChannelDuplexHandler;

/**
 * Created by xiaofeng on 2018/4/20
 * Description:
 */
public class CombinedByteCharCodec extends CombinedChannelDuplexHandler<ByteToCharDecoder,CharToByteEncoder> {

    public CombinedByteCharCodec() {
        super(new ByteToCharDecoder(),new CharToByteEncoder());
    }
}