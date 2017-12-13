package com.javarush.task.task04.task0410;

/* 
Попадём-не-попадём
*/

public class Solution {
    public static void main(String[] args) {
        checkInterval(60);
        checkInterval(112);
    }

    public static void checkInterval(int a) {
        //::CODE:
        String s="Число " + a;
        if (a>=50 && a <100) s = s + " содержится в интервале.";
        else s = s + " не содержится в интервале.";

        System.out.println(s);
    }
}