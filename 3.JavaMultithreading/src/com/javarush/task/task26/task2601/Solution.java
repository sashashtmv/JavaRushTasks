package com.javarush.task.task26.task2601;

import java.util.*;

/*
Почитать в инете про медиану выборки
*/
public class Solution {

    public static void main(String[] args) {
//        Integer[] mas = {25, 8, 15, 5, 17, 13};
//        sort(mas);
//        for(Integer a : mas)
//        System.out.print(a + " ");

    }

    public static Integer[] sort(Integer[] array) {
        Arrays.sort(array);
        Integer med = 0;
        if(array.length % 2 !=0) {
            med = array[array.length/2];
        }
        else {
            med = (array[array.length/2] + array[array.length/2 - 1]) / 2 ;
        }
        Integer medium = med;
        Comparator<Integer> compareByHeight = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                return (Math.abs(o1-medium) - Math.abs(o2-medium)) == 0 ? o1-o2 : Math.abs(o1-medium)- Math.abs(o2-medium);
            }
        };

        Arrays.sort(array, compareByHeight);

        return array;
    }
}
