package com.javarush.task.task32.task3204;

import java.io.ByteArrayOutputStream;
import java.util.Random;

/* 
Генератор паролей
*/
public class Solution {
    public static void main(String[] args) {
        ByteArrayOutputStream password = getPassword();
        System.out.println(password.toString());
    }

    public static ByteArrayOutputStream getPassword() {
        String lowercase = "abcdefghijklmnopqrstuvwxyz";
        String uppercase = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String digits = "0123456789";

        //Остальные 5 символов
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        String shuffle = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        int temp;
        while (true){
            temp = lowercase.toCharArray()[new Random().nextInt(lowercase.length()-1)];
            baos.write(temp);
            temp = uppercase.toCharArray()[new Random().nextInt(uppercase.length()-1)];
            baos.write(temp);
            for(int i = 0; i < 5; i++){
                temp = shuffle.toCharArray()[new Random().nextInt(shuffle.length()-1)];
                baos.write(temp);
            }
            temp = digits.toCharArray()[new Random().nextInt(digits.length()-1)];
            baos.write(temp);
            break;
        }
        return baos;
    }
}