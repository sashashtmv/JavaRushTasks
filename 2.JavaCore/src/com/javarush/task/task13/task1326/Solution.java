package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = reader.readLine();
        InputStream inStream = new FileInputStream(name);

        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader in = new BufferedReader(new InputStreamReader(inStream));

            while (in.ready()) {
                int i = Integer.parseInt(in.readLine());
                if (i % 2 == 0)
                    list.add(i);
            }
        Collections.sort(list);
        for(int i: list) System.out.println(i);
        inStream.close();
    }
}
