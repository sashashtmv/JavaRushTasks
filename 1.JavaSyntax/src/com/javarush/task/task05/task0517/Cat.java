package com.javarush.task.task05.task0517;

/* 
Конструируем котиков
*/

public class Cat {
    String name, address, color;
    int age, weight;
    public Cat(String name){
        this.name = name;
        color = "black";
        age = 2;
        weight = 3;
    }
    public Cat(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        color = "gray";
    }
    public Cat(String name, int age){
        this.name = name;
        this.age = age;
        color = "brown";
        weight = 4;
    }
    public Cat(int weight, String color){
        this.weight = weight;
        this.color = color;
        age = 2;
    }
    public Cat(int weight, String color, String address){
        this.weight = weight;
        this.color = color;
        this.address = address;
        age = 4;
    }
    //напишите тут ваш код

    public static void main(String[] args) {

    }
}
