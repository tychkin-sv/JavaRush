package com.javarush.task.task07.task0704;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Переверни массив
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        int[] iArray = new int[10];
        int len = iArray.length;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 0; i<len; i++){
            String s = bufferedReader.readLine();
            iArray[i] = Integer.parseInt(s);
        }

        for (int i = 0; i<len/2; i++){
            int tmp = iArray[i];
            iArray[i] = iArray[len - i - 1];
            iArray[len - i - 1] = tmp;
        }

        for (int i = 0; i<len; i++){
            System.out.println(iArray[i]);
        }

    }
}

