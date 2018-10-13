package com.javarush.task.task21.task2106;

import java.util.Date;
import java.util.Objects;

/* 
Ошибка в equals/hashCode
*/
public class Solution {
    private int anInt;
    private String string;
    private double aDouble;
    private Date date;
    private Solution solution;

    public Solution(int anInt, String string, double aDouble, Date date, Solution solution) {
        this.anInt = anInt;
        this.string = string;
        this.aDouble = aDouble;
        this.date = date;
        this.solution = solution;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Solution))
            return false;

        if (this == o) return true;

        Solution solution1 = (Solution) o;

        if(aDouble != solution1.aDouble) return false;
        if(anInt != solution1.anInt) return false;
        if(date != solution1.date) return  false;
        if(solution != solution1.solution) return false;
        if(string != solution1.string) return false;
        return true;

//        return Objects.equals(anInt, solution1.anInt) &&
//                Objects.equals(string, solution1.string)&&
//                Objects.equals(aDouble, solution1.aDouble) &&
//                Objects.equals(solution, solution1.solution) &&
//                Objects.equals(date, solution1.date);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = anInt;
        temp = aDouble != +0.0d ? Double.doubleToLongBits(aDouble) : 0L;
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + (solution != null ? solution.hashCode() : 0);
        return result;
        //return Objects.hash(anInt, string, aDouble, solution, date);
    }

    public static void main(String[] args) {

    }
}
