package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        // напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        InputStream fis = new FileInputStream(reader.readLine());

        ArrayList<Integer> list = new ArrayList<>();
        String s = "";

        while (fis.available()>0){
            char nextChar = (char) fis.read();
            System.out.println((int) nextChar);
            if ((nextChar!='\n') && (nextChar!='\r') ){
                s = s + nextChar;
            }
            else if (!s.isEmpty()) {
                Integer val = Integer.parseInt(s);
                //System.out.println(s);
                if (val%2==0) list.add(Integer.parseInt(s));
                s = "";
            }
        }

        Collections.sort(list);

        for (Integer i: list) System.out.println(i);
        fis.close();


    }
}
