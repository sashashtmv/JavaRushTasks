package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {

            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            HashMap<String, Integer> hash = new HashMap<>();
            while (true){
                String strid = reader.readLine();
                if(strid.isEmpty()) break;
                String name = reader.readLine();
                int id = Integer.parseInt(strid);
                hash.put(name,id);
            }

            for (Map.Entry<String, Integer> pair : hash.entrySet()) {
                int id = pair.getValue();
                String name = pair.getKey();
                System.out.println(id + " " + name);
            }

    }
}
