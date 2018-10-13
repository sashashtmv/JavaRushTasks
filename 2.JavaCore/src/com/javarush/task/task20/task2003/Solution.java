package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            FileInputStream fis = new FileInputStream(reader.readLine());
            load(fis);

        } catch (Exception e) {
            e.printStackTrace();
        }

        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        PrintWriter ps = new PrintWriter(outputStream);
        Properties pr = new Properties();

        if (!properties.isEmpty()) {
            for (Map.Entry entry : properties.entrySet()) {
                pr.setProperty(entry.getKey().toString(), entry.getValue().toString());
            }
        }

        pr.store(ps, "");

        ps.flush();
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        Properties pr = new Properties();
        pr.load(inputStream);

        for (final String name: pr.stringPropertyNames())
            properties.put(name, pr.getProperty(name));

        inputStream.close();
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) {
        System.getProperties().list(System.out); // листинг демонстрируют вывод всех системных свойств Java.
    }
}
