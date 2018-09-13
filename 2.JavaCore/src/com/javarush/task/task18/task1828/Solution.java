package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();
        ArrayList<String> arr = new ArrayList<>();
        String s;
        BufferedReader readfile = new BufferedReader(new FileReader(filename));
        while ((s = readfile.readLine())!=null){
            arr.add(s);
        }

        if (args[0].equals("-u")){

            String id= args[1];
            if(id.length()<8){
                while (id.length() < 8)
                    id = id+" ";
            }
            String productName = args[2];
            if(productName.length()<30) {
                while (productName.length() < 30)
                    productName = productName+" ";
            }

            String price = args[3];
            if(price.length()<8) {
                while (price.length() < 8)
                    price = price+" ";
            }

            String quantity = args[4];
            if(quantity.length()<4) {
                while (quantity.length() < 4)
                    quantity = quantity+" ";
            }
            for(int i = 0; i< arr.size(); i++){
                if(arr.get(i).substring(0,8).trim().equals(args[1])){
                    arr.set(i,(id+productName + price + quantity));
                }
            }
            BufferedWriter buff = new BufferedWriter(new FileWriter(filename));
            for(String st : arr){
                buff.write(st);
                buff.newLine();
            }
            buff.close();
            readfile.close();
            reader.close();
        }
        if(args[0].equals("-d")){
            for(int i = 0; i< arr.size(); i++){
                if(arr.get(i).substring(0,8).trim().equals(args[1])){
                    arr.remove(i);
                }
            }
            BufferedWriter buff = new BufferedWriter(new FileWriter(filename));
            for(String st : arr){
                buff.write(st);
                buff.newLine();
            }
            buff.close();
        }
    }
}
