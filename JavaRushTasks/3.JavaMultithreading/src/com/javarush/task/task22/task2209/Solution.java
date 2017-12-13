package com.javarush.task.task22.task2209;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

/*
Составить цепочку слов
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //...
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();
        console.close();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        StringBuilder source = new StringBuilder();
        while (reader.ready()){
            source.append(reader.readLine()+" ");
        }
        reader.close();

        String[] words = source.toString().split(" ");

        StringBuilder result = getLine(words);
        System.out.println(result.toString());
    }

    public static StringBuilder getLine(String... words) {

        if (words == null || words.length == 0)
            return new StringBuilder();
        if ("".equals(words[0]) || words.length == 1)
            return new StringBuilder(words[0]);

        StringBuilder sb = new StringBuilder();

        if ((words!=null)){
            LinkedList<String> list = new LinkedList<>(Arrays.asList(words));
            Collections.sort(list);

            boolean isCorrect;

            while (true){
                Collections.shuffle(list);
                isCorrect = true;
//-----------проверка правильной последовательности
                for(int i = 0; i < list.size(); i++){
                    if(i+1 != list.size()){
                        if(!list.get(i).substring(list.get(i).length()-1).equalsIgnoreCase(list.get(i+1).substring(0, 1).toLowerCase())){
                            isCorrect = false;
                            break;
                        }
                    }
                }
                if(isCorrect)
                    break;

            }
            for (String s: list) sb.append(s).append(" ");
            sb.deleteCharAt(sb.length()-1);
            return sb;
        }
        else return sb;

    }

}
