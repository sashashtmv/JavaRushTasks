package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("b1", 500);
        map.put("b2", 100);
        map.put("b3", 1000);
        map.put("b4", 1000);
        map.put("b5", 2000);
        map.put("b6", 2000);
        map.put("b7", 500);
        map.put("b8", 500);
        map.put("b9", 500);
        map.put("b10", 500);
        return map;
        //напишите тут ваш код
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        HashMap<String, Integer> copy = new HashMap<>(map);
        for (Map.Entry< String, Integer > entry : copy.entrySet()){
           if(entry.getValue() < 500) map.remove(entry.getKey());
        }
        //напишите тут ваш код
    }

    public static void main(String[] args) {

    }
}