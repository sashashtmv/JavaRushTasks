package com.javarush.task.task18.task1813;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;

/* 
AmigoOutputStream
*/

public class AmigoOutputStream extends FileOutputStream{
    public static String fileName = "C:/tmp/result.txt";
    FileOutputStream files;
    public AmigoOutputStream(FileOutputStream am)throws FileNotFoundException{
        super(fileName);
        this.files = am;
    }

    @Override
    public void write(int b) throws IOException {
        files.write(b);
    }

    @Override
    public void write(byte[] b) throws IOException {
        files.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        files.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        files.flush();
    }
    @Override
    public void close() throws IOException {
        files.flush();
        files.write("JavaRush © All rights reserved.".getBytes());
        files.close();
    }

    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
    }

}
