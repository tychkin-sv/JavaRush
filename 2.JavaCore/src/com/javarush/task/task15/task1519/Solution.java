package com.javarush.task.task15.task1519;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.text.ParseException;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //напиште тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        do{
            String line = reader.readLine();
            if (line.equals("exit")) break;
            try {

                Double d = Double.parseDouble(line);
                if(line.contains(".")) {print(d); continue;};

                int i = Integer.parseInt(line);
                if ((i > 0) && (i < 128)) print((short) i);
                else print(i);
            } catch (Exception e){
                print(line);
            }
        } while (true);
    }

    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
