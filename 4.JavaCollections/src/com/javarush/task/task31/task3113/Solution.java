package com.javarush.task.task31.task3113;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;


/* 
Что внутри папки?
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        reader.close();
        Path file = Paths.get(name);
        if (!Files.isDirectory(file)) {
            System.out.println(file.toString() + " - не папка\"");
        } else {
            Myvisitor myvisitor = new Myvisitor();
            Files.walkFileTree(file, myvisitor);
            myvisitor.result();
        }
    }

    private static class Myvisitor implements FileVisitor {
        private int directionCount = 0;
        private int fileCount = 0;
        private int fileContentCount = 0;

        private void result() {
            System.out.println("Всего папок - " + (directionCount - 1));
            System.out.println("Всего файлов - " + fileCount);
            System.out.println("Общий размер - " + fileContentCount);
        }

        public FileVisitResult preVisitDirectory(Object dir, BasicFileAttributes attrs) throws IOException {
            directionCount += 1;
            return FileVisitResult.CONTINUE;
        }


        public FileVisitResult visitFile(Object file, BasicFileAttributes attrs) throws IOException {
            fileCount += 1;
            byte[] content = Files.readAllBytes((Path) file);
            fileContentCount += content.length;
            return FileVisitResult.CONTINUE;
        }


        public FileVisitResult visitFileFailed(Object file, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }


        public FileVisitResult postVisitDirectory(Object dir, IOException exc) throws IOException {
            return FileVisitResult.CONTINUE;
        }
    }
}
