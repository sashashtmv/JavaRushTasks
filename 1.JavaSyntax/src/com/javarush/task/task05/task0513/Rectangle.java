package com.javarush.task.task05.task0513;

/* 
Собираем прямоугольник
*/

public class Rectangle {
    int left, top, width, height;
    public void initialize(int top, int left){
        this.top = top;
        this.left = left;
    }
    public void initialize(int top, int left, int width) {
        this.top = top;
        this.left = left;
        this.width = width;
        height = width;
    }
    public void initialize(int top, int left, int width, int height){
        this.top = top;
        this.left = left;
        this.width = width;
        this.height = height;
    }
    public void initialize(Rectangle rectangle) {
        top = rectangle.top;
        left = rectangle.left;
        width = rectangle.width;
        height = rectangle.height;
    }
    //напишите тут ваш код

    public static void main(String[] args) {

    }
}
