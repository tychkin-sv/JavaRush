package com.javarush.task.task05.task0532;

import java.io.*;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        int maximum = 0;
        for (int i = 1; i<=n; i++){
            if (i==1) maximum = Integer.parseInt(reader.readLine());
            else {
                int newValue = Integer.parseInt(reader.readLine());
                if (newValue>maximum) maximum = newValue;
            }
        }


        //напишите тут ваш код

        if (n>0) System.out.println(maximum);
    }
}
