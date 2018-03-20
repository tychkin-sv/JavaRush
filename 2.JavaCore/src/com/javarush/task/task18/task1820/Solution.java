package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    //1820.txt
    //1820_result.txt

    public static void main(String[] args) throws IOException {
        System.out.println((char) 32);
        System.out.println(" ".getBytes().length);

        String fileName1, fileName2;
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        // data.dat
        fileName1 = reader.readLine();
        fileName2 = reader.readLine();

        FileInputStream inputStream = new FileInputStream(fileName1);
        FileOutputStream outputStream = new FileOutputStream(fileName2);

        int symbol;
        String value ="";
        int count;
        while (inputStream.available() > 0){
            symbol = inputStream.read();
            //System.out.println(value);
            if ((symbol!=32)) value = value + (char) symbol;
            else {
                //System.out.println(value);
                list.add((int) Math.round(Double.parseDouble(value)));
                value="";
            }
        }
        list.add((int) Math.round(Double.parseDouble(value)));

         String result = "";
         for (int i:list) result+=i + " ";
         result = result.trim();
         for (char c: result.toCharArray()) {
             outputStream.write((int) c);
         }
        inputStream.close();
        outputStream.close();

    }
}
