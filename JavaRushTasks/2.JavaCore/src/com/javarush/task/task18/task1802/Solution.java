package com.javarush.task.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        boolean first = true;
        int min = 0;
        while (inputStream.available()>0){
            if (first) { min= inputStream.read(); first=false;}
            else {
                int newByte = inputStream.read();
                if (min > newByte) min = newByte;
            }
        }
        inputStream.close();
        System.out.println(min);
    }
}
