package com.javarush.task.task19.task1904;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {
        private static Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
           this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String res = reader.readLine();
            String[] mass = res.split(" ");
            return new Person(mass[1], mass[2], mass[0], new Date(Integer.parseInt(mass[3]), Integer.parseInt(mass[4]), Integer.parseInt(mass[5])));
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();

        }
    }
}
