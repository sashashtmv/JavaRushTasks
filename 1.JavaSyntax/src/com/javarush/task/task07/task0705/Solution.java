package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] mass = new int[20];
        for (int i= 0; i < mass.length; i++){
            mass[i] = Integer.parseInt(reader.readLine());
        }
        int[] mass1 = new int[10];
        int[] mass2 = new int[10];
        mass1 = Arrays.copyOfRange(mass, 0, 10);
        mass2 = Arrays.copyOfRange(mass, 10,20);
        for(int i : mass2) System.out.println(i);
        //напишите тут ваш код
    }
}
