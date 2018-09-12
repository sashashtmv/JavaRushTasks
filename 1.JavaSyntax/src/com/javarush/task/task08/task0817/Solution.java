package com.javarush.task.task08.task0817;

import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        HashMap<String, String> famil = new HashMap<>();
        famil.put("1", "a");
        famil.put("2", "a");
        famil.put("3", "a");
        famil.put("4", "a");
        famil.put("5", "a");
        famil.put("6", "a");
        famil.put("7", "a");
        famil.put("8", "a");
        famil.put("9", "a");
        famil.put("10", "a");
        return famil;
        //напишите тут ваш код

    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        HashMap< String, String>  copy = new HashMap< >(map);
        for (Map.Entry< String, String > entry : copy.entrySet()) {
            for (Map.Entry< String, String > maps : map.entrySet()) {
                if (entry.getValue().equals(maps.getValue()) && !entry.getKey().equals(maps.getKey())) {
                    removeItemFromMapByValue(map, entry.getValue());
                    break;
                }
            }
        }
    }

            //напишите тут ваш код



    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

    }
}
