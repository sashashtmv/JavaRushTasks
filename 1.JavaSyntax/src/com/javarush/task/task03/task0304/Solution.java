package com.javarush.task.task03.task0304;

/* 
Задача на проценты
*/

import static com.javarush.task.task03.task0304.Solution.addTenPercent;

public class Solution {
    public static double addTenPercent(int i) {
        double s = i * 1.1;
        return s;//напишите тут ваш код
    }

    public static void main(String[] args) {
        System.out.println(addTenPercent(9));
    }
}
