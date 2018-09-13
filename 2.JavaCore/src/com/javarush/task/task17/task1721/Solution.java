package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution  {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedReader buf1 = new BufferedReader(new FileReader(reader.readLine()));
        BufferedReader buf2 = new BufferedReader(new FileReader(reader.readLine()));
        String line;
        while ((line = buf1.readLine()) != null){
            allLines.add(line);
        }
        while ((line = buf2.readLine()) != null){
            forRemoveLines.add(line);
        }
        new Solution().joinData();
        reader.close();
        buf1.close();
        buf2.close();

        }

    public synchronized void joinData () throws CorruptedDataException {
        if(allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);
        }
        else {
            allLines.clear();
            throw new CorruptedDataException();
        }
    }
}
