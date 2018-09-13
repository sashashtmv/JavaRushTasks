package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name = "";
        try{
            while (true){
                name = reader.readLine();
                FileInputStream fileread = new FileInputStream(name);
                fileread.close();
            }
        }catch (FileNotFoundException e){
            System.out.println(name);
        }

    }
}
