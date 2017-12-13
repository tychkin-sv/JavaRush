package com.javarush.task.task08.task0827;

import java.util.Date;

/* 
Работа с датой
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(isDateOdd("MAY 1 2013"));
    }

    public static boolean isDateOdd(String date) {

        Date dateNow = new Date(date);
        Date dateYearBegin = new Date();
        dateYearBegin.setHours(0);
        dateYearBegin.setMinutes(0);
        dateYearBegin.setSeconds(0);

        dateYearBegin.setDate(1);      // первое число
        dateYearBegin.setMonth(0);     // месяц январь, нумерация для месяцев 0-11
        dateYearBegin.setYear(dateNow.getYear());

        long msTimeDistance = dateNow.getTime() - dateYearBegin.getTime();
        long msDay = 24 * 60 * 60 * 1000;  //сколько миллисекунд в одних сутках

        int dayCount = (int) (msTimeDistance/msDay); //количество целых дней

        boolean result = false;
        if (dayCount%2!=0) result = true;
        return result;
    }
}
