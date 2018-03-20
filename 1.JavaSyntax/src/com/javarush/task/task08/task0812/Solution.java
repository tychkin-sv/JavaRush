package com.javarush.task.task08.task0812;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;

/* 
Cамая длинная последовательность
*/
public class Solution {
    public static void main(String[] args) throws IOException {
        //напишите тут ваш код
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();

        for(int i=0; i<10; i++) {
            String s = reader.readLine();
            list.add(Integer.parseInt(s));
        }
        int repeats;
        int repeats_max = 1;
        for (int i=0; i<10-1; i++)
        {
            repeats = 1;
            for (int j = i+1; j<10; j++)
                if (list.get(i)==list.get(j)) repeats++;
            if (repeats>repeats_max) repeats_max = repeats;

        }
        System.out.println(repeats_max);
    }
}