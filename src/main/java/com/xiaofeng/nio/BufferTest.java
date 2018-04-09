package com.xiaofeng.nio;

import java.nio.ByteBuffer;
import java.nio.CharBuffer;

/**
 * Created by xiaofeng on 2018/4/8
 * Description:
 */
public class BufferTest {
    public static void main(String[] args) {
        CharBuffer charBuffer = CharBuffer.allocate(100);
        charBuffer.array();
        ByteBuffer byteBuffer = ByteBuffer.allocate(100);

    }
}