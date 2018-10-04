package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable {
        private static final String PATH = "path.txt";
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //File your_file_name = File.createTempFile("your_file_name", null);
        OutputStream outputStream = new FileOutputStream(PATH);
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);

        Solution savedObject = new Solution();
        oos.writeObject(savedObject);
        InputStream inputStream = new FileInputStream(PATH);
        ObjectInputStream ois = new ObjectInputStream(inputStream);
        Solution loadedObject = (Solution) ois.readObject();
        System.out.println((savedObject.string)==(loadedObject.string));
        System.out.println(new Solution(4));
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }
    public Solution(){}


    @Override
    public String toString() {
        return this.string;
    }
}
