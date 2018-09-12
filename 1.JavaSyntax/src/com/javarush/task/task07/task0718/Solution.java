package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> str = new ArrayList<>();
        String temp = "";
        int count = 0;
        for(int i = 0; i < 10; i++) str.add(reader.readLine());
        for (String s : str){
            if(temp.length() <= s.length()) {
                temp = s;
                count++;
            }
            else System.out.println(count);
        }
        //напишите тут ваш код
    }
}

