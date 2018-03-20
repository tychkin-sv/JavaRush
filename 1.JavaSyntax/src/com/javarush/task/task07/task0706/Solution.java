package com.javarush.task.task07.task0706;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Улицы и дома
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String ODD_MAX = "В домах с нечетными номерами проживает больше жителей.";
        String EVEN_MAX = "В домах с четными номерами проживает больше жителей.";

        int[] iArray = new int[15];
        int len = iArray.length;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i<len; i++){
            String s = bufferedReader.readLine();
            iArray[i] = Integer.parseInt(s);
        }

        int sum_odd = 0;
        int sum_even = 0;

        for (int i = 0; i<len; i++){
            if (i%2==0) sum_even += iArray[i];
             else sum_odd += iArray[i];

        }

        if (sum_odd>sum_even) System.out.println(ODD_MAX);
        if (sum_even>sum_odd) System.out.println(EVEN_MAX);

    }
}
