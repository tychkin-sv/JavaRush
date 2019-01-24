package com.javarush.task.task31.task3110;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
2. Создай класс ConsoleHelper и реализуй в нем статические публичные методы:
2.1. Вывести сообщение в консоль void writeMessage(String message)
2.2. Прочитать строку с консоли String readString()
2.3. Прочитать число с консоли int readInt()
Методы чтения с консоли могут бросать исключение IOException в случае ошибки ввода, учти
это при их объявлении.
*/
public class ConsoleHelper {
    private static BufferedReader console =new BufferedReader( new InputStreamReader(System.in));


    public static void writeMessage(String message){
        System.out.println(message);
    }

    public static String readString() {

        while (true) {
            try {
                return console.readLine();
            } catch (IOException e) {
                System.out.println("Произошла ошибка при попытке ввода текста. Попробуйте еще раз.");
            }
        }
    }

    public static int readInt(){
        while (true) {
            try {
                return Integer.parseInt(readString());
            } catch (NumberFormatException e) {
                System.out.println("Произошла ошибка\n" +
                        "при попытке ввода числа. Попробуйте еще раз.");
            }
        }
    }
}
