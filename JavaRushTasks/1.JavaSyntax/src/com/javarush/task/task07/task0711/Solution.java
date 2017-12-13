package com.javarush.task.task07.task0711;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Удалить и вставить
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();


        for (int i=0; i<5; i++){
            list.add( bufferedReader.readLine());
        }


        int max = list.size()-1;
        for (int i=0; i<13; i++){
            list.add(0, list.remove(max));
        }

        for (int i=0; i<5; i++){
            System.out.println(list.get(i));
        }
    }
}
