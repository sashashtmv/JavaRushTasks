package com.javarush.task.task07.task0707;

import java.util.ArrayList;

/* 
Что за список такой?
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<String> str = new ArrayList();
        str.add("a");
        str.add("s");
        str.add("d");
        str.add("f");
        str.add("g");
        System.out.println(str.size());
        for (int i = 0; i < str.size(); i++) System.out.println(str.get(i));
        //напишите тут ваш код
    }
}
