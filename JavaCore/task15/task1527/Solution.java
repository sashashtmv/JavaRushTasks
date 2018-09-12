package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.InputStreamReader;


/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        String URL=new BufferedReader(new InputStreamReader(System.in)).readLine().replaceAll("^(.*?\\?)","");
        for(String s:URL.split("&"))System.out.print(s.replaceAll("=.*$","")+" ");
        System.out.println();
        for(String s:URL.split("&")) {
            if (s.replaceAll("=.*$", "").equals("obj")) {
                try {
                    alert(Double.parseDouble(s = s.replaceAll("^[^=]*=", "")));
                } catch (NumberFormatException e) {
                    alert(s);
                }
            }
        }
//        Описание строк:
//        1. Создаем URL. Считываем. Обрезаем всё что до знака вопроса (включительно)
//                2. Сплитим строки по символу & и сразу по этим строкам пробегаемся через for-each.
//                Внутри псевдо-обрезаем правую часть вместе с =  и выводим на экран содержимое через пробел.
//        3. Переходим на следующую строку.
//        4. Опять сплитим строки по символу & и сразу по этим строкам пробегаемся через for-each.
//        5. Внутри псевдо-обрезав правую часть вместе с = сравниваем, что это obj.
//        6.
//        7. Обрезаем левую часть до первого знака = (включительно), остаток присваиваем в s.
//                Второе и более вхождение знака = тоже уже пойдут в s
//        Если s преобразуется в double, то вызовется нужный alert.
//        Целые числа (без точки) тоже пройдут. Всё остальное (с посторонними символами) уйдёт в 9 строку.
//        8.
//        9. Вызов alert с типом String. Содержимое s уже обработано в блоке try
        /*BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String[] str = s.split("\\?");
        s = str[1];
        str = s.split("&");
        String[] temp;
        ArrayList<String> buff= new ArrayList<>();
        for(int i = 0; i < str.length; i++){
            if(str[i].contains("=")){
                temp = str[i].split("=");
                System.out.print(temp[0] + " ");
                if(temp[0].equals("obj")){
                    buff.add(temp[1]);
                }
            }
            else System.out.print(str[i] + " ");
        }
        System.out.println();
        for(String f : buff){
            try{
                if(f != null && f.contains(".")) alert(Double.parseDouble(f));
                else alert(f);
            }catch (Exception e){alert(f);}
        }*/
    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
