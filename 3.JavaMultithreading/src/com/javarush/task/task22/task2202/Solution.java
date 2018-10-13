package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
    }

    public static String getPartOfString(String string) {
        String res = "";
        int index = 0;
        int count = 0;
        try {
            char[] temp = string.toCharArray();
            for (int i = 0; i < temp.length; i++) {
                if (temp[i] == ' ') {
                    count++;
                    if (count == 5) index = i;
                }
            }
            if(count < 4) throw new TooShortStringException();
            if (count > 4) {
                res = string.substring(string.indexOf(" ") + 1, index);
            } else {
                res = string.substring(string.indexOf(" ") + 1);
            }
        }catch (Exception e){
            throw new TooShortStringException();
        }
        return res;
    }

    public static class TooShortStringException extends RuntimeException {
    }
}
