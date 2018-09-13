package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException{
        String name;
        Sex sex;
        Date bd;
        Person p;
        int id;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        SimpleDateFormat format1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        //start here - начни тут
        if (args[0].equals("-c")) {
            name = args[1];
            sex = (args[2] == "м") ? Sex.MALE : Sex.FEMALE;
            bd = format.parse(args[3]);
            if (sex == Sex.MALE) {
                p = Person.createMale(name, bd);
            } else {
                p = Person.createFemale(name, bd);
            }
            allPeople.add(p);
            System.out.println(allPeople.indexOf(p));
        }
        if (args[0].equals("-u")) {
            id = Integer.parseInt(args[1]);
            name = args[2];
            sex = (args[3] == "м") ? Sex.MALE : Sex.FEMALE;
            bd = format.parse(args[4]);
            p = allPeople.get(id);
            p.setName(name);
            p.setSex(sex);
            p.setBirthDay(bd);
        }
        if (args[0].equals("-d")) {
            id = Integer.parseInt(args[1]);
            p = allPeople.get(id);
            p.setName(null);
            p.setSex(null);
            p.setBirthDay(null);
        }
        if (args[0].equals("-i")) {
            id = Integer.parseInt(args[1]);
            p = allPeople.get(id);
            String sx = (p.getSex() == Sex.MALE) ? "м" : "ж";
            System.out.println(p.getName() + " " + sx + " " + format1.format(p.getBirthDay()));
        }
        //start here - начни тут
    }
}
