package com.javarush.task.task09.task0922;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* 
Какое сегодня число?
*/

public class Solution {

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sdate = reader.readLine();
        //Ввести с клавиатуры дату в формате «08/18/2013»
        //Вывести на экран эту дату в виде «AUG 18, 2013».

        SimpleDateFormat sdf_in = new SimpleDateFormat("MM/dd/yy");
        Date date = sdf_in.parse(sdate);
        SimpleDateFormat sdf_out = new SimpleDateFormat("MMM dd, yyyy",Locale.US);
        System.out.println(sdf_out.format(date).toString().toUpperCase());

    }
}
