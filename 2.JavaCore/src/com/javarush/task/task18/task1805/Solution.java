package com.javarush.task.task18.task1805;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/* 
Сортировка байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        ArrayList<Integer> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);

        while (inputStream.available()>0){
            int newByte = inputStream.read();
            if (!list.contains(newByte)) list.add(newByte);
            //System.out.println(newByte + " " + count);
        }
        inputStream.close();
        //System.out.println("=====");
        // сортировка
        Collections.sort(list);

        String resultString = "";
       for (Integer i: list) resultString = resultString + i + " ";
       System.out.println(resultString.trim());
    }
}
