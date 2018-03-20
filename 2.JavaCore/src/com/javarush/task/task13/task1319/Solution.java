package com.javarush.task.task13.task1319;

import java.io.*;

/* 
Писатель в файл с консоли
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName)));
        String data;
        String lineSeparator = System.getProperty("line.separator");
        do
        {
            data = reader.readLine(); //читаем один строку
            //if (data.equals("exit")) break;
            writer.write(data + lineSeparator); //записываем строку

         } while(!data.equals("exit"));

        writer.close(); //закрываем потоки
        reader.close();
    }

    }
