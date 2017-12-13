package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sourceFile = reader.readLine();
        String destinationFile = reader.readLine();
        FileReader fr = new FileReader(sourceFile);
        FileWriter fw = new FileWriter(destinationFile);
        reader.close();
        int count=0;
        while (fr.ready()){
            int symbol = fr.read();
            count++;
            if (count%2==0) fw.write(symbol);
        }

            fr.close();
        fw.close();

    }
}
