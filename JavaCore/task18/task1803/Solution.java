package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileInputStream read = new FileInputStream(reader.readLine());
        ArrayList<Integer> buf = new ArrayList<>();
        while (read.available()>0){
            int data = read.read();
             buf.add(data);
        }
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        Integer am;
        for (Integer i : buf) {

            am = hm.get(i);
            hm.put(i, am == null ? 1 : am + 1);
        }
        int maximum=0;
        for (int value : hm.values()) {
            if(value > maximum) maximum = value;
        }
        for (Map.Entry entry : hm.entrySet()) {
            if (entry.getValue().equals(maximum)) {
                System.out.print(entry.getKey() + " ");
            }

        }
        reader.close();
        read.close();

    }
}
