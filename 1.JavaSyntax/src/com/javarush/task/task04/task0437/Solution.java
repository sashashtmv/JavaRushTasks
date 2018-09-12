package com.javarush.task.task04.task0437;


/* 
Треугольник из восьмерок
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int a = 8;
        for (int i = 1; i < 11; i ++){
            for (int j = i; j > 0; j-- ){
                System.out.print(a);
            }
            System.out.println();
        }
        //напишите тут ваш код

    }
}
