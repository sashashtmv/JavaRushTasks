package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.kitchen.Dish;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsoleHelper {

    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() throws IOException {
        return reader.readLine();
    }

    public static List<Dish> getAllDishesForOrder() throws IOException {
        List<Dish> list = new ArrayList<>();
        //выводим на экран все доступные блюда
        writeMessage(Dish.allDishesToString());
        writeMessage("Введите название блюда");
        String temp = "";
        String[] mas = Dish.allDishesToString().substring(1,Dish.allDishesToString().length()-1 ).split(", ");
        while (true) {

                temp = readString();

            if(temp.equals("exit"))break;
            if(Arrays.asList(mas).contains(temp)){
                //добавляем выбранные блюда в список
                    list.add(Dish.values()[Arrays.asList(mas).indexOf(temp)]);
            }else writeMessage("Такого блюда нет, введите другое блюдо");

        }
        return list;
    }
}
