package com.javarush.task.task25.task2514;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
Первый закон Финэйгла: если эксперимент удался, что-то здесь не так...
*/
public class Solution {
    public static class YieldRunnable implements Runnable {
        private int index;

        public YieldRunnable(int index) {
            this.index = index;
        }

        public void run() {
            System.out.println("begin-" + index);
            //Thread.yield();
            System.out.println("end-" + index);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            new Thread(new YieldRunnable(i)).start();
        }

//        ExecutorService service = Executors.newCachedThreadPool();
//        for (int i = 1; i <= 100; i++) {
//            service.execute(new YieldRunnable(i));
//        }
//        service.shutdown();
    }
}