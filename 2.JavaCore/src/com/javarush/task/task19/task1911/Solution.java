package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        // Запоминаем поток
        PrintStream consolePrintStream = System.out;
        //Создаем динамический массив
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        //создаем адаптер к классу PrintStream
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        //Устанавливаем его как текущий System.out
        System.setOut(printStream);

        //Вызываем функцию, которая ничего не знает о наших манипуляциях
        testString.printSomething();

        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = byteArrayOutputStream.toString();


        //Возвращаем все как было
        System.setOut(consolePrintStream);
        System.out.println(result.toUpperCase());

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
