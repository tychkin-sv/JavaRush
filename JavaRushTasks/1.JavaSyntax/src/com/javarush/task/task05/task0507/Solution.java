package com.javarush.task.task05.task0507;

/* 
Среднее арифметическое
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        double sum = 0.0;
        int kol = 0;
        int num = Integer.parseInt(bufferedReader.readLine());
        while (num!=-1){
            sum = sum + num;
            kol++;
            num = Integer.parseInt(bufferedReader.readLine());
        }

        if (kol>0) System.out.println(sum/kol);

    }
}

