package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    int a;
    int b;
    String s;
    public static void main(String[] args) {

    }
    protected Solution(int a){
        this.a = a;
    }
    public Solution(){}
    Solution(int b, String s){
        this.b = b;
        this.s = s;
    }
    private Solution(int a, int b){
        this.a = a;
        this.b = b;
    }

}

