package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileInputStream inputStream1 = new FileInputStream(file1);
        FileOutputStream outputStream1 = new FileOutputStream(file2);
        FileOutputStream outputStream2 = new FileOutputStream(file3);

        int body = inputStream1.available();
        int part = body/2 + body%2;
        int count = 0;
        while (inputStream1.available()>0){
            int newByte = inputStream1.read();
            count++;
            if (count<part+1) outputStream1.write(newByte);
            else outputStream2.write(newByte);
        }

        inputStream1.close();
        outputStream1.close();
        outputStream2.close();

    }
}
