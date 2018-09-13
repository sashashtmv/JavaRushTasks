package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args)throws IOException {
        String filename = args[0];
        FileInputStream fileread = new FileInputStream(filename);
        int count = 0;
        char[] mass = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        while (fileread.available()>0){
            char ch = (char)fileread.read();
            for(char a : mass){
                if(ch==a)count++;
            }
        }
        System.out.println(count);
        fileread.close();
    }
}
