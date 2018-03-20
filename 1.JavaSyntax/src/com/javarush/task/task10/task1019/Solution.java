package com.javarush.task.task10.task1019;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Функциональности маловато!
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        HashMap<String, Integer> map = new HashMap<>();

        do {
            String inValue = reader.readLine();
            if (inValue.isEmpty()) break;

            int id = Integer.parseInt(inValue);
            String name = reader.readLine();

            map.put(name, id);

        } while (true);

        for (Map.Entry<String, Integer> pair: map.entrySet()){
            System.out.println(pair.getValue()+ " " +pair.getKey());

        }

    }
}
