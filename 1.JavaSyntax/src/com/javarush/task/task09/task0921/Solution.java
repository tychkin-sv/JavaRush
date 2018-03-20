package com.javarush.task.task09.task0921;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Метод в try..catch
*/

public class Solution {
    public static void main(String[] args) {
        readData();
    }

    public static void readData() {
        //напишите тут ваш код
        ArrayList<Integer> array = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
           while(true){
               Integer num = Integer.parseInt(reader.readLine());
               array.add(num);
           }
        } catch (NumberFormatException e) {
            for (int num:array) System.out.println(num);
        } catch (IOException e) {
            for (int num:array) System.out.println(num);
        }


    }
}
