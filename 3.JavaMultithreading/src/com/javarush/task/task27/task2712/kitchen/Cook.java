package com.javarush.task.task27.task2712.kitchen;

import com.javarush.task.task27.task2712.ConsoleHelper;
import com.javarush.task.task27.task2712.statistic.StatisticManager;
import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;

import java.util.Observable;
import java.util.concurrent.LinkedBlockingQueue;


public class Cook extends Observable implements Runnable{
    private  String name;
    private LinkedBlockingQueue queue;
    private volatile boolean caught = false;


    public Cook(String name) {
        this.name = name;

    }

    @Override
    public String toString() {
        return name;
    }

    public void startCookingOrder(Order order) {

        ConsoleHelper.writeMessage("Start cooking - " + order);
        StatisticManager.getInstance().register(new CookedOrderEventDataRow(order.getTablet().toString(),
                name, order.getTotalCookingTime()*60, order.getDishes()));

        try {
            Thread.sleep(order.getTotalCookingTime() * 10);
        } catch (InterruptedException e) {
            caught = true;
        }

        setChanged();
        notifyObservers(order);

    }

    public void setQueue(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                startCookingOrder((Order)queue.take());
            }
            catch (InterruptedException e) {}
            try {
                Thread.sleep(10);
            }
            catch (InterruptedException e) {
                caught = true;
            }
            if (caught && queue.isEmpty()) break;
        }
    }
}
