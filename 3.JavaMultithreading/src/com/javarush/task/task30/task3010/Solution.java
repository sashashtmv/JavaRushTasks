package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigInteger;

public class Solution {
    public static void main(String[] args) {
        String s = "";
        try{
            s = args[0];
        }catch (Exception e){}
        if(s.length() > 255) System.out.println("incorrect");
        else {
            int redix = 0;
            for (int i = 2; i < 37; i++) {
                BigInteger a = null;
                String str = "";
                try {
                    a = new BigInteger(s, i);
                    str = a.toString(i);
                    redix = i;
                    break;

                } catch (NumberFormatException e) {

                }
            }
            if (redix == 0) System.out.println("incorrect");
            else System.out.println(redix);
        }

        //напишите тут ваш код
    }


}