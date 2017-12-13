package com.javarush.task.task04.task0425;

/* 
Цель установлена!
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(bufferedReader.readLine());
        int num2 = Integer.parseInt(bufferedReader.readLine());

        if (num1>0 && num2>0) System.out.println(1);
        if (num1<0 && num2>0) System.out.println(2);
        if (num1<0 && num2<0) System.out.println(3);
        if (num1>0 && num2<0) System.out.println(4);

    }
}
