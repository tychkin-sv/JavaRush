package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream inputStream1 = new FileInputStream(file1);
        FileOutputStream outputStream1 = new FileOutputStream(file2);

        int body = inputStream1.available();
        Stack<Integer> stack = new Stack<>();

        int count = 0;
        while (inputStream1.available()>0){
            int newByte = inputStream1.read();
            stack.push(newByte);
        }

        for (int i =0; i<body; i++){
            outputStream1.write(stack.pop());
        }

        inputStream1.close();
        outputStream1.close();
    }
}
