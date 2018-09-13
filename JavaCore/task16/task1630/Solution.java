package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    static {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
        }catch (IOException e){}
    }
    //add your code here - добавьте код тут

    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();//add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface{
        private String fileName;
        private String fileContent = "";
        public void setFileName(String fullFileName){fileName = fullFileName;};

        public String getFileContent(){
            return fileContent;
        }
        public void run(){
            StringBuilder s=new StringBuilder();
            try(BufferedReader reader=new BufferedReader(new FileReader(new File(fileName)))){
                while(reader.ready())s.append(reader.readLine()).append(" ");
            }catch(IOException e){}
            fileContent=s.toString();
        }


    }
    //add your code here - добавьте код тут
}
