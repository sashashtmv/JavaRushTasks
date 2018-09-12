package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream file1read = new FileInputStream(file1);
        FileOutputStream file2write = new FileOutputStream(file2);
        BufferedReader bufr = new BufferedReader(new InputStreamReader(file1read));
        String str;
        while ((str = bufr.readLine())!=null){
            String[] numbers = str.split(" ");

            for(String num : numbers)
            {
                int res = (int)Math.round(Double.parseDouble(num));
                file2write.write((res + " ").getBytes());
            }
        }



        reader.close();
        file1read.close();
        file2write.close();
        bufr.close();
    }
}
