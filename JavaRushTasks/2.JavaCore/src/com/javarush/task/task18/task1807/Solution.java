package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
       // ArrayList<Integer> list = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);

        int count = 0;
        while (inputStream.available()>0){
            int newByte = inputStream.read();
            if ((char) newByte == ',') count++;

        }
        inputStream.close();
        System.out.println(count);
    }
}
