package com.javarush.task.task31.task3102;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* 
Находим все файлы
*/
public class Solution {
    public static List<String> getFileTree(String root) throws IOException {
        List<String> list = new ArrayList<>();

        List<File> dirs = new ArrayList<>();
        dirs.add(new File(root));

        while (dirs.size() > 0) {
            for (File file : dirs.get(0).listFiles()) {
                if (file.isDirectory()) {
                    dirs.add(file);
                } else {
                    list.add(file.getAbsolutePath());
                }

            }
            dirs.remove(0);
        }

        return list;

    }

    public static void main(String[] args) {

    }
}
