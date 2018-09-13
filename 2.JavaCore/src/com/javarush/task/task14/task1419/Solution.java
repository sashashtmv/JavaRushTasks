package com.javarush.task.task14.task1419;

import java.io.FileInputStream;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        try
        {
            ArrayList<String> a = new ArrayList<String>();
            ArrayList<Integer> b = new ArrayList<Integer>();
            b.contains(a.get(0));
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            Integer test = null;
            Integer test2 = 0;
            test2.sum(test, test2);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            String test = "test";
            int test2 = Integer.parseInt(test);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            String test = "test";
            char test2 = test.charAt(100);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            Object i[] = new String[0];
            i[1] = new Integer(0);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            Object i = new Integer(0);
            System.out.print((String) i);
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            Solution test = new Solution();
            test.clone();
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            Date lowDate = sdf.parse("test");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }
        try
        {
            InputStream stream = new FileInputStream("test");
        }
        catch (Exception e)
        {
            exceptions.add(e);
        }//напишите тут ваш код

    }
}
