package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException{
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename;
        while (!(filename=reader.readLine()).equals("exit")){
            ReadThread a = new ReadThread(filename);
            a.start();
        }
    }

    public static class ReadThread extends Thread {
        String fileName;
        //ArrayList<Integer> list = new ArrayList<>();
        public ReadThread(String fileName)  {
            this.fileName = fileName;

            //implement constructor body
        }
        public void run(){
            //1-й способо
//            try {
//                FileInputStream fileread = new FileInputStream(fileName);
//                while (fileread.available() > 0) {
//                    int a = fileread.read();
//                    list.add(a);
//                }
//                fileread.close();
//            }catch (IOException e){}
//                int buf = list.get(0);
//                for(int i : list){
//                    if(Collections.frequency(list,buf)< Collections.frequency(list, i)){
//                        buf = i;
//                    }
//                }
//                resultMap.put(fileName, buf);

//2-й способ
            HashMap<Integer, Integer> map = new HashMap<>();
            try {
                FileInputStream fileread = new FileInputStream(fileName);
                while (fileread.available()>0){
                    int a = fileread.read();
                    if(map.get(a)!=null){
                        map.put(a,map.get(a)+1);
                    }else map.put(a,1);
                }
                int buf = 0;
                for(HashMap.Entry entry : map.entrySet()){

                    if(buf < (int)entry.getValue())buf = (int)entry.getValue();
                }
                for(HashMap.Entry entry : map.entrySet()){

                    if(buf == (int)entry.getValue())resultMap.put(fileName,(int)entry.getKey());
                }
                fileread.close();
            }catch (IOException e){}
        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
