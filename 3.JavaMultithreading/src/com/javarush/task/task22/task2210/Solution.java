package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {

    }
    public static String [] getTokens(String query, String delimiter) {
        String[] mas;
        ArrayList<String> buf = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(query,delimiter);
        while (tokenizer.hasMoreTokens()) {
            buf.add(tokenizer.nextToken());
        }
        mas = new String[buf.size()];
        return buf.toArray(mas);
    }
}
