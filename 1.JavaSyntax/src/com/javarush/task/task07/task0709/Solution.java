package com.javarush.task.task07.task0709;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Выражаемся покороче
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();


        for (int i=0; i<5; i++){
            list.add(bufferedReader.readLine());
        }

        int min = list.get(0).length();
        for (int i=0; i<5; i++){
            if (min > list.get(i).length() ) min = list.get(i).length();
        }

        for (int i=0; i<5; i++){
            if (min == list.get(i).length() ) System.out.println(list.get(i));
        }
    }
}
