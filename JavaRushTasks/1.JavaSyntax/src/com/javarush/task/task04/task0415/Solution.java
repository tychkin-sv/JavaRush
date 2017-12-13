package com.javarush.task.task04.task0415;

/* 
Правило треугольника
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int a = Integer.parseInt(bufferedReader.readLine());
        int b = Integer.parseInt(bufferedReader.readLine());
        int c = Integer.parseInt(bufferedReader.readLine());
        String sYes = "Треугольник существует.";
        String sNo = "Треугольник не существует.";
        String s = sYes;

        if (c >= (a+b)) {s = sNo;}
        else if (b >= (a+c)) {s = sNo;}
        else if (a >= (b+c)) {s = sNo;}
        System.out.println(s);
    }
}