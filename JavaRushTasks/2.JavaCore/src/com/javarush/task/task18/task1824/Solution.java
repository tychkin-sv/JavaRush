package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader console_in = new BufferedReader(new InputStreamReader(System.in));
        PrintStream console = System.out;
        String fileName;
        ArrayList<FileInputStream> fis = new ArrayList<>();

        while (true){
           fileName = console_in.readLine();
            try{
               FileInputStream stream = new FileInputStream(fileName);
               fis.add(stream);
           }
           catch (FileNotFoundException e)
           {
               console.println(fileName);
               break;
           }
        }

        for (FileInputStream stream: fis) stream.close();


        console_in.close();

    }
}
