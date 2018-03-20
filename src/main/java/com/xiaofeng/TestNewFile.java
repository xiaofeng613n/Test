package com.xiaofeng;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/**
 * Created by xiaofeng on 2018/3/20
 * Description:
 */
public class TestNewFile {
    public static void main(String[] args) {
        Path path = FileSystems.getDefault().getPath("");
    }
}