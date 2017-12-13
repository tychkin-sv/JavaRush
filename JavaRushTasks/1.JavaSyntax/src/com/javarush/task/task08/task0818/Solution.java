package com.javarush.task.task08.task0818;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* 
Только для богачей
*/

public class Solution {
    public static HashMap<String, Integer> createMap() {
        //напишите тут ваш код
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i<10; i++) {
            map.put("Фамилия" + i, i*100);
        }
        return map;
    }

    public static void removeItemFromMap(HashMap<String, Integer> map) {
        //напишите тут ваш код
        HashMap<String, Integer> copy = new HashMap<String, Integer>(map);

        for (Map.Entry<String, Integer> pair : copy.entrySet()) {
            int n = 0; // счетчик, он минимум будет равен 1 если нет повторений.
            String key = pair.getKey();
            Integer value = pair.getValue();
            if (value<500) map.remove(key);
        }
    }

    public static void main(String[] args) {

    }
}