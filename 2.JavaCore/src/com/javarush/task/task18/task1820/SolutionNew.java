package com.javarush.task.task18.task1820;
/*
Округление чисел
*/
import java.io.*;
import java.util.ArrayList;
import java.util.List;
public class SolutionNew {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();    //D:\JAVA\4.txt
        String file2 = reader.readLine();
        reader.close();
        FileInputStream inputStream = new FileInputStream(file1);
        FileOutputStream outputStream = new FileOutputStream(file2);
        byte[] data = new byte[inputStream.available()];
        while (inputStream.available() > 0) {
            inputStream.read(data);
        }
        int value;
        String string = new String(data);
        System.out.println(string);
        for (String s : string.split("\\s")) {
            if (!s.isEmpty()) {
                value = (int) Math.round(Double.parseDouble(s));
                outputStream.write(String.valueOf(value).getBytes());
                if (!string.endsWith(s)) {
                    outputStream.write(32);
                }
            }
        }

        inputStream.close();
        outputStream.close();
    }
}
