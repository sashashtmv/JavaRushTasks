package com.javarush.task.task10.task1015;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        ArrayList<String>[] mass = new ArrayList[3];
        mass[0] = new ArrayList<>(Arrays.asList("Java", "Scala", "Groovy"));
        mass[1] = new ArrayList<>(Arrays.asList("Java", "Scala", "Groovy"));
        mass[2] = new ArrayList<>(Arrays.asList("Java", "Scala", "Groovy"));
        //напишите тут ваш код

        return mass;
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}