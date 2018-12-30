package com.javarush.task.task27.task2712;

import com.javarush.task.task27.task2712.ad.StatisticAdvertisementManager;
import com.javarush.task.task27.task2712.statistic.StatisticManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

public class DirectorTablet {

    private DateFormat df = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
    //какую сумму заработали на рекламе, сгруппировать по дням;
    public void printAdvertisementProfit() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        double totalAmount = 0;
        for (Map.Entry<Date, Double> profitOfDay : StatisticManager.getInstance().getAdvertisementProfit().entrySet()) {
            Date date = profitOfDay.getKey();
            Double amount = profitOfDay.getValue();
            totalAmount += amount;
            ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "%s - %.2f", sdf.format(date), amount));
        }
        ConsoleHelper.writeMessage(String.format(Locale.ENGLISH, "Total - %.2f", totalAmount));

    }
    //загрузка (рабочее время) повара, сгруппировать по дням

    public void printCookWorkloading() {
        for (Map.Entry<Date, Map<String, Integer>> entry : StatisticManager.getInstance().getCookWorkloading().entrySet()) {
            ConsoleHelper.writeMessage(df.format(entry.getKey()));
            for (Map.Entry<String, Integer> cooksEntry : entry.getValue().entrySet())
            {
                ConsoleHelper.writeMessage(String.format("%s - %d min", cooksEntry.getKey(), cooksEntry.getValue()));
            }
            ConsoleHelper.writeMessage("");
        }
    }
    //список активных роликов и оставшееся количество показов по каждому
    public void printActiveVideoSet(){
        TreeMap<String,Integer> map = StatisticAdvertisementManager.getInstance().getActiveAdvertisement();
        for(Map.Entry<String,Integer> entry : map.entrySet())
        {
                ConsoleHelper.writeMessage(entry.getKey() + " - " + entry.getValue());
        }
    }
    //список неактивных роликов (с оставшемся количеством показов равным нулю)
    public void printArchivedVideoSet(){
        TreeMap<String,Integer> map = StatisticAdvertisementManager.getInstance().getNotActiveAdvertisement();
        ArrayList<String> list = new ArrayList<>();
        for(Map.Entry<String,Integer> entry : map.entrySet())
        {
            list.add(entry.getKey());
        }
        //дополнительная сортировка на то, чтобы не учитывался регистр при сортировки по алфавиту
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareToIgnoreCase(o2);
            }
        });
        for(String s : list){
            ConsoleHelper.writeMessage(s);
        }
    }
}
