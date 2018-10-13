package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;
    static Hippodrome game;

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public void move(){
        for(Horse horse : horses){
            horse.move();
            horse.print();
        }
    }

    public void run(){
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void print(){
        for(Horse horse : horses){
            horse.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }

    public Horse getWinner(){
        double result = 0;
        int num = 0;
        for(int i = 0; i < horses.size(); i++){
            if(horses.get(i).getDistance() > result) {
                result = horses.get(i).getDistance();
                num = i;
            }
        }

        return horses.get(num);
    }

    public void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<>());
        game.getHorses().add(new Horse("Belka", 3, 0));
        game.getHorses().add(new Horse("Strelka", 3,0));
        game.getHorses().add(new Horse("Burka", 3,0));

        game.run();
        game.printWinner();
    }
}
