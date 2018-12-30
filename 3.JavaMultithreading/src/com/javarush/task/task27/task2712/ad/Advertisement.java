package com.javarush.task.task27.task2712.ad;

public class Advertisement {
//    Object content - видео
//    String name - имя/название
//    long initialAmount - начальная сумма, стоимость рекламы в копейках. Используем long, чтобы избежать проблем с округлением
//    int hits - количество оплаченных показов
//    int duration - продолжительность показа рекламы в секундах
    //long amountPerOneDisplaying - стоимость одного показа рекламы

    private Object content;
    private String name;
    private long initialAmount;
    private int hits;
    private int duration;
    private long amountPerOneDisplaying;

    public Advertisement(Object content, String name, long initialAmount, int hits, int duration) {
        this.content = content;
        this.name = name;
        this.initialAmount = initialAmount;
        this.hits = hits;
        this.duration = duration;
        this.amountPerOneDisplaying = (hits > 0) ? initialAmount / hits : 0;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public long getAmountPerOneDisplaying() {
        return amountPerOneDisplaying;
    }

    public void revalidate(){
        if(hits < 1){
            throw new UnsupportedOperationException();
        }
        hits--;
    }
    public int getHits() {
        return hits;
    }

}
