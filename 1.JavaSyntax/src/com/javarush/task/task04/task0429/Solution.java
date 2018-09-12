package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int negat = 0;
        int posit = 0;
        for (int i = 0; i < 3; i++){
            int num = Integer.parseInt(reader.readLine());
            if (num < 0) negat++;
            else if (num > 0) posit++;
        }
        System.out.println("количество отрицательных чисел: " + negat);
        System.out.println("количество положительных чисел: " + posit);
        //напишите тут ваш код

    }
}
