package com.javarush.task.task33.task3308;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.List;

@XmlRootElement
@XmlType(name = "shop")
public class Shop {
    public Goods goods;
    public int count;
    public double profit;
    public String[] secretData;

     static class Goods {
         @XmlElement
         List<String> names;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("goods (" + goods.names.size() + "):\n");
        for (String str : goods.names) {
            sb.append(" - " + str + "\n");
        }
        sb.append("count: " + count + "\n");
        sb.append("profit: " + profit + "\n");
        sb.append("secretData (" + secretData.length + "):\n");
        for (String str : secretData) {
            sb.append(" - " + str + "\n");
        }
        return sb.toString();
    }
}

