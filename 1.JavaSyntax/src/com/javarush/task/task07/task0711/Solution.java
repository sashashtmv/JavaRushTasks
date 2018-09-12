package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> s = new ArrayList<>();
        for(int i = 0; i < 5; i++) s.add(reader.readLine());
        for(int i = 0; i < 13; i ++){
            String temp = s.get(4);
            s.remove(4);
            s.add(0, temp);
        }
        for(String str : s) System.out.println(str);
        //напишите тут ваш код
    }
}
