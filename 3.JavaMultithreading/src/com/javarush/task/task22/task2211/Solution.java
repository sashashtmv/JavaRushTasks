package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        String readString = args[0];
        String writeString = args[1];
        FileInputStream fis = new FileInputStream(readString);
        FileOutputStream fos = new FileOutputStream(writeString);

        byte[] buffer = new byte[fis.available()];
        fis.read(buffer);
        String str = new String(buffer, "Windows-1251");
        fos.write(str.getBytes("UTF-8"));

        fis.close();
        fos.close();
    }
}
