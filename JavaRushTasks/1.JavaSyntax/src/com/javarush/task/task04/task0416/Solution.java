package com.javarush.task.task04.task0416;

/* 
Переходим дорогу вслепую
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String sGreen = "зелёный";
        String sYellow = "желтый";
        String sRed = "красный";
        String s = sRed;

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        double num = Double.parseDouble(bufferedReader.readLine());
        double num5 = num % 5;

        if (num5>=0.0 && num5 < 3.0) s = sGreen;
        else if (num5>=3.0 && num5 < 4.0) s = sYellow;
        else s = sRed;
        System.out.println(s);

    }
}