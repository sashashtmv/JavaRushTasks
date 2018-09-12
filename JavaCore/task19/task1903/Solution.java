package com.javarush.task.task19.task1903;

/* 
Адаптация нескольких интерфейсов
*/

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();
    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class IncomeDataAdapter implements Contact, Customer{
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data){
            this.data = data;
        }
        public String getCompanyName(){
            return data.getCompany();
        }        //example JavaRush Ltd.

        public String getCountryName(){
            return countries.get(data.getCountryCode());
        }        //example Ukraine
        public String getName(){
            return data.getContactLastName()+", " + data.getContactFirstName();
        }               //example Ivanov, Ivan

        public String getPhoneNumber(){
            String a = data.getPhoneNumber()+"";
            while (a.length()<10){
                a="0"+a;
            }
            return ("+" + data.getCountryPhoneCode()+ "("+(a+"").substring(0,3)+")"+ (a+"").substring(3,6)+"-"+ (a+"").substring(6,8)+"-" +(a+"").substring(8,10));
        }        //example +38(050)123-45-67
    }


    public static interface IncomeData {
        String getCountryCode();        //example UA

        String getCompany();            //example JavaRush Ltd.

        String getContactFirstName();   //example Ivan

        String getContactLastName();    //example Ivanov

        int getCountryPhoneCode();      //example 38

        int getPhoneNumber();           //example 501234567
    }

    public static interface Customer {
        String getCompanyName();        //example JavaRush Ltd.

        String getCountryName();        //example Ukraine
    }

    public static interface Contact {
        String getName();               //example Ivanov, Ivan

        String getPhoneNumber();        //example +38(050)123-45-67
    }
}