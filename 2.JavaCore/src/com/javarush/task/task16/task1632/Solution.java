package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Thred1());
        threads.add(new Thred2());
        threads.add(new Thred3());
        threads.add(new Thred4());
        threads.add(new Thred5());

    }
    public static void main(String[] args) {
    }

    public static class Thred4 extends Thread implements Message{
        public boolean isAliev = false;
        public void showWarning(){
            isAliev=true;
        }
        public void run(){
            while (!isAliev){}
        }
    }
    public static class Thred1 extends Thread{
        public void run(){
            while (true){}
        }
    }
    public static class Thred2 extends Thread{
        public void run(){
            try{
                Thread.sleep(500);
            }catch (InterruptedException e) {
                System.out.println("InterruptedException");
            }
        }
    }
    public static class Thred3 extends Thread{
        public void run(){
            try{while (true) {
                System.out.println("Ура");
                Thread.sleep(500);
            }
            }catch (InterruptedException e){}
        }
    }
    public static class Thred5 extends Thread{
        public void run(){
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String s;
            int sum=0;
            try {
                while (true){
                    s = reader.readLine();
                    if (s.equals("N")) break;
                    else sum += Integer.parseInt(s);

                }
            }catch (IOException e){}
            System.out.println(sum);
        }
    }
}