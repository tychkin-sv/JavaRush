package com.javarush.task.task08.task0823;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Омовение Рамы
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        //напишите тут ваш код
        String result = "";
        String[] array = s.split(" ");
        for (int i = 0; i<array.length; i++) {

            if (!array[i].isEmpty()){
                result += ("" + array[i].charAt(0)).toUpperCase();
            for (int j = 1; j < array[i].length(); j++) result += array[i].charAt(j);
            if (i < array.length - 1) result += " ";
        } else result += " ";
        }
        s = result;
        System.out.println(s);

    }
}
