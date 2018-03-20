package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        String fileName = args[0];
        FileInputStream fileInputStream = new FileInputStream(fileName);
        Map<Integer, Integer> map = new TreeMap<>();

        int symbol;

        while (fileInputStream.available()>0){
            symbol = fileInputStream.read();
            if (!map.containsKey(symbol)) map.put(symbol, 1);
            else {
                int count = map.get(symbol)+1;
                map.put(symbol, count);
            }

        }

       for (Map.Entry<Integer, Integer> pair: map.entrySet()) {
            symbol = pair.getKey();
            System.out.println( (char) symbol + " " + pair.getValue());
       }

        fileInputStream.close();
    }
}
