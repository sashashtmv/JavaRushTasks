package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        int buff;
        if (a < b){
            buff = a;
            a = b;
            b = buff;
        }
        if (b < c){
            buff = b;
            b = c;
            c = buff;
        }
        if (a < b) {
            buff = a;
            a = b;
            b = buff;
        }
        System.out.println(a + " " + b + " " + c);
        //напишите тут ваш код
    }
}
