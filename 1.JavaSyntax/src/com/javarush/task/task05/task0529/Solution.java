package com.javarush.task.task05.task0529;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Консоль-копилка
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int num = 0;
        int sum = 0;

        while (!s.equals("сумма")){
            num = Integer.parseInt(s);
            sum = sum + num;
            s = bufferedReader.readLine();
        }

        System.out.println(sum);
    }
}
