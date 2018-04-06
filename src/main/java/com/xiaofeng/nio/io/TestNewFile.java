package com.xiaofeng.nio.io;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by xiaofeng on 2018/3/20
 * Description:
 */
public class TestNewFile {
    public static void main(String[] args) throws IOException {
        Path path = FileSystems.getDefault().getPath("E:\\logs0");

//        try {
//            DirectoryStream<Path> stream = Files.newDirectoryStream(path,"*.properties");
//            for (Path entry : stream){
//                System.out.println(entry.getFileName());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Files.walkFileTree(path,new FindJavaVisitor());
        try(WatchService watchService = FileSystems.getDefault().newWatchService()){
            path.register(watchService,StandardWatchEventKinds.ENTRY_CREATE,
                    StandardWatchEventKinds.ENTRY_MODIFY,
                    StandardWatchEventKinds.ENTRY_DELETE);
            while (true){
                final WatchKey key = watchService.take();
                for(WatchEvent watchEvent: key.pollEvents()){
                    final WatchEvent.Kind kind = watchEvent.kind();

                    if (kind == StandardWatchEventKinds.ENTRY_CREATE){
                        System.out.println();
                    }
                    if (kind == StandardWatchEventKinds.ENTRY_MODIFY){
                        System.out.println();
                    }

                    final WatchEvent<Path> watchEventPath = watchEvent;
                    final Path fileName = watchEventPath.context();
                    System.out.println(kind + "->"  + fileName);
                }
                boolean valid = key.reset();

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    static class FindJavaVisitor extends SimpleFileVisitor<Path>{

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
//            return super.visitFile(file, attrs);
            if (file.toString().endsWith(".java")) {
                System.out.println(file.getFileName());
            }
            return FileVisitResult.CONTINUE;
        }
    }
}