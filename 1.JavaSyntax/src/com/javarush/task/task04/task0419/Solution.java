package com.javarush.task.task04.task0419;

/* 
Максимум четырех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(bufferedReader.readLine());
        int num2 = Integer.parseInt(bufferedReader.readLine());
        int num3 = Integer.parseInt(bufferedReader.readLine());
        int num4 = Integer.parseInt(bufferedReader.readLine());
        if (num1 >= num2 && num1 >= num3 && num1 >= num4) System.out.println(num1);
        else if (num2 >= num1 && num2 >= num3 && num2 >= num4) System.out.println(num2);
        else if (num3 >= num1 && num3 >= num2 && num3 >= num4) System.out.println(num3);
        else System.out.println(num4);
    }

}
