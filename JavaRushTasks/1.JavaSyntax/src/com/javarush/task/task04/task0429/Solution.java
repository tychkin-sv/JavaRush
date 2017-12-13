package com.javarush.task.task04.task0429;

/* 
Положительные и отрицательные числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(bufferedReader.readLine());
        int num2 = Integer.parseInt(bufferedReader.readLine());
        int num3 = Integer.parseInt(bufferedReader.readLine());

        int kolOtr = 0;
        int kolPol = 0;

        if (num1>0) kolPol++;
        if (num2>0) kolPol++;
        if (num3>0) kolPol++;

        if (num1<0) kolOtr++;
        if (num2<0) kolOtr++;
        if (num3<0) kolOtr++;

        System.out.println("количество отрицательных чисел: " + kolOtr);
        System.out.println("количество положительных чисел: " + kolPol);


    }
}
