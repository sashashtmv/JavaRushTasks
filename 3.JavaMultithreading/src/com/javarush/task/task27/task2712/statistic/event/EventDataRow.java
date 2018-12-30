package com.javarush.task.task27.task2712.statistic.event;

import java.util.Date;

//он является интерфейсом-маркером, т.к. не содержит методов, и по нему мы определяем, является ли переданный объект событием или нет
public interface EventDataRow {
    EventType getType();
    //вернет дату создания записи
    Date getDate();
    //вернет время - продолжительность
    int getTime();
}
