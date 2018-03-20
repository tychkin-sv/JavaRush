package com.javarush.task.task08.task0830;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Задача по алгоритмам
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] array = new String[20];
        for (int i = 0; i < array.length; i++) {
            array[i] = reader.readLine();
        }

        sort(array);

        for (String x : array) {
            System.out.println(x);
        }
    }

    public static void sort(String[] array) {
        //напишите тут ваш код
        boolean change = false;
        int n = array.length;
        do {
            change = false;
            for (int i = 0; i<n-1; i++ ){
                if (isGreaterThan(array[i], array[i+1])){
                    String tmp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = tmp;
                    change = true;
                }
            }
        } while (change);
    }

    //Метод для сравнения строк: 'а' больше чем 'b'
    public static boolean isGreaterThan(String a, String b) {
        return a.compareTo(b) > 0;
    }
}
