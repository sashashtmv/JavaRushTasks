package com.javarush.task.task09.task0930;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<String>();
        while (true) {
            String s = reader.readLine();
            if (s.isEmpty()) break;
            list.add(s);
        }

        String[] array = list.toArray(new String[list.size()]);
        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        ArrayList<Integer> dig = new ArrayList<>();
        ArrayList<String> str = new ArrayList<>();
        for(String s : array){
            if (isNumber(s)==true) dig.add(Integer.parseInt(s));
            else str.add(s);
        }
        int temp;
        String buff;
        for(int i = 0; i < dig.size(); i++){
            for(int j = 0; j < dig.size()-i-1; j++){
                if(dig.get(j)< dig.get(j+1)){
                    temp = dig.get(j);
                    dig.set(j,dig.get(j+1));
                    dig.set(j+1,temp);
                }
            }
        }
        for(int i = 0; i < str.size(); i++){
            for(int j = 0; j < str.size() - i - 1; j++){
                if(isGreaterThan(str.get(j),str.get(j+1))){
                    buff = str.get(j);
                    str.set(j, str.get(j+1));
                    str.set(j+1, buff);
                }
            }
        }
        int k = 0;
        int l = 0;
        for(int i = 0; i < array.length; i++){
            if(isNumber(array[i])==true) {
                array[i] = dig.get(k).toString();
                k++;
            }
            else {
                array[i] = str.get(l);
                l++;
            }
        }
        //напишите тут ваш код
    }

    // Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }


    // Переданная строка - это число?
    public static boolean isNumber(String s) {
        if (s.length() == 0) return false;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if ((i != 0 && c == '-') // есть '-' внутри строки
                    || (!Character.isDigit(c) && c != '-')) // не цифра и не начинается с '-'
            {
                return false;
            }
        }
        return true;
    }
}
