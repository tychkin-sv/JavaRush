package com.javarush.task.task22.task2212;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
Проверка номера телефона

Критерии валидности:
1) если номер начинается с ‘+‘, то он содержит 12 цифр
2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
3) может содержать 0-2 знаков ‘—‘, которые не могут идти подряд
4) может содержать 1 пару скобок ‘(‘ и ‘)‘ , причем если она есть, то она расположена левее знаков ‘-‘
5) скобки внутри содержат четко 3 цифры
6) номер не содержит букв
7) номер заканчивается на цифру

Примеры:
+380501234567 - true
+38(050)1234567 - true
+38050123-45-67 - true
050123-4567 - true
+38)050(1234567 - false
+38(050)1-23-45-6-7 - false
050ххх4567 - false
050123456 - false
(0)501234567 - false
*/
public class Solution {
    public static boolean checkTelNumber(String telNumber) {

        if (telNumber == null||telNumber.equals("")) return false;
        int totalDigit = telNumber.replaceAll("\\D", "").length();

        Pattern patternPlus = Pattern.compile("\\+\\d*(\\(?\\d{3}\\)?)?\\d+\\-?\\d+\\-?\\d+");
        Pattern patternWithoutPlus = Pattern.compile("\\d*(\\(?\\d{3}\\)?)?\\d+\\-?\\d+\\-?\\d+");

        Matcher matcherPlus = patternPlus.matcher(telNumber);
        Matcher matcherWithoutPlus  = patternWithoutPlus.matcher(telNumber);

        if (matcherPlus.matches() && (totalDigit==12)) return true;
        if (matcherWithoutPlus .matches() && (totalDigit==10)) return true;

        return false;
    }

    public static void main(String[] args) {
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

        for (Map.Entry<String, Boolean> pair: map.entrySet()){
            System.out.println(pair.getKey() + " validation ok = " + (checkTelNumber(pair.getKey()) == pair.getValue()));
        }
    }
}
