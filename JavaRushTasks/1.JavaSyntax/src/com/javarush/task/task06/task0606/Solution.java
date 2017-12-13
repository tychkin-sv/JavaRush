package com.javarush.task.task06.task0606;

import java.io.*;

/* 
Чётные и нечётные циферки
*/

public class Solution {

    public static int even;
    public static int odd;

    public static void main(String[] args) throws IOException {
        //напишите тут ваш ко44д
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());

        while (Math.abs(num) > 0) {
            if (num % 2 != 0) odd++;
            else even++;
            num = num / 10;
        }
        System.out.println("Even: " + even + " Odd: " + odd);


    }
}
