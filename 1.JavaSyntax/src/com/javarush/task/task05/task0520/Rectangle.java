package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    int top, left, width, height;
    public Rectangle(int top, int left, int width, int height){
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }
    public Rectangle(int top, int left){
        this.top = top;
        this.left = left;
    }
    public Rectangle(int top, int left, int width){
        this.top = top;
        this.left = left;
        this.width = width;
        height = width;
    }
    public Rectangle(Rectangle rectangle){
        top = rectangle.top;
        left = rectangle.left;
        width = rectangle.width;
        height = rectangle.height;
    }
    //напишите тут ваш код

    public static void main(String[] args) {

    }
}
