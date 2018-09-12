package com.javarush.task.task15.task1516;

/* 
Значения по умолчанию
*/

public class Solution {

        public  int intVar;
        public  double doubleVar;
        public  Double DoubleVar;
        public  boolean booleanVar;
        public  Object ObjectVar;
        public  Exception ExceptionVar;
        public  String StringVar;
        void print(){
            System.out.println(intVar + " " + doubleVar + " " + DoubleVar + " " + booleanVar + " " + ObjectVar + " " + ExceptionVar + " " + StringVar);
        }


    public static void main(String[] args) {
        Solution test = new Solution();
        test.print();
    }
}
