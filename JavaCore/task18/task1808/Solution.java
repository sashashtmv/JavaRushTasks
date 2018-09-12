package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream readfiles = new FileInputStream(file1);
        FileOutputStream writefiles2 = new FileOutputStream(file2);
        FileOutputStream writefiles3 = new FileOutputStream(file3);
        int sum = readfiles.available();
        int a = sum/2;
        if(sum%2!=0){
            a=a+1;
            while (a>0){
                int buf = readfiles.read();
                writefiles2.write(buf);
                a--;
            }
        }
        else {
            while (a>0){
                int buf = readfiles.read();
                writefiles2.write(buf);
                a--;
            }
        }
        while (readfiles.available()>0){
            int buf = readfiles.read();
            writefiles3.write(buf);
        }
        reader.close();
        readfiles.close();
        writefiles2.close();
        writefiles3.close();
    }
}
