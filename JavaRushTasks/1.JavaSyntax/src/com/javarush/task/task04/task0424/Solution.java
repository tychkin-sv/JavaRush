package com.javarush.task.task04.task0424;

/* 
Три числа
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(bufferedReader.readLine());
        int num2 = Integer.parseInt(bufferedReader.readLine());
        int num3 = Integer.parseInt(bufferedReader.readLine());

        if (num1!=num2 && num1!=num3 && num2!=num3){}
        else if (num1!=num2 && num1!=num3) System.out.println(1);
        else if (num2!=num1 && num2!=num3) System.out.println(2);
        else System.out.println(3);




    }
}
