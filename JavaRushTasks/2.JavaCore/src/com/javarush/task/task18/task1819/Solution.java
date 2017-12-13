package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1, fileName2;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        fileName1 = reader.readLine();
        fileName2 = reader.readLine();

        FileInputStream inputStream1 = new FileInputStream(fileName1);
        FileInputStream inputStream2 = new FileInputStream(fileName2);

        while (inputStream2.available()>0) list.add(inputStream2.read());
        while (inputStream1.available()>0) list.add(inputStream1.read());
        inputStream1.close();
        inputStream2.close();

        FileOutputStream outputStream = new FileOutputStream(fileName1);
        for (int i: list) outputStream.write(i);
        outputStream.close();


    }
}
