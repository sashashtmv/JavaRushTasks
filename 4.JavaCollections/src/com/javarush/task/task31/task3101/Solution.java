package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

/*
Проход по дереву файлов
*/
public class Solution {
    public static TreeMap fix(String dir) {
        TreeMap<String, File> map = new TreeMap<>();


        File folder = new File(dir);
        if (folder.isDirectory()) {
            for (File file : folder.listFiles()) {
                map.putAll(fix(file.getAbsolutePath()));
                if (file.isFile()) {
                    if (file.length() <= 50) {
                        map.put(file.getName(), file);
                    }
                }
            }
        }
        return map;
    }

    public static void main(String[] args) throws IOException, FileNotFoundException{
        String dir = "";
        File resultFileAbsolutePath = null;
        File renameFile = null;
        try {
            dir = args[0];
            resultFileAbsolutePath = new File(args[1]); // args[1]
            renameFile = new File(resultFileAbsolutePath.getParent() + "/allFilesContent.txt");
            FileUtils.renameFile(resultFileAbsolutePath, renameFile);
        }catch (ArrayIndexOutOfBoundsException | NullPointerException ex){}


        try (FileOutputStream fileOutputStream = new FileOutputStream(renameFile)) {

            TreeMap<String, File> map = fix(dir);

            for (Map.Entry<String, File> pair : map.entrySet()) {

                FileInputStream fileInputStream = new FileInputStream(pair.getValue().getAbsolutePath());
                while (fileInputStream.available() > 0) {
                    int a = fileInputStream.read();
                    fileOutputStream.write(a);
                }

                fileOutputStream.write('\n');
                fileInputStream.close();
            }
        } catch (Exception e) {

        }
    }
}
