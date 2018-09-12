package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        if (a > 0){
            a = a * 2;
         }
        else if (a < 0){
            a = a + 1;
        }
        else a = 0;
        System.out.println(a);
        //напишите тут ваш код

    }

}