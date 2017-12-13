package com.javarush.task.task19.task1913;

/* 
Выводим только цифры

Выводим только цифры
В методе main подмени объект System.out написанной тобой ридер-оберткой по аналогии с лекцией.
Твоя ридер-обертка должна выводить только цифры.
Вызови готовый метод printSomething(), воспользуйтесь testString.
Верни переменной System.out первоначальный поток.
Выведи модифицированную строку в консоль.

Пример вывода:
12345678

Требования:
1. Класс Solution должен содержать класс TestString.
2. Класс Solution должен содержать публичное статическое поле testString
    типа TestString, которое сразу проинициализировано.
3. Класс TestString должен содержать публичный void метод printSomething().
4. Метод printSomething() класса TestString должен выводить на экран
    строку "it's 1 a 23 text 4 f5-6or7 tes8ting".
5. Метод main(String[] args) класса Solution должен создавать поток PrintStream
   (используй PrintStream c параметром конструктора ByteArrayOutputStream).
6. Метод main(String[] args) класса Solution должен подменять и восстанавливать
    поток вывода в консоль объекта System.out.
7. Метод main(String[] args) класса Solution должен вызывать метод printSomething(),
    объекта testString.
8. Метод main(String[] args) класса Solution должен модифицировать строку выведенную
    методом printSomething() согласно заданию, и выводить её в консоль.
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

        //String[] arr = result.split("\\D+");
        //System.out.println(Arrays.toString(arr));
         // \d+
        System.out.println(result.replaceAll("\\D","") );

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's 1 a 23 text 4 f5-6or7 tes8ting");
        }
    }
}
