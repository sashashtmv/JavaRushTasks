package com.javarush.task.task03.task0306;

/* 
Головоломка со скобками
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println((1 + 2) * (3 + 4) * 5 + (6 * 7 + 8) * 9 + 10 * 11 + 12 * 13 + 14 + 15);
    }
}

//если 12 * 13, то 367 и нужно 69 * 7
// если 12 * 27, то 521 и нужно 47 * 7
// если 12 * 42, то 686 и нужно (164) 23 * 7 +3 или