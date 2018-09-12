package com.javarush.task.task08.task0801;

/* 
HashSet из растений
*/

import java.util.HashSet;

public class Solution {
    public static void main(String[] args) throws Exception {
        HashSet<String> sets = new HashSet<>();
        sets.add("арбуз");
        sets.add("банан");
        sets.add("вишня");
        sets.add("груша");
        sets.add("дыня");
        sets.add("ежевика");
        sets.add("жень-шень");
        sets.add("земляника");
        sets.add("ирис");
        sets.add("картофель");
        for(String s : sets) {
            System.out.println(s);
        }
        //напишите тут ваш код

    }
}
