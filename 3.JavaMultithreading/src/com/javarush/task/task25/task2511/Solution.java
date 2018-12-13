package com.javarush.task.task25.task2511;

import java.util.TimerTask;

/* 
Вооружаемся до зубов!
*/
public class Solution extends TimerTask {
    protected TimerTask original;
    protected final Thread.UncaughtExceptionHandler handler;

    public Solution(TimerTask original) {
        if (original == null) {
            throw new NullPointerException();
        }
        this.original = original;
        this.handler = new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                String res = "";
                int count = t.getName().length();
                for (int i = 0; i < count; i++) {
                    res += "*";
                }
                String[] message = (e.getMessage() + " ").split(t.getName());
                String result = "";
                for (int i = 0; i < message.length; ++i) {
                    result += message[i];
                    if (i != message.length - 1) {
                        result += res;
                    }
                }
                System.out.println(result.trim());
            }
        };    //init handler here
    }

    public void run() {
        try {
            original.run();
        } catch (Throwable cause) {
            Thread currentThread = Thread.currentThread();
            handler.uncaughtException(currentThread, new Exception("Blah " + currentThread.getName() + " blah-blah-blah" + currentThread.getName(), cause));
        }
    }

    public long scheduledExecutionTime() {
        return original.scheduledExecutionTime();
    }

    public boolean cancel() {
        return original.cancel();
    }

    public static void main(String[] args) {
        Thread thread = new Thread(new Solution(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
                System.out.println(5 / 0);
            }
        }));
        thread.start();
    }
}