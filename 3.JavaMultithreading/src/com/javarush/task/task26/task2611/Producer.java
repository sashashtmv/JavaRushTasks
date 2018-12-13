package com.javarush.task.task26.task2611;

import java.util.concurrent.ConcurrentHashMap;

public class Producer implements Runnable {
    private ConcurrentHashMap<String, String> map;

    public Producer(ConcurrentHashMap<String, String> map) {
        this.map = map;
    }

    public void run() {
        Thread currentThread = Thread.currentThread();
        int i = 1;
        try {
            while (true) {
                map.put(i + "", "Some text for " + i++);
                Thread.sleep(500);
            }
        } catch (InterruptedException e) {
                System.out.println("[" + currentThread.getName() + "] thread was terminated");
//            if (!map.isEmpty()) {
//                for (String key : map.keySet()) {
//                    System.out.println(map.remove(key));
//                }
//            }
        }
    }
}
