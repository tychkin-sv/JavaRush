package com.javarush.task.task07.task0703;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Общение одиноких массивов
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String[] sArray = new String[10];
        int[] iArray = new int[10];
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        for (int i=0; i<sArray.length; i++){
            sArray[i] = bufferedReader.readLine();
            iArray[i] = sArray[i].length();
        }

        for (int i=0; i<sArray.length; i++){
            System.out.println(iArray[i]);

        }


    }
}
