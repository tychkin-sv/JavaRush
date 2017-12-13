package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //1908.txt
        //1908_result.txt
        String sourceFile = reader.readLine();
        String destFile = reader.readLine();

        FileReader fr = new FileReader(sourceFile);
        FileWriter fw = new FileWriter(destFile);
        BufferedReader bfr = new BufferedReader(fr);
        BufferedWriter bfw = new BufferedWriter(fw);

        StringBuilder sb =  new StringBuilder();
        while (bfr.ready()){
            String str = bfr.readLine();
            String[] words = str.toString().split("\\s");
            for (String s: words) {
                try{
                    System.out.println(Integer.parseInt(s));
                    bfw.write(s + " ");
                }
                catch (NumberFormatException e){
                }
            }
        }
        reader.close();
        bfw.close();
        bfr.close();
    }
}
