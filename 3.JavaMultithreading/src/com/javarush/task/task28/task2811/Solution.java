package com.javarush.task.task28.task2811;

/* 
ReentrantReadWriteLock
*/

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) {
        ReadWriteMap<Integer, String> linkedSafeMap = new ReadWriteMap<>(new LinkedHashMap<>());

        linkedSafeMap.put(1,"Сергей");
        linkedSafeMap.put(2,"Сергей");
        linkedSafeMap.put(3,"Сергей");


        System.out.println(linkedSafeMap.get(1));
        System.out.println(linkedSafeMap.get(2));
        System.out.println(linkedSafeMap.get(3));

        for (Map.Entry<Integer,String> s: linkedSafeMap.getMap().entrySet()){
            System.out.println(s.getKey() + "   " + s.getValue());
        }

    }
}
