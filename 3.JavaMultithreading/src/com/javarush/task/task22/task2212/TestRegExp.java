package com.javarush.task.task22.task2212;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by userPG on 28.08.2017.
 */
public class TestRegExp {


    public static void main(String[] args) {
        String sPattern;
        String sMatcher;

        // может содержать 0-2 знаков ‘—‘, которые не могут идти подряд
        sPattern = ".+-?\\d+-?.+";
        sMatcher = "66-";
        Pattern pattern = Pattern.compile(sPattern);
        Matcher matcher = pattern.matcher(sMatcher);
        System.out.println("Result :" + matcher.matches());

        // скобки внутри содержат четко 3 цифры
        sPattern = ".*\\({1}[\\d]{3}\\){1}\\d+";
        sMatcher = "111(12)1";
        pattern = Pattern.compile(sPattern);
        matcher = pattern.matcher(sMatcher);
        System.out.println("Result " + sMatcher + " :" + matcher.matches());


        // Символ "+" встречается от 0 до 1
        sPattern = "[0-9]\\(";
        sMatcher = "0123456789";
        pattern = Pattern.compile(sPattern);
        matcher = pattern.matcher(sMatcher);
        System.out.println("Result :" + matcher.matches());

        sPattern = "c:\\\\.*";
        sMatcher = "c:\\distrib";
        pattern = Pattern.compile(sPattern);
        matcher = pattern.matcher(sMatcher);
        //System.out.println(sPattern);
        //System.out.println(sMatcher);
        System.out.println("Result :" + matcher.matches());


        sPattern = "\\+?\\(?[\\d]{3}\\)?";
        sMatcher = "+(123)";
        System.out.println("Result :" + matcher.matches());
    }
}
