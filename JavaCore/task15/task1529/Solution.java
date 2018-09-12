package com.javarush.task.task15.task1529;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Осваивание статического блока
*/

public class Solution {
    public static void main(String[] args) {

    }
    
    static {

        reset();

        //add your code here - добавьте код тут
    }

    public static Flyable result;

    public static void reset() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s = reader.readLine();
            if (s.equals("helicopter"))result = new Helicopter();
            else if(s.equals("plane")) {
                result = new Plane(Integer.parseInt(reader.readLine()));
                reader.close();
            }
        }catch (Exception e){}//add your code here - добавьте код тут
    }
}
