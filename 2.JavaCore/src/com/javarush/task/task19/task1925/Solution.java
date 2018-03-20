package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static ArrayList<String> list = new ArrayList<>();
    public static final int MAX_LENGTH = 6;

    public static void main(String[] args) throws IOException {
        String sourceFileName = args[0];
        String desFileName = args[1];

        BufferedReader reader = new BufferedReader(new FileReader(sourceFileName));
        BufferedWriter writer = new BufferedWriter(new FileWriter(desFileName));
        StringBuilder sb = new StringBuilder();
        while (reader.ready()){
            String line = reader.readLine();
            String words[] = line.split(" ");
            for (String word: words){
                if (word.length()>MAX_LENGTH){
                    sb.append(word).append(",");
                }
            }
        }

        sb.delete(sb.length()-1,sb.length());
        writer.write(sb.toString());

        reader.close();
        writer.close();
    }
}
