package com.javarush.task.task25.task2506;

public class LoggingStateThread extends Thread {
    Thread loging;

    public LoggingStateThread(Thread loging) {
        this.loging = loging;
    }

    @Override
    public void run() {
        Thread.State pts = null;
        while (true){
            Thread.State ts = loging.getState();

            if(ts!=pts) {
                System.out.println(ts);
                pts = ts;

            }
            if(loging.getState() == State.TERMINATED) break;

        }
    }
}
