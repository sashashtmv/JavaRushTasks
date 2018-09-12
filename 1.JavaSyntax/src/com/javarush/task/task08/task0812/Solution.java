package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> digit = new ArrayList<>();
        for(int i = 0; i < 10; i++){
            digit.add(Integer.parseInt(reader.readLine()));
        }

        int count = 1;
        int temp = 1;
        int total = 1;
        for (int i = 0; i < 9; i++){
            if (digit.get(i) == digit.get(i+1)){
                count++;
            }
            if (count >= temp) temp = count;
            if(digit.get(i) != digit.get(i+1)) count = 1;
        }
        System.out.println(temp);


    }
}