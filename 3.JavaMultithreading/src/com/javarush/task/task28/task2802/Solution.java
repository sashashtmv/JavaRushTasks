package com.javarush.task.task28.task2802;


import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* 
Пишем свою ThreadFactory
*/
public class Solution {

    public static void main(String[] args) {
        class EmulateThreadFactoryTask implements Runnable {
            @Override
            public void run() {
                emulateThreadFactory();
            }
        }

        ThreadGroup group = new ThreadGroup("firstGroup");
        Thread thread = new Thread(group, new EmulateThreadFactoryTask());

        ThreadGroup group2 = new ThreadGroup("secondGroup");
        Thread thread2 = new Thread(group2, new EmulateThreadFactoryTask());

        thread.start();
        thread2.start();
    }

    private static void emulateThreadFactory() {
        AmigoThreadFactory factory = new AmigoThreadFactory();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName());
            }
        };
        factory.newThread(r).start();
        factory.newThread(r).start();
        factory.newThread(r).start();
    }

    public static class AmigoThreadFactory implements ThreadFactory{
        private  static AtomicInteger factory = new AtomicInteger(1);
        private  AtomicInteger thread = new AtomicInteger(1);
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();


            int a = factory.getAndIncrement();
        @Override
        public Thread newThread(Runnable r) {
            Thread th = new Thread(threadGroup, r);
            th.setName(threadGroup.getName() + "-pool-" + a + "-thread-" + thread.getAndIncrement());
            th.setDaemon(false);
            th.setPriority(5);
            return th;
        }
    }
}
