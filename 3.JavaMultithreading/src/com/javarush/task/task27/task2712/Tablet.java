package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.AdvertisementManager;
import com.javarush.task.task27.task2712.ad.NoVideoAvailableException;
import com.javarush.task.task27.task2712.kitchen.Order;
import com.javarush.task.task27.task2712.kitchen.TestOrder;

import java.io.IOException;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Tablet {
    final int number;
    static Logger logger = Logger.getLogger(Tablet.class.getName());
    private LinkedBlockingQueue queue;

    public void setQueue(LinkedBlockingQueue queue) {
        this.queue = queue;
    }

    public Tablet(int number) {
        this.number = number;

    }

    public Order createOrder() {
        Order order = null;
        try {
            order = new Order(this);
            processOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
        return order;
    }

    private void processOrder(Order order) {
        //если в заказе нет блюд, он не отправлялся повару
        if (!order.isEmpty()) {
            ConsoleHelper.writeMessage(order.toString());
            try {
                queue.put(order);
            } catch (InterruptedException e) {

            }
            //флаг говорит о том, что объект Observable изменен
            //setChanged();
            //сообщает объектам Observer(слушателям) о том, что произошли изменения
            //notifyObservers(order);

            //вызываем показ рекламы, пока готовится заказ
            AdvertisementManager manager = new AdvertisementManager(order.getTotalCookingTime() * 60);
            try {

                manager.processVideos();
            } catch (NoVideoAvailableException e) {
                logger.log(Level.INFO, "No video is available for the order " + order);
            }

        }
    }

    public void createTestOrder()  {
        TestOrder order = null;
        try {
            order = new TestOrder(this);
            processOrder(order);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Console is unavailable.");
        }
    }

    @Override
    public String toString() {
        return "Tablet{number=" + number + "}";
    }


}
