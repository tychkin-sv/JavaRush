package com.javarush.task.task08.task0827;

import java.util.Date;

/**
 * Created by userPG on 12.07.2017.
 */
public class SolushionForum {
        public static void main(String[] args) {
            System.out.println(isDateOdd("Feb 28 2013"));
        }
        public static boolean isDateOdd(String date) {
            Date date1 = new Date(date);
            String x3 = date1.toString();       //переводим дату в строку.
            String [] x2 = x3.split(" ");   //разбиваем строку на слова.
            x2 [0] = "Jan";                         //ставим 1 января
            x2 [1] = "1";
            String x = x2 [0] + " " + x2 [1] + " " + x2 [5];    //добавляем к 1 января заданный год
            Date date2 = new Date(x);      //получаем 1 января гг в формате даты
            System.out.println(date1);
            System.out.println(date2);
            long x1 = (date1.getTime()/(1000*60*60*24))-(date2.getTime()/(1000*60*60*24))+1;
            //вычитаем из заданной даты полученную(date2) и получаем кол-во дней
            if (x1%2 == 0)
                return false;
            else
                return true;
        }
    }

