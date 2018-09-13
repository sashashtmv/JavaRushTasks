package com.javarush.task.task18.task1815;

import java.util.List;

/* 
Таблица
*/

public class Solution {
    public class TableInterfaceWrapper implements ATableInterface {
        ATableInterface table;
        public TableInterfaceWrapper(ATableInterface tb){
            this.table = tb;
        }
        public void setModel(List rows){
            System.out.println(rows.size());
            table.setModel(rows);
        }

        public String getHeaderText(){
            return table.getHeaderText().toUpperCase();
        }

        public void setHeaderText(String newHeaderText){table.setHeaderText(newHeaderText);}

    }

    public interface ATableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}