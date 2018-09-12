package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        ArrayList<String> name = new ArrayList<>();
        ArrayList<Sex> sex = new ArrayList<>();
        ArrayList<Date> bd = new ArrayList<>();
        Person p ;
        ArrayList<Integer> id = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        //start here - начни тут
        switch (args[0]){
            case "-c":{
                synchronized (allPeople) {
                    int i = 1;
                    while (i < args.length) {
                        name.add(args[i]);
                        sex.add((args[i + 1] == "м") ? Sex.MALE : Sex.FEMALE);
                        bd.add(format.parse(args[i + 2]));
                        i = i + 3;
                    }
                    for (int a = 0; a < sex.size(); a++) {
                        if (sex.get(a) == Sex.MALE) {
                            p = Person.createMale(name.get(a), bd.get(a));
                        } else {
                            p = Person.createFemale(name.get(a), bd.get(a));
                        }
                        allPeople.add(p);
                        System.out.println(allPeople.indexOf(p));
                    }
                    break;
                }
            }
            case "-u":{
                synchronized (allPeople) {
                    int i = 1;
                    while (i < args.length) {
                        id.add(Integer.parseInt(args[i]));
                        name.add(args[i + 1]);
                        sex.add((args[i + 2] == "м") ? Sex.MALE : Sex.FEMALE);
                        bd.add(format.parse(args[i + 3]));
                        i = i + 4;
                    }
                    for (int a = 0; a < id.size(); a++) {
                        p = allPeople.get(id.get(a));
                        p.setName(name.get(a));
                        p.setSex(sex.get(a));
                        p.setBirthDay(bd.get(a));
                    }
                    break;
                }
            }
            case "-d":{
                synchronized (allPeople){
                    int i = 1;
                    while (i < args.length){
                        id.add(Integer.parseInt(args[i]));
                        i = i+1;
                    }
                    for(int a=0; a < id.size(); a++){
                        p = allPeople.get(id.get(a));
                        p.setName(null);
                        p.setSex(null);
                        p.setBirthDay(null);
                    }
                    break;
                }
            }
            case "-i":{
                synchronized (allPeople){
                    int i = 1;
                    while (i < args.length){
                        id.add(Integer.parseInt(args[i]));
                        i = i+1;
                    }
                    for(int a=0; a < id.size(); a++){
                        p = allPeople.get(id.get(a));
                        String sx = (p.getSex() == Sex.MALE) ? "м" : "ж";
                        System.out.println(p.getName() + " " + sx + " " + format1.format(p.getBirthDay()));
                    }
                    break;
                }
            }
        }

    }
}
