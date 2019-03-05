package com.javarush.task.task30.task3002;

/* 
Осваиваем методы класса Integer
*/
public class Solution {

    public static void main(String[] args) {
        System.out.println(convertToDecimalSystem("0x16")); //22
        System.out.println(convertToDecimalSystem("012"));  //10
        System.out.println(convertToDecimalSystem("0b10")); //2
        System.out.println(convertToDecimalSystem("62"));   //62
    }

    public static String convertToDecimalSystem(String s) {
        //напишите тут ваш код
        int radix = 10; // Система счисления 10 по умолчанию
        // !!!Необходимо убирать из строки лишнии символы и
        // подавать в метод Integer.parseInt(s,radix);
        // строку без 0, 0x, 0b
        if (s.startsWith("0")) {
            radix = 8;
            if (s.startsWith("0x")) {
                radix = 16;
                s=s.substring(2);
            }
            else if (s.startsWith("0b"))
            {
                radix = 2;
                s=s.substring(2);
            }
            else s=s.substring(1);
        }

        Integer result = Integer.parseInt(s,radix);
        s=result.toString();
        return s;
    }
}
