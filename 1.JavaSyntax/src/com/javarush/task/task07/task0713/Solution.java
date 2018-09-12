package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> integers = new ArrayList<>();
        ArrayList<Integer> int3 = new ArrayList<>();
        ArrayList<Integer> int2 = new ArrayList<>();
        ArrayList<Integer> other = new ArrayList<>();
        for(int i = 0; i < 20; i++)integers.add(Integer.parseInt(reader.readLine()));
        for(int a : integers){
            if(a % 2 == 0 && a % 3 == 0){
                int2.add(a);
                int3.add(a);
            }
            else if(a % 2 == 0) int2.add(a);
            else if(a % 3 == 0) int3.add(a);
            else other.add(a);
        }
        printList(int3);
        printList(int2);
        printList(other);
    }

    public static void printList(List<Integer> list) {

        for (int i : list) System.out.println(i);
    }
}
