package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream filereader = new FileInputStream(file1);
        FileOutputStream filewriter = new FileOutputStream(file2);
        ArrayList<Integer> buf = new ArrayList<>();
        while (filereader.available()>0){
            int a = filereader.read();
            buf.add(a);
        }
        for(int i = buf.size()-1; i >=0; i--){
            filewriter.write(buf.get(i));
        }
        reader.close();
        filereader.close();
        filewriter.close();
    }
}
