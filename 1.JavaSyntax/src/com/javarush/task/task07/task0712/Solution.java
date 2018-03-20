package com.javarush.task.task07.task0712;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
Самые-самые
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();


        for (int i=0; i<10; i++){
            list.add( bufferedReader.readLine());
        }

        int indexMax = 0;
        int indexMin = 0;

        for (int i=1; i<10; i++){
           if (list.get(indexMax).length() < list.get(i).length()) indexMax = i;
           if (list.get(indexMin).length() > list.get(i).length()) indexMin= i;
        }
        if (indexMin < indexMax) System.out.println(list.get(indexMin));
        else System.out.println(list.get(indexMax));

    }
}
