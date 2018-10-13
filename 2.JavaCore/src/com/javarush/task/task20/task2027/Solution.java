package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) throws Exception{
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };
        List<Word> words = (detectAllWords(crossword, "fsg", "fde", "ful", "z", "g", "okppu", "sqnc","enwepgae", "eqkj", "home", "same"));
        for (Word word:words) {
            System.out.println(word);
        }
        System.out.println(words.size());
        //detectAllWords(crossword, "home", "same");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words){
        ArrayList<Word> list = new ArrayList<Word>();
        int[][] crossword2 = new int[crossword.length + 2][crossword[0].length + 2];
        for (int x = 0; x < crossword2.length; x++) Arrays.fill(crossword2[x], 0);

        for (int i = 0; i < crossword2.length - 2; i++) {
            for (int j = 0; j < crossword2[0].length - 2; j++) {
                crossword2[i + 1][j + 1] = crossword[i][j];
            }
        }

        for (String s : words) {
//            outer:
            for (int i = 0; i < crossword2.length; i++) {
                for (int j = 0; j < crossword2[0].length; j++) {
                    if ((int) s.charAt(0) == crossword2[i][j]) {
                        if (s.length() != 1)
                        {
                            List <int[]> letters;
                            letters = findword(s, crossword2, i, j);
                            if (letters.size() == 0)
                                continue;
                            for (int [] letter : letters) {
                                Word w = new Word(s);
                                w.setStartPoint(j - 1, i - 1);
                                w.setEndPoint(letter[1] - 1, letter[0] - 1);
                                list.add(w);
                            }
                        }
                        else
                        {
                            Word w = new Word(s);
                            w.setStartPoint(j - 1, i - 1);
                            w.setEndPoint(j - 1, i - 1);
                            list.add(w);
                        }
//                       break outer;
                    }
                }
            }
        }


        return list;

    }
    public static List <int[]> findword(String s, int[][] crossword2, int i, int j) {

        List <int[]> list = new ArrayList<>();
        boolean flag;
        int b = i;
        int d = j;

        if (s.charAt(1) == crossword2[i][j + 1]) { // →
            flag = true;
            for (int x = 2; x < s.length(); x++) {
                d++;
                if (s.charAt(x) != crossword2[b][d + 1]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(new int[] {b, d + 1});
            }
            b = i;
            d = j;
        }

        if (s.charAt(1) == crossword2[i + 1][j + 1]) { // ↘
            flag = true;
            for (int x = 2; x < s.length(); x++) {
                b++;
                d++;
                if (s.charAt(x) != crossword2[b + 1][d + 1]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(new int[] {b + 1, d + 1});
            }
            b = i;
            d = j;
        }

        if (s.charAt(1) == crossword2[i + 1][j]) { //  ↓
            flag = true;
            for (int x = 2; x < s.length(); x++) {
                b++;
                if (s.charAt(x) != crossword2[b + 1][d]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(new int[] {b + 1, d});
            }
            b = i;
            d = j;
        }

        if (s.charAt(1) == crossword2[i + 1][j - 1]) { // ↙
            flag = true;
            for (int x = 2; x < s.length(); x++) {
                b++;
                d--;
                if (s.charAt(x) != crossword2[b + 1][d - 1]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(new int[] {b + 1, d - 1});
            }
            b = i;
            d = j;
        }

        if (s.charAt(1) == crossword2[i][j - 1]) { // ←
            flag = true;
            for (int x = 2; x < s.length(); x++) {
                d--;
                if (s.charAt(x) != crossword2[b][d - 1]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(new int[] {b, d - 1});
            }
            b = i;
            d = j;
        }

        if (s.charAt(1) == crossword2[i - 1][j - 1]) { // ↖
            flag = true;
            for (int x = 2; x < s.length(); x++) {
                b--;
                d--;
                if (s.charAt(x) != crossword2[b - 1][d - 1]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(new int[] {b - 1, d - 1});
            }
            b = i;
            d = j;
        }

        if (s.charAt(1) == crossword2[i - 1][j]) { // ↑
            flag = true;
            for (int x = 2; x < s.length(); x++) {
                b--;
                if (s.charAt(x) != crossword2[b - 1][d]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(new int[] {b - 1, d});
            }
            b = i;
            d = j;
        }

        if (s.charAt(1) == crossword2[i - 1][j + 1]) { // ↗
            flag = true;
            for (int x = 2; x < s.length(); x++) {
                b--;
                d++;
                if (s.charAt(x) != crossword2[b - 1][d + 1]) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                list.add(new int[] {b - 1, d + 1});
            }
            b = i;
            d = j;
        }

        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
