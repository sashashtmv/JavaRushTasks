package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();
        FileInputStream readfile2 = new FileInputStream(file2);
        FileInputStream readfile3 = new FileInputStream(file3);
        FileOutputStream readfile1 = new FileOutputStream(file1);
        while (readfile2.available()>0){
            int a = readfile2.read();
            readfile1.write(a);
        }
        while (readfile3.available()>0){
            int a = readfile3.read();
            readfile1.write(a);
        }
        reader.close();
        readfile1.close();
        readfile2.close();
        readfile3.close();
    }
}
