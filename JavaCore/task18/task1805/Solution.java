package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;



/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream read = new FileInputStream(reader.readLine());
        ArrayList<Integer> buf = new ArrayList<>();
        while (read.available()>0){
            int data = read.read();
            buf.add(data);
        }
        Collections.sort(buf);
        int a = 0;
        for(int i = 0; i < buf.size(); i++){
            if (a==buf.get(i))continue;
            else {
                a=buf.get(i);
                System.out.print(a + " ");
            }
        }
        reader.close();
        read.close();


    }
}
