package com.javarush.task.task19.task1907;

/* 
Считаем слово

Считать с консоли имя файла.
Файл содержит слова, разделенные знаками препинания.
Вывести в консоль количество слов «world«, которые встречаются в файле.
Закрыть потоки.
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static String SEARCH_WORD = "world";

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //1907.txt
        String sourceFile = reader.readLine();
        reader.close();

        FileReader fr = new FileReader(sourceFile);
        int count = 0;
        StringBuilder sb =  new StringBuilder();
        while (fr.ready()){
            sb.append((char) fr.read());
        }
        String str = sb.toString();
        System.out.println(str);
        String[] words = str.toString().split("\\W");
        for (String s: words) {
            if (s.toLowerCase().equals(SEARCH_WORD)) count++;
        }


        System.out.println(count);
        fr.close();
    }
}
