package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

            while (true) {
                String s = reader.readLine();
                if (s.equals("exit")) break;

                try {
                    if (s.contains(".")) {
                        print(Double.parseDouble(s));
                    } else {

                        int temp = Integer.parseInt(s);
                        if (0 < temp && temp < 128) print((short) temp);
                        else if (temp <= 0 || temp >= 128) print(Integer.parseInt(s));
                    }
                }catch (NumberFormatException e){print(s);}
                     //напиште тут ваш код

            }

    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
