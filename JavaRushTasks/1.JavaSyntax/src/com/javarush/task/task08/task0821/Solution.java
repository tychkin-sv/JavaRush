package com.javarush.task.task08.task0821;

import java.util.HashMap;
import java.util.Map;

/* 
Однофамильцы и тёзки
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, String> map = createPeopleList();
        printPeopleList(map);
    }

    public static Map<String, String> createPeopleList() {
        //напишите тут ваш код
        Map<String, String> result = new HashMap<>();
        result.put("Одинаков", "Такой-же1");
        result.put("Одинаков", "Такой-же1");
        result.put("Одинаков", "Такой-же1");
        result.put("Одинаков", "Такой-же1");
        result.put("Одинаков", "Такой-же1");
        result.put("Одинаков", "Такой-же");
        result.put("Одинаков1", "Такой-же");
        result.put("Одинаков1", "Такой-же");
        result.put("Одинаков1", "Такой-же");
        result.put("Одинаков1", "Такой-же");


        return result;
    }

    public static void printPeopleList(Map<String, String> map) {
        for (Map.Entry<String, String> s : map.entrySet()) {
            System.out.println(s.getKey() + " " + s.getValue());
        }
    }
}
