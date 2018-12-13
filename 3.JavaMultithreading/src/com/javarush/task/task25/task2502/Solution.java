package com.javarush.task.task25.task2502;

import java.util.*;

/* 
Машину на СТО не повезем!
*/
public class Solution {
    public static enum Wheel {
        FRONT_LEFT,
        FRONT_RIGHT,
        BACK_LEFT,
        BACK_RIGHT
    }

    public static class Car {
        protected List<Wheel> wheels;

        public Car() throws Exception {
            wheels = new ArrayList<>();

            if (loadWheelNamesFromDB().length == 4) {
                String[] mass = loadWheelNamesFromDB();
                for (String s : mass) {
                    wheels.add(Wheel.valueOf(s));//init wheels here
                }
            } else throw new Exception();

        }

        protected String[] loadWheelNamesFromDB() {
            //this method returns mock data
            return new String[]{"FRONT_LEFT", "FRONT_RIGHT", "BACK_LEFT", "BACK_RIGHT"};
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(new Car().wheels.toString());
    }
}
