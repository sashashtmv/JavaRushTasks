package com.javarush.task.task18.task1825;

import java.io.*;
import java.util.*;

/* 
Собираем файл
*/

public class Solution {
    public static void main(String[] args) throws IOException{
        //1-й способ
//        ArrayList<String> fileNames = new ArrayList<>();
//
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        String s;
//        while (!(s = reader.readLine()).equals("end")) {
//            fileNames.add(s);
//        }
//        Collections.sort(fileNames);
//        FileOutputStream fos = new FileOutputStream(fileNames.get(0).substring(0, fileNames.get(0).lastIndexOf(".")));
//        for (int i = 0; i < fileNames.size(); i++) {
//            FileInputStream fis = new FileInputStream(fileNames.get(i));
//            byte[] bytes = new byte[fis.available()];
//            fis.read(bytes);
//            fos.write(bytes);
//            fis.close();
//        }
//        fos.close();
//    }
        //2-й способ
        ArrayList<String> str = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String name;
        while (!(name=reader.readLine()).equals("end")){
            str.add(name);
        }
        Collections.sort(str);
        FileOutputStream poolwrite = new FileOutputStream(str.get(0).substring(0, str.get(0).lastIndexOf(".")));
        BufferedWriter poolbuff = new BufferedWriter(new OutputStreamWriter(poolwrite));
        for (String ss : str){
            BufferedReader readfile = new BufferedReader(new InputStreamReader(new FileInputStream(ss)));
            poolbuff.write(readfile.readLine());
            readfile.close();
        }
        poolbuff.close();
        poolwrite.close();
    }
}
