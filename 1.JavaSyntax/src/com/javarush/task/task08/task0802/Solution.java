package com.javarush.task.task08.task0802;

/* 
HashMap из 10 пар
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        HashMap<String, String> sets = new HashMap<>();
        sets.put("арбуз", "ягода");
        sets.put("банан", "трава");
        sets.put("вишня", "ягода");
        sets.put("груша", "фрукт");
        sets.put("дыня", "овощ");
        sets.put("ежевика", "куст");
        sets.put("жень-шень", "корень");
        sets.put("земляника", "ягода");
        sets.put("ирис", "цветок");
        sets.put("картофель", "клубень");
        for (Map.Entry<String, String> pair : sets.entrySet())
        {
            String key = pair.getKey();                      //ключ
            String value = pair.getValue();                  //значение
            System.out.println(key + " - " + value);
        }

        //напишите тут ваш код

    }
}
