package com.javarush.task.task22.task2212;

/**
 * Created by userPG on 28.08.2017.
 *
 1) если номер начинается с ‘+‘, то он содержит 12 цифр
 2) если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
 3) может содержать 0-2 знаков ‘—‘, которые не могут идти подряд
 4) может содержать 1 пару скобок ‘(‘ и ‘)‘ , причем если она есть, то она расположена левее знаков ‘-‘
 5) скобки внутри содержат четко 3 цифры
 6) номер не содержит букв
 7) номер заканчивается на цифру
 */
public class SolutionMy {
    public static boolean checkTelNumber(String telNumber) {
        if (telNumber == null || telNumber.equals("")) return false;
        int totalDigit = telNumber.replaceAll("\\D", "").length();

        boolean validation = true;

        String condition1 = "\\+.*"; // если номер начинается с ‘+‘, то он содержит 12 цифр
        if (telNumber.matches(condition1) && (totalDigit!=12)) return false;

        String condition2 = "\\d?\\(?.*"; // если номер начинается с цифры или открывающей скобки, то он содержит 10 цифр
        if (telNumber.matches(condition2) && (totalDigit!=10)) return false;

        String condition3 = ".*-?.+-?.*"; // может содержать 0-2 знаков ‘—‘, которые не могут идти подряд

        String condition4 = ".*-?.+-?.*"; //может содержать 1 пару скобок ‘(‘ и ‘)‘ , причем если она есть, то она расположена левее знаков ‘-‘

        String condition5 = ".*({1}[\\d]{3}){1}\\d+"; // скобки внутри содержат четко 3 цифры


        return validation;
    }

    public static void main(String[] args) {

    }
}
