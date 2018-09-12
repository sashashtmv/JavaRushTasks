package com.javarush.task.task03.task0303;

/* 
Обмен валют
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(convertEurToUsd(10, 1.05));
        System.out.println(convertEurToUsd(14, 1.06));//напишите тут ваш код
    }

    public static double convertEurToUsd(int eur, double course) {
        double dol = (double)eur * course;
        return dol;//напишите тут ваш код
    }
}
