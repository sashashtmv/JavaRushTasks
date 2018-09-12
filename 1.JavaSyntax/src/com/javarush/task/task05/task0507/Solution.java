package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int sum = 0;
        int count = 0;
        while (true){
            int a = Integer.parseInt(reader.readLine());
            if (a == -1) break;
            sum = sum + a;
            count++;
        }
        System.out.println((double)sum / count);
        //напишите тут ваш код
    }
}

