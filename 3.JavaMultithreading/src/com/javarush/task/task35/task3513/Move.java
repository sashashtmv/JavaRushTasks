package com.javarush.task.task35.task3513;

//аннотацией @FunctionalInterface будем сигнализировать о том что в этом интерфейсе будет только один абстрактный метод
@FunctionalInterface
public interface Move {
    void move();
}
