package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[] mass = new int[15];
        int even = 0;
        int loss = 0;
        for(int i = 0; i < mass.length; i++){
            mass[i] = Integer.parseInt(reader.readLine());
            if ( i == 0 || i % 2 == 0){
                even += mass[i];
            }
            else loss += mass[i];
        }
        if (even > loss) System.out.println("В домах с четными номерами проживает больше жителей.");
        else System.out.println("В домах с нечетными номерами проживает больше жителей.");

        //напишите тут ваш код
    }
}
