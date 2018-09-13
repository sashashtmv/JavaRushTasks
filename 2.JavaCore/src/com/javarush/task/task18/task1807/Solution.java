package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream file = new FileInputStream(reader.readLine());
        ArrayList<Character> chars = new ArrayList<>();
        while (file.available()>0){
            char ch = (char)file.read();
            chars.add(ch);
        }
        int count = 0;
        for(char a:chars){
            if(a==',') count++;
        }
        System.out.println(count);
        reader.close();
        file.close();
    }
}
