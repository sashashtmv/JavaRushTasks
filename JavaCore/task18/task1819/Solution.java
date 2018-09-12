package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        ArrayList<Integer> ch = new ArrayList<>();
        FileInputStream file1read = new FileInputStream(file1);
        FileOutputStream file1write = new FileOutputStream(file1);
        FileInputStream file2read = new FileInputStream(file2);
        while (file1read.available()>0){
            ch.add(file1read.read());
        }
        while (file2read.available()>0){
            int a = file2read.read();
            file1write.write(a);
        }
        for(int a : ch){
            file1write.write(a);
        }
        reader.close();
        file1read.close();
        file1write.close();
        file2read.close();
    }
}
