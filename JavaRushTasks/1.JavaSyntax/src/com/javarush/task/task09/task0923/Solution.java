package com.javarush.task.task09.task0923;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Гласные и согласные
*/

public class Solution {
    public static char[] vowels = new char[]{'а', 'я', 'у', 'ю', 'и', 'ы', 'э', 'е', 'о', 'ё'};

    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        StringBuilder sVowel = new StringBuilder();
        StringBuilder sNotVowel = new StringBuilder();

        for (char c: s.toCharArray()){

            if (isVowel(c) && c!=' '){
                sVowel.append(c);
                sVowel.append(" ");
            }
            else if (c!=' '){
                sNotVowel.append(c);
                sNotVowel.append(" ");
            }
        }
        System.out.println(sVowel);
        System.out.println(sNotVowel);
    }

    // метод проверяет, гласная ли буква
    public static boolean isVowel(char c) {
        c = Character.toLowerCase(c);  // приводим символ в нижний регистр - от заглавных к строчным буквам

        for (char d : vowels)   // ищем среди массива гласных
        {
            if (c == d)
                return true;
        }
        return false;
    }
}