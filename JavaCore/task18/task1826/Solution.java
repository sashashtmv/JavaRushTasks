package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[1];
        String fileOutputName = args[2];
        FileInputStream fileread = new FileInputStream(fileName);
        FileOutputStream filewrite = new FileOutputStream(fileOutputName);
        if(args[0]=="-e"){
            while (fileread.available()>0){
                int a = fileread.read() + 7;
                filewrite.write(a);
            }
        }else if(args[0]=="-d"){
            while (fileread.available()>0){
                int a = fileread.read()-7;
                filewrite.write(a);
            }
        }
        fileread.close();
        filewrite.close();
    }

}
