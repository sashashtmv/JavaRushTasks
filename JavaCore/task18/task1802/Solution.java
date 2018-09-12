package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream read = new FileInputStream(reader.readLine());
        int buf = 288888888;
        while (read.available()>0){
            int data = read.read();
            if (data < buf) buf=data;
        }
        System.out.println(buf);
        reader.close();
        read.close();

    }
}
