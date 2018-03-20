package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        PrintStream concolePrintStream = System.out;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(byteArrayOutputStream);
        System.setOut(printStream);

        testString.printSomething();
        //Преобразовываем записанные в наш ByteArray данные в строку
        String result = byteArrayOutputStream.toString();

        System.setOut(concolePrintStream);
        System.out.println(result);

        //1915.txt
        FileOutputStream outputStream = new FileOutputStream(fileName);
        outputStream.write(result.getBytes());
        outputStream.close();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

