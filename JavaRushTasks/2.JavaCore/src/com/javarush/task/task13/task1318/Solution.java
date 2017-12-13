package com.javarush.task.task13.task1318;

import java.io.*;


/* 
Чтение файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        InputStream is = new FileInputStream(fileName);

        while (is.available() > 0){
            int data = is.read();
            System.out.print((char) data );
        }
        System.out.println(); // без этого не принимается
        is.close();
        reader.close();
    }
}