package com.javarush.task.task22.task2208;

import java.util.HashMap;
import java.util.Map;

/* 
Формируем WHERE
*/
public class Solution {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
//почему-то происходит автосортировка ключуй от старшего к меньшему. Сразу сравнивается количество букв в слове,
// если букв одинаково, то по старшенству последней буквы
        map.put("name", "ivanov");
        map.put("country", "ukraine");
        map.put("city", "kiev");
        map.put("age", null);


        System.out.println(getQuery(map));

    }
    public static String getQuery(Map<String, String> params) {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> pair : params.entrySet()){
            String key = pair.getKey();
            String value = pair.getValue();
            if ((value != null)&&(key != null)){
                result.append(String.format("%s = '%s' and ", key, value));
            }
        }
        if(result.length() > 5) result.delete(result.length()-5, result.length()-1);

        return result.toString().trim();
    }
}
