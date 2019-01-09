package com.javarush.task.task31.task3106;

import java.io.*;

import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/*
Разархивируем файл
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        List<InputStream> listStream = new Vector<>();
        List<String> listPath = new LinkedList<String>(Arrays.asList(args));
        listPath.remove(0);
        Collections.sort(listPath);
        for(String i : listPath) {
            listStream.add(new FileInputStream(i));
        }
        byte[] contentFile;
        try(OutputStream outputStream = new FileOutputStream(args[0]);
            ZipInputStream zipInputStream = new ZipInputStream(new SequenceInputStream(Collections.enumeration(listStream)))) {
            ZipEntry entry;
            while ((entry = zipInputStream.getNextEntry()) != null) {
                contentFile = new byte[(int)entry.getSize()];
                int count;
                while((count = zipInputStream.read(contentFile)) != -1) {
                    outputStream.write(contentFile, 0, count);
                }
                zipInputStream.closeEntry();

            }
        }
    }
}
