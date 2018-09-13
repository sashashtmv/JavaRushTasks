package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        FileInputStream fileread = new FileInputStream(name);
        String id = args[0];
        BufferedReader f = new BufferedReader(new InputStreamReader(fileread));
        ArrayList<String> str = new ArrayList<>();
        String dtr;
        while ((dtr=f.readLine())!=null){
            str.add(dtr);
        }
        for(String s : str){
            if(s.startsWith(id+" ")) System.out.println(s);
        }

        reader.close();
        f.close();
        fileread.close();
    }
}
