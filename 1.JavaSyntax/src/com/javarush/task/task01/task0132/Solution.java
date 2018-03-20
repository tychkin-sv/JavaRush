package com.javarush.task.task01.task0132;

/* 
Сумма цифр трехзначного числа
*/

public class Solution {
    public static void main(String[] args) {
        System.out.println(sumDigitsInNumber(546));
    }

    public static int sumDigitsInNumber(int number) {
        //напишите тут ваш код
        int s1 = number/100;
        int s2 = number%100/10;
        int s3 = number%100%10;
        return s1 + s2 + s3;
    }
}