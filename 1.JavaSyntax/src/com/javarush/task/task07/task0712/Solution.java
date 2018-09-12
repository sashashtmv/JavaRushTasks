package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> s = new ArrayList<>();
        int min = 100000;
        int max = 0;
        for(int i = 0; i < 10; i ++){
            String str = reader.readLine();
            s.add(str);
            if(min > str.length()) min = str.length();
            if(max < str.length()) max = str.length();
        }
        for(String a : s){
            if(min == a.length() || max == a.length()){
                System.out.println(a);
                break;
            }
        }

        //напишите тут ваш код
    }
}
