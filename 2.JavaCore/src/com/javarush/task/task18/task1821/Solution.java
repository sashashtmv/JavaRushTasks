package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException{
        String name = args[0];
        FileInputStream fileread = new FileInputStream(name);
        TreeMap<Character, Integer> map = new TreeMap<>();
        while (fileread.available()>0){
            char a = (char)fileread.read();
            if(map.get(a)==null){
                map.put(a, 1);
            }else {
                map.put(a,map.get(a)+1);
            }
        }
        for(Map.Entry entry: map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
        fileread.close();
    }
}
