package com.javarush.task.task13.task1322;

/* 
Интерфейс SimpleObject
*/

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Object;

public class Solution {
    public static void main(String[] args) throws Exception {
        SimpleObject<String> stringObject = new StringObject<Object>();
    }

    interface SimpleObject<T> {
        SimpleObject<T> getInstance();
    }
    public static class StringObject<Object> implements SimpleObject{
        public  SimpleObject<String> getInstance(){
            return  this;
        }

    }

}
