package com.javarush.task.task29.task2913;

import java.util.Random;

/* 
Замена рекурсии
*/

public class Solution {
    private static int numberA;
    private static int numberB;

    public static String getAllNumbersBetween(int a, int b) {
        String result = "";
        if (a == b) result = "" + a;
        else if (a > b) {
            while (a != b-1) {
                result += a + " ";
                a--;
            }
        } else {
            while (a != b+1) {
                result += a + " ";
                a++;
            }
        }
        return result.trim();
    }

    public static void main(String[] args) {
        Random random = new Random();
        numberA = random.nextInt(100);
        numberB = random.nextInt(1000);
        System.out.println(getAllNumbersBetween(numberA, numberB));
        System.out.println(getAllNumbersBetween(numberB, numberA));
    }
}