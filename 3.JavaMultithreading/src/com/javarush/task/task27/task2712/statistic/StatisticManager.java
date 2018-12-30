package com.javarush.task.task27.task2712.statistic;

import com.javarush.task.task27.task2712.statistic.event.CookedOrderEventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventDataRow;
import com.javarush.task.task27.task2712.statistic.event.EventType;
import com.javarush.task.task27.task2712.statistic.event.VideoSelectedEventDataRow;

import java.util.*;

public class StatisticManager {
    private static StatisticManager ourInstance = new StatisticManager();
        private StatisticStorage statisticStorage = new StatisticStorage();


    public static StatisticManager getInstance() {
        return ourInstance;
    }

    private StatisticManager() {

    }

    //будет регистрировать событие в хранилище
    public void register(EventDataRow data){

        statisticStorage.put(data);
    }

    private class StatisticStorage{
        //будет хранить данные о событиях EventType
        private Map<EventType, List<EventDataRow>> storage;

        public StatisticStorage() {
                storage = new HashMap<>();
            for(EventType eventType : EventType.values()){
                storage.put(eventType, new ArrayList<>());
            }
        }

        private void put(EventDataRow data){
            if (data == null) return;
            storage.get(data.getType()).add(data);
        }
        //чтобы получить доступ к данным
        private List<EventDataRow> get(EventType type) {
            return storage.get(type);
        }
    }

    public Map<Date,Double> getAdvertisementProfit() {
        List<EventDataRow> eventDataRowList = statisticStorage.get(EventType.SELECTED_VIDEOS);


        Map<Date,Double> result = new TreeMap<>(Collections.reverseOrder());
        Date dateWithOutTime;
        Calendar calendar;
        double amount;

        for( EventDataRow eventDataRow : eventDataRowList) {

            VideoSelectedEventDataRow videoSelectedEventDataRow = (VideoSelectedEventDataRow) eventDataRow;
            amount = videoSelectedEventDataRow.getAmount()/100.0;



            calendar = Calendar.getInstance();
            calendar.setTime(videoSelectedEventDataRow.getDate());
            GregorianCalendar gc = new GregorianCalendar(
                    calendar.get(Calendar.YEAR),
                    calendar.get(Calendar.MONTH),
                    calendar.get(Calendar.DAY_OF_MONTH)
            );
            dateWithOutTime = gc.getTime();

            if (result.containsKey(dateWithOutTime)) amount += result.get(dateWithOutTime);

            result.put(dateWithOutTime,amount);
        }

        return result;
    }


    public Map<Date, Map<String, Integer>> getCookWorkloading() {
        Map<Date, Map<String, Integer>> resultMap = new TreeMap<>(Collections.reverseOrder());
        for (EventDataRow event : statisticStorage.get(EventType.COOKED_ORDER)) {
            Date date = dateToStringMidnight(event.getDate());
            CookedOrderEventDataRow eventData = (CookedOrderEventDataRow) event;
            int time = eventData.getTime();
            if (time == 0) continue;
            if (time % 60 == 0) time = time / 60;
            else time = time / 60 + 1;
            if (resultMap.containsKey(date)) {
                Map<String, Integer> cookInfo = resultMap.get(date);
                if (cookInfo.containsKey(eventData.getCookName()))
                    cookInfo.put(eventData.getCookName(), cookInfo.get(eventData.getCookName()) + time);
                else cookInfo.put(eventData.getCookName(), time);
            } else {
                TreeMap<String, Integer> cookInfo = new TreeMap<>();
                cookInfo.put(eventData.getCookName(), time);
                resultMap.put(date, cookInfo);
            }
        }
        return resultMap;
    }
    private Date dateToStringMidnight(Date date) {
        GregorianCalendar roundedDate = new GregorianCalendar();
        roundedDate.setTime(date);
        roundedDate.set(Calendar.HOUR_OF_DAY, 0);
        roundedDate.set(Calendar.MINUTE, 0);
        roundedDate.set(Calendar.SECOND, 0);
        roundedDate.set(Calendar.MILLISECOND, 0);
        return roundedDate.getTime();
    }
}
