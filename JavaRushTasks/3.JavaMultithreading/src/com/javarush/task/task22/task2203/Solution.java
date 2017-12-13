package com.javarush.task.task22.task2203;

/* 
Между табуляциями
*/
public class Solution {
    public static String getPartOfString(String string) throws TooShortStringException {
        if ((string==null) || string.isEmpty()) throw new TooShortStringException();
        String[] tmp = string.split("\t");
        System.out.println(tmp.length);
        if (tmp.length<3) throw new TooShortStringException();

        return tmp[1];
    }

    public static class TooShortStringException extends Exception {
    }

    public static void main(String[] args) throws TooShortStringException {
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \tобучения Java\t."));
        System.out.println(getPartOfString("\tJavaRush - лучший сервис \t"));
        //System.out.println(getPartOfString(""));
        //System.out.println(getPartOfString(null));
    }
}
