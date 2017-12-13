package com.javarush.task.task07.task0718;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Проверка на упорядоченность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();

        for (int i=0; i<10; i++){
            list.add( bufferedReader.readLine());
        }

        boolean ordered = true;
        int min = 0;
        for (int i = 0; i<10; i++){
            if (list.get(min).length() > list.get(i).length()) { ordered = false; break;}
            else min = i;
        }

        if (!ordered) System.out.println(min+1);
    }
}

