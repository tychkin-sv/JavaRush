package com.javarush.task.task18.task1804;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые редкие байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> map = new HashMap<>();

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileInputStream inputStream = new FileInputStream(fileName);
        // boolean first = true;

        while (inputStream.available()>0){
            int newByte = inputStream.read();
            int count=0;

            if (map.containsKey(newByte)) count = map.get(newByte);
            map.put(newByte, count+1);
            //System.out.println(newByte + " " + count);
        }

        inputStream.close();
        //System.out.println("=====");
        int min = 100000000;
        boolean first = true;
        for (Map.Entry<Integer,Integer> pair:map.entrySet()){
            if (first) {
                min = pair.getValue();
                first = false;
            }
            //System.out.println(pair.getKey() + " " + pair.getValue());
            if (min>pair.getValue()) {
                min = pair.getValue();
            }
        }
        //System.out.println(min);
        String resultString = "";
        if (!map.isEmpty()){
            for (Map.Entry<Integer,Integer> pair:map.entrySet())
                if (min==pair.getValue()) resultString = resultString + pair.getKey() + " ";
        }
        System.out.println(resultString.trim());

    }
}
