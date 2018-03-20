package com.javarush.task.task04.task0427;

/* 
Описываем числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());

        boolean ch = num%2 == 0;
        boolean b1 = num/10 == 0 && num%10>0;
        boolean b2 = num/100 == 0 && num%100>9;
        boolean b3 = num/1000 == 0 && num%1000>99;

        if (num>=1 && num<=999) {


            if (ch && b1) System.out.println("четное однозначное число");
            if (!ch && b1) System.out.println("нечетное однозначное число");
            if (ch && b2) System.out.println("четное двузначное число");
            if (!ch && b2) System.out.println("нечетное двузначное число");
            if (ch && b3) System.out.println("четное трехзначное число");
            if (!ch && b3) System.out.println("нечетное трехзначное число");

        }
    }
}
