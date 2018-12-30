package com.javarush.task.task27.task2712.ad;

import java.util.List;
import java.util.TreeMap;

public class StatisticAdvertisementManager {
    private AdvertisementStorage advertisementStorage = AdvertisementStorage.getInstance();
        private List<Advertisement> list = advertisementStorage.list();
    private static StatisticAdvertisementManager ourInstance = new StatisticAdvertisementManager();

    public static StatisticAdvertisementManager getInstance() {
        return ourInstance;
    }

    private StatisticAdvertisementManager() {
    }

    public TreeMap<String, Integer> getActiveAdvertisement(){
        TreeMap<String, Integer> activeAdvertisement = new TreeMap<>();
        for(Advertisement advertisement : list){
            if(advertisement.getHits() > 0){
                activeAdvertisement.put(advertisement.getName(), advertisement.getHits());
            }
        }

        return activeAdvertisement;
    }

    public TreeMap<String, Integer> getNotActiveAdvertisement(){
        TreeMap<String, Integer> notActiveAdvertisement = new TreeMap<>();
        for(Advertisement advertisement : list){
            if(advertisement.getHits() < 1){
                notActiveAdvertisement.put(advertisement.getName(), 0);
            }
        }

        return notActiveAdvertisement;
    }
}
