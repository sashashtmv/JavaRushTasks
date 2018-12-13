package com.javarush.task.task25.task2508;

public class TaskManipulator implements Runnable, CustomThreadManipulator {
    private Thread t;
    @Override
    public void start(String threadName) {
        t = new Thread(this, threadName);
        t.start();

    }

    @Override
    public void stop() {
        t.interrupt();
    }

    @Override
    public void run() {
        Thread t = Thread.currentThread();
        while (!t.isInterrupted()) {
                System.out.println(t.getName());
            try {
                t.sleep(100);
            } catch (InterruptedException e) {
            }
        }
    }
}
