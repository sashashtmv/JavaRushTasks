package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
        Hen hen1 = HenFactory.getHen(Country.UKRAINE);
        hen.getCountOfEggsPerMonth();
        Hen hen2 = HenFactory.getHen(Country.RUSSIA);
        hen.getCountOfEggsPerMonth();
        Hen hen3 = HenFactory.getHen(Country.MOLDOVA);
        hen.getCountOfEggsPerMonth();
    }

    static class HenFactory {

        static Hen getHen(String country) {
            Hen hen = null;
            if (country=="Ukraine")  hen = new UkrainianHen();
            if (country=="Russia") hen = new RussianHen();
            if (country=="Moldova") hen = new MoldovanHen();
            if (country=="Belarus") hen = new BelarusianHen();//напишите тут ваш код
            return hen;
        }
    }


}
