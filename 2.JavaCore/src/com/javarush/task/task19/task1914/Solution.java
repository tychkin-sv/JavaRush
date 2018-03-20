package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream concolePrintStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        testString.printSomething();
        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = byteArrayOutputStream.toString();

        System.setOut(concolePrintStream);

        String[] digits = result.split("\\D+");

        //System.out.println(Arrays.toString(digits));
        int a = Integer.parseInt(digits[0]);
        int b = Integer.parseInt(digits[1]);

        System.out.println(result);

        if (result.contains("+")) System.out.println(a+b);
        if (result.contains("-")) System.out.println(a-b);
        if (result.contains("*")) System.out.println(a*b);


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

