package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String filename = reader.readLine();

        if (args[0].equals("-c")){
            BufferedReader readers = new BufferedReader(new FileReader(filename));
            String id="";
            int max = 0;
            while (readers.ready()) {
                id = readers.readLine().substring(0, 8).trim();
                if (Integer.parseInt(id) > max) max = Integer.parseInt(id);
            }
            readers.close();
            id = "" + (max+1);
            if(id.length()<8){
                while (id.length() < 8)
                    id = id+" ";
            }
            String productName = args[1];
            if(productName.length()<30) {
                while (productName.length() < 30)
                productName = productName+" ";
            }

            String price = args[2];
            if(price.length()<8) {
                while (price.length() < 8)
                    price = price+" ";
            }

            String quantity = args[3];
            if(quantity.length()<4) {
                while (quantity.length() < 4)
                    quantity = quantity+" ";
            }
            BufferedWriter buff = new BufferedWriter(new FileWriter(filename,true));
            buff.newLine();
            buff.write(id+productName+price+quantity);
            reader.close();
            buff.close();
        }
    }
}
