package com.javarush.task.task04.task0442;


/* 
Суммирование
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int n = 0;
        int sum = 0;
        while (n!=-1) {
            n = Integer.parseInt(bufferedReader.readLine());
            sum = sum + n;
        }
        System.out.println(sum);

        }

    }

