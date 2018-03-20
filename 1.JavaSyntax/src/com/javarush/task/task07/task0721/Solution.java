package com.javarush.task.task07.task0721;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Минимаксы в массивах
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int maximum;
        int minimum;

        //напишите тут ваш код
        int[] list = new int[20];
        for (int i=0; i<20; i++){
            list[i] = Integer.parseInt(reader.readLine());
        }
        maximum = minimum = list[0];

        for (int i=1; i<20; i++) {
            if (maximum<list[i]) maximum = list[i];
            if (minimum>list[i]) minimum = list[i];
        }

        System.out.println(maximum + " " + minimum);
    }
}
