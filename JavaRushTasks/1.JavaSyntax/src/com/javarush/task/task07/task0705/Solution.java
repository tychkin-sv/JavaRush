package com.javarush.task.task07.task0705;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Один большой массив и два маленьких
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] iArray = new int[20];
        int len = iArray.length;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i<len; i++){
            String s = bufferedReader.readLine();
            iArray[i] = Integer.parseInt(s);
        }
        int[] iArray_1 = new int[10];
        int[] iArray_2 = new int[10];

        for (int i = 0; i<len/2; i++){
            iArray_1[i] = iArray[i];
            iArray_2[i] = iArray[i + len/2];
        }

        for (int i = 0; i<len/2; i++){
            System.out.println(iArray_2[i]);
        }

    }
}
