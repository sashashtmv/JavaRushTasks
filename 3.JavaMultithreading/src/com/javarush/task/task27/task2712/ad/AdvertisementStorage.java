package com.javarush.task.task27.task2712.ad;

import java.util.ArrayList;
import java.util.List;

//хранилище рекламных роликов у нас одно для всех столов, поэтому делаем его синглтон
public class AdvertisementStorage {
    private static AdvertisementStorage ourInstance = new AdvertisementStorage();
    private final List<Advertisement> videos = new ArrayList();

    public static AdvertisementStorage getInstance() {
        return ourInstance;
    }

    private AdvertisementStorage() {
        videos.add(new Advertisement(new Object(),"First Video", 5000, 100, 3 * 60));
        videos.add(new Advertisement(new Object(),"Second Video", 100, 10, 15 * 60));
        videos.add(new Advertisement(new Object(),"Third Video", 400, 2, 10 * 60));
    }

    public List list(){
        return videos;
    }

    public void add(Advertisement advertisement){
        videos.add(advertisement);
    }
}
