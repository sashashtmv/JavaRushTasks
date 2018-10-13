package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader fis = new BufferedReader(new FileReader(reader.readLine()));
        StringBuilder sb = new StringBuilder();
        while (fis.ready()){
            sb.append(fis.readLine() + " ");
        }
        String[] mas = sb.toString().split(" ");
        //...
        StringBuilder result = getLine(mas);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {
        if(words.length == 0) return new StringBuilder("");
        StringBuilder result = new StringBuilder();
        for(int k = 0; k < words.length; k++) {
        StringBuilder stringBuilder = new StringBuilder();
        String start = words[k];
        stringBuilder.append(start + " ");
            for (int j = 0; j < words.length; j++) {
                for (int i = 0; i < words.length; i++) {
                    if (start.toLowerCase().charAt(start.length() - 1) == words[i].toLowerCase().charAt(0) && !stringBuilder.toString().contains(words[i])) {
                        stringBuilder.append(words[i] + " ");
                        start = words[i];
                    }
                }
            }
            if(stringBuilder.length() > result.length()) result = stringBuilder;
        }
        return new StringBuilder(result.toString().trim());
    }
}
