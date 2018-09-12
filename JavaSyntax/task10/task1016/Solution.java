package com.javarush.task.task10.task1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Одинаковые слова в списке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            words.add(reader.readLine());
        }

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        String str;
        int j = 0;

        for(int i = 0; i < list.size(); i++){
            str = list.get(i);
            for (int k = 0; k < list.size(); k++){
                if(str.equals(list.get(k))){
                    j++;//напишите тут ваш код
                }
            }
            if (result.containsKey(str)) {
                j=0;
                continue;
            }
            else result.put(str, j);
            j=0;
        }//напишите тут ваш код


        return result;
    }

}

