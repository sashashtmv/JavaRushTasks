package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] mass = new int[10];
        for(int i = 0; i < mass.length; i++){
            mass[i] = Integer.parseInt(reader.readLine());
        }

        for(int i = 0, j = mass.length-1; i < mass.length/2; i++, j-- ){
            int temp = mass[j];
            mass[j] = mass[i];
            mass[i] = temp;
        }
        for(int i : mass){
            System.out.println(i);
        }
        //напишите тут ваш код
    }
}

