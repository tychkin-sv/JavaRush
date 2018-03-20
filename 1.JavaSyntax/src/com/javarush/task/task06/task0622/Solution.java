package com.javarush.task.task06.task0622;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
Числа по возрастанию
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //напишите тут ваш код
        int n = 5;
        int[] arr = new int[n];
        for (int i = 0; i<n; i++ ){
            arr[i] = Integer.parseInt(reader.readLine());
        }
        // нет перестановок
        boolean change = false;
        int repeats = 0;
        do {
            change = false;
            for (int i = 0; i<n-1; i++ ){
                if (arr[i] > arr[i+1]){
                    int tmp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = tmp;
                    change = true;
                }
            }
        } while (change);

        for (int i = 0; i<n; i++ ){
            System.out.println(arr[i]);
        }
    }
}
