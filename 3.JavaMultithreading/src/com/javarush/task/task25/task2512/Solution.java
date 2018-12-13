package com.javarush.task.task25.task2512;

import java.util.ArrayList;

/*
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {



//рабочий код
    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        ArrayList<Throwable> ar = new ArrayList<>();
        while (true){
            ar.add(e);
            e = e.getCause();
            if(e == null)break;
        }
        for (int i = ar.size()-1; i >= 0 ; i--) {
            System.out.println(ar.get(i));
        }
    //    method(e);
    }
//2-й способ решения через рекурсию
    public static void method(Throwable cause) {
        if (cause == null) return;
        method(cause.getCause());
        System.out.println(cause.toString());

    }

    public static void main(String[] args) {
        // создаем обработчик исключений для нитей
        Thread t = new Thread() {
            @Override
            public void run() {
                throw new RuntimeException("ABC", new Exception("DEF", new IllegalAccessException("GHI")));
            }
        };
        t.setUncaughtExceptionHandler(new Solution());
        t.start();
    }

}
