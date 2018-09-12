package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> str = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int min = 100000;
        for (int i = 0; i < 5; i++){
            String s = reader.readLine();
            str.add(s);
            if(min > s.length()) {
                min = s.length();
            }
        }
        for(String a : str){
            if(min == a.length()) System.out.println(a);
        }
        //напишите тут ваш код
    }
}
