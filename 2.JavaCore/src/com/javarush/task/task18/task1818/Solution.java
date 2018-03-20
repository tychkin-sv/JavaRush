package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName1, fileName2, fileName3;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName1 = reader.readLine();
        fileName2 = reader.readLine();
        fileName3 = reader.readLine();

        FileInputStream fileInputStream1 = new FileInputStream(fileName2);
        FileInputStream fileInputStream2 = new FileInputStream(fileName3);
        FileOutputStream fileOutputStream = new FileOutputStream(fileName1,true);
        while (fileInputStream1.available()>0){
            int symbol = fileInputStream1.read();
            fileOutputStream.write(symbol);
        }
        fileInputStream1.close();
        while (fileInputStream2.available()>0){
            int symbol = fileInputStream2.read();
            fileOutputStream.write(symbol);
        }
        fileInputStream2.close();
        fileOutputStream.close();

    }
}
