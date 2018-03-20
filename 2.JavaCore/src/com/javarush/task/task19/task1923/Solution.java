package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        String sourceFileName =  args[0];
        String destFileName =  args[1];


        BufferedReader reader = new BufferedReader(new FileReader(sourceFileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter(destFileName));


        while (reader.ready()){
            String line = reader.readLine();
            String data[] = line.split(" ");

            for (String s: data){

                for (int i = 0; i< s.length(); i++){
                    if (Character.isDigit(s.charAt(0))){
                        writer.write(s+ " ");
                        break;
                    }
                }
            }

        }


        reader.close();
        writer.close();





    }
}
