package com.javarush.task.task05.task0510;

/* 
Кошкоинициация
*/

public class Cat {
    String name;
    int age;
    int weight;
    String address;
    String color;
    public void initialize(String name){
        this.name = name;
        age = 3;
        weight = 2;
        color = "black";

    }
    public void initialize(String name, int weight, int age){
        this.name = name;
        this.weight = weight;
        this.age = age;
        color = "brown";
    }
    public void initialize(String name, int age){
        this.name = name;
        weight = 5;
        this.age = age;
        color = "gray";
    }
    public void initialize(int weight, String color){
        this.weight = weight;
        age = 1;
        this.color = color;
    }
    public void initialize(int weight, String color, String address){
        this.address = address;
        this.weight = weight;
        age = 3;
        this.color = color;
    }
    //напишите тут ваш код

    public static void main(String[] args) {

    }
}
