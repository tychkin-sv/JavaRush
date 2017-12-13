package com.javarush.task.task22.task2202;

/* 
Найти подстроку
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения Java."));
        System.out.println(getPartOfString("JavaRush - лучший сервис обучения"));
        //System.out.println(getPartOfString("JavaRush - лучший сервис"));
        //System.out.println(getPartOfString("JavaRush"));
        //System.out.println(getPartOfString(""));
        //System.out.println(getPartOfString(null));
    }

    public static String getPartOfString(String string) {
        if (string==null) throw new TooShortStringException();
        String result = "";
        String[] tmp = string.split(" ");
        if (tmp.length<5) throw new TooShortStringException();
        for (int i=1;i<5; i++ ) result += tmp[i] + " ";

        return result.trim();
    }

    public static class TooShortStringException extends RuntimeException{
    }
}
