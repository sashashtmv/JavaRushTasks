package com.javarush.task.task07.task0715;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Продолжаем мыть раму
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> list = new ArrayList<>();
        list.add("мама");
        list.add("мыла");
        list.add("раму");
        int i = 1;
        int count = 0;
        while (true){
            list.add(i, "именно");
            i+=2;
            count++;
            if (count == 3) break;
        }
        for(String s : list) System.out.println(s);
        //напишите тут ваш код
    }
}
