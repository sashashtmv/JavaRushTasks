package com.javarush.task.task07.task0708;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самая длинная строка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> str = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        String smax = "";
        for (int i = 0; i < 5; i++){
            String s = reader.readLine();
            str.add(s);
            if(max < s.length()) {
                max = s.length();
                smax = s;
            }
        }
        for(String a : str){
            if(smax.length() == a.length()) System.out.println(a);
        }

    }
}
