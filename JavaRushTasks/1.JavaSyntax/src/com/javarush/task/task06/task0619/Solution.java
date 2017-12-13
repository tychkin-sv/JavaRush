package com.javarush.task.task06.task0619;

/* 
Три статические переменных name
*/

public class Solution {
    public static String name;


    public static class Cat {
        public static String name;
    }

    public static class Dog {
        public static String name;
    }

    public static void main(String[] args) {
        String[] list = new String[0];
        System.out.println(list.length);
    }
}
