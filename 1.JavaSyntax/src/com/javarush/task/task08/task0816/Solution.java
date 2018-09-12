package com.javarush.task.task08.task0816;

import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        map.put("Vasin", new Date("JUNE 1 1978"));
        map.put("Herz", new Date("JUNE 1 1980"));
        map.put("Marshal", new Date("JUNE 1 1978"));
        map.put("Perry", new Date("JUNE 1 1980"));
        map.put("Jerry", new Date("JUNE 1 1978"));
        map.put("Markus", new Date("JUNE 1 1980"));
        map.put("Valerio", new Date("JUNE 1 1978"));
        map.put("Angel", new Date("JUNE 1 1980"));
        map.put("Gabriel", new Date("JUNE 1 1978"));
        return map;
        //напишите тут ваш код
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        ArrayList <String> removelist = new ArrayList<>();
        for (Map.Entry<String, Date> pair: map.entrySet()){
            Date date = pair.getValue();
            int m = date.getMonth();
            if (m>4 && m<8) {
                removelist.add(pair.getKey());
            }
        }
        for (String key: removelist){
            map.remove(key);
        }



            //напишите тут ваш код

    }

    public static void main(String[] args) {

    }
}
