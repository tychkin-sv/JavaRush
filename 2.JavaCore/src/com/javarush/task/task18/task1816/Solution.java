package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = args[0];
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int sum = 0;
        int symbol;
        while (fileInputStream.available()>0){
            symbol = fileInputStream.read();
            if (((symbol>=65) && (symbol<=90)) ||((symbol>=97) && (symbol<=122))) sum++;
        }
        System.out.println(sum);
        fileInputStream.close();
    }
}
