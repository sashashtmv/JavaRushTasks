package com.javarush.task.task04.task0441;


/* 
Как-то средненько
*/
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(reader.readLine());
        int b = Integer.parseInt(reader.readLine());
        int c = Integer.parseInt(reader.readLine());
        if ((a <= b && b <= c)||(a >= b && b >= c)) System.out.println(b);
        else if ((b <= a && a <= c) || (b >= a && a >= c)) System.out.println(a);
        else if ((a <= c && c <=b) || (a >= c && c >=b)) System.out.println(c);
        //напишите тут ваш код
    }
}
