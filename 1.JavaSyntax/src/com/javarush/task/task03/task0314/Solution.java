package com.javarush.task.task03.task0314;

/* 
Таблица умножения
*/

public class Solution {
    public static void main(String[] args) {
        int i = 1;
        int j = 1;
        while (i <= 10){
            System.out.print(i * j + " ");
            j++;
            if (j == 11){
                i++;
                j = 1;
                System.out.println();
            }
        }
        //напишите тут ваш код
    }
}
