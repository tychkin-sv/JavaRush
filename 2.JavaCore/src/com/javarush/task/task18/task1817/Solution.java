package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int sum_space = 0;
        double sum = fileInputStream.available();
        int symbol;
        while (fileInputStream.available()>0){
            symbol = fileInputStream.read();
            if (symbol==32) sum_space++;
        }
        double d = sum_space / sum;

        //System.out.println(sum_space);
        //System.out.println(sum);
       // System.out.println(d);
        System.out.printf("%.2f", d*100);

        fileInputStream.close();
    }
}
