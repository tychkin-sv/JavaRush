package com.javarush.task.task22.task2212;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by userPG on 28.08.2017.
 */
public class SolutionNew {
    public static boolean checkTelNumber(String telNumber) {


        if (telNumber == null||telNumber.equals("")) return false;
        int totalDigit = telNumber.replaceAll("\\D", "").length();

        Pattern pattern1 = Pattern.compile("\\+\\d*(\\(?\\d{3}\\)?)?\\d+\\-?\\d+\\-?\\d+");
        Pattern pattern2 = Pattern.compile("\\d*(\\(?\\d{3}\\)?)?\\d+\\-?\\d+\\-?\\d+");

        Matcher matcher1 = pattern1.matcher(telNumber);
        Matcher matcher2 = pattern2.matcher(telNumber);

        if (matcher1.matches() && (totalDigit==12)) return true;
        if (matcher2.matches() && (totalDigit==10)) return true;

        return false;

    }

    public static void main(String[] args) {

        System.out.println("1 = " + checkTelNumber("+380501234567"));
        System.out.println("2 = " + checkTelNumber("+38(050)1234567"));
        System.out.println("3 = " + checkTelNumber("+38050123-45-67"));
        System.out.println("4 = " + checkTelNumber("050123-4567"));
        System.out.println("5 = " + checkTelNumber("0501(234)567"));
        System.out.println("6 = " + checkTelNumber("050123(456)7"));

        System.out.println(checkTelNumber("+38)050(1234567"));
        System.out.println(checkTelNumber("+38(050)1-23-45-6-7"));
        System.out.println(checkTelNumber("050ххх4567"));
        System.out.println(checkTelNumber("050123456"));
        System.out.println(checkTelNumber("(0)501234567"));




        Map<String, Boolean> map = new HashMap<>();
        map.put("+380501234567",true);
        map.put("+38(050)1234567",true);
        map.put("+38050123-45-67",true);
        map.put("050123-4567",true);
        map.put("+38)050(1234567",false);
        map.put("+38(050)1-23-45-6-7",false);
        map.put("050ххх4567", false);
        map.put("050123456", false);
        map.put("(0)501234567", false);
/*
        for (Map.Entry<String, Boolean> pair: map.entrySet()){
            System.out.println(pair.getKey() + " validation ok = " + (checkTelNumber(pair.getKey()) == pair.getValue()));
        }*/
        String s = "+380501234567";
        s = "38xx501A34567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "3805012345";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "+380501234567";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "++380501234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+38(0501234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+38)050(1234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+38(050)1234567";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "+38(05)1234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "(3)80501234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "(380)501234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "380-50123-45";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "(380)501-234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "(38-0)501234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "380-(501)234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "380(50-1)234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "380(501)(23)4567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+38050123(456)7";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "+38050123(456)76";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+380501234(567)";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "3-805-0123-45";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "-3805-012345";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "3805-012345-";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+380501234567";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "+38(050)1234567";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "+38(05)01234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+38(0501)234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+38050123-45-67";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "050123-4567";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "+38)050(1234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+38(050)1-23-45-6-7";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "050ххх4567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "050123456";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+38-(050)1234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+38((050)1234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "+5(0--5)1234567";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "7-4-4123689-5";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");
        s = "1-23456789-0";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "+38051202(345)7";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "+38051202(345)-7";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "+-313450531202";
        System.out.println(s+" "+checkTelNumber(s)+" need true");
        s = "+313450--531202";
        System.out.println(s+" "+checkTelNumber(s)+" need fa");

    }
}
