package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader fis = new BufferedReader(new FileReader(reader.readLine()));
        StringBuilder sb = new StringBuilder();
        while (fis.ready()){
            sb.append(fis.readLine() + " ");
        }
        String[] mas = sb.toString().split(" ");
        ArrayList<String> array = new ArrayList<>();
        array.addAll(Arrays.asList(mas));

        for(String s : mas){
            String revers = new StringBuilder(s).reverse().toString();
            Pair pair = new Pair();

            for(int i = 0; i < array.size(); i++){
                if(array.get(i).equals(s) && pair.first == null) {
                    pair.first = s;
                    continue;
                }else if(array.get(i).equals(revers) && pair.second == null && pair.first != null){
                        pair.second = revers;
                        result.add(pair);
                        array.remove(i);
                        i--;
                        for (int j = 0; j < array.size(); j++) {
                            if (array.get(j).equals(s) || array.get(j).equals(revers)) {
                                array.remove(j);
                                j--;
                            }
                        }

                }
            }
        }
        for(Pair p : result) {
            System.out.println(p);
        }
    }

    public static class Pair {
        String first;
        String second;

        public Pair() {
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
