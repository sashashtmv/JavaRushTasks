package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;

public class Solution {
    public static void main(String[] args) throws IOException{
        String filename = args[0];
        FileInputStream fileread = new FileInputStream(filename);
        int count = 0;
        int count1 = 0;
        char mass = ' ';
        while (fileread.available()>0){
            char ch = (char)fileread.read();
                if(ch==mass)count++;
                else count1++;
        }
        if(count1==0){}
        else System.out.println(new BigDecimal((float) count/(count1+count)*100).setScale(2,BigDecimal.ROUND_HALF_UP));
        // System.out.format("%.2f",((double) count / (count+count1) * 100.00)))
        fileread.close();
    }
}
