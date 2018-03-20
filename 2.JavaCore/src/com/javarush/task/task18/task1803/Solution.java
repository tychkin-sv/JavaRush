package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* 
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        int value = 0;
        int maxCount = 0;
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
        int max = 0;
        for (Map.Entry<Integer,Integer> pair:map.entrySet()){
            //System.out.println(pair.getKey() + " " + pair.getValue());
            if (max<pair.getValue()) {
                value = pair.getKey();
                maxCount = pair.getValue();
                max = maxCount;
            }
        }
        String resultString = "";
        if (!map.isEmpty()){
        for (Map.Entry<Integer,Integer> pair:map.entrySet())
            if (max==pair.getValue()) resultString = resultString + pair.getKey() + " ";
        }
        System.out.println(resultString.trim());
    }
}
