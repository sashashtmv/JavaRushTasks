package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        Thread threadOne = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o1){

                    try {
                        Thread.sleep(1);
                    }
                    catch (InterruptedException e){

                    }
                    synchronized (o2){

                    }
                }
            }
        });

        Thread threadTwo = new Thread(new Runnable() {
            @Override
            public void run() {

                solution.someMethodWithSynchronizedBlocks(o1,o2);

            }
        });

        threadOne.start();

        threadTwo.start();

        Thread.sleep(2);

        if(threadTwo.getState() != Thread.State.BLOCKED){
            return true;
        }
        else return false;

    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();
        for (int i = 0; i < 10000; i++) {
            System.out.println(isNormalLockOrder(solution, o1, o2));
        }
    }
}
