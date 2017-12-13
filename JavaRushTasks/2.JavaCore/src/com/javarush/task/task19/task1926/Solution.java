package com.javarush.task.task19.task1926;

/* 
Перевертыши
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));

        while (bufferedReader.ready()){
            String line = bufferedReader.readLine();

            StringBuilder reverse = new StringBuilder(line).reverse();

            System.out.println(reverse.toString());
        }


        console.close();
        bufferedReader.close();
    }
}
