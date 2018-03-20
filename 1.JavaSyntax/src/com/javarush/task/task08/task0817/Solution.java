package com.javarush.task.task08.task0817;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* 
Нам повторы не нужны
*/

public class Solution {
    public static HashMap<String, String> createMap() {
        //напишите тут ваш код
        HashMap<String,String> result = new HashMap<String,String>();
        for (int i = 0; i<10; i++) {
           if (i<8) result.put("Фамилия" + i, "Имя" + i);
           else result.put("Фамилия" + i, "Имя" + 0);
        }
        return result;
    }

    public static void removeTheFirstNameDuplicates(HashMap<String, String> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, String>> iterator1 = map.entrySet().iterator();
        HashSet<String> setToRemove = new HashSet<>();


        while (iterator1.hasNext())
        {
            int n=0; // счетчик, он минимум будет равен 1 если нет повторений.
            Map.Entry<String, String> pair1 = iterator1.next();
            String key1 = pair1.getKey();
            String value1 = pair1.getValue();

            Iterator<Map.Entry<String, String>> iterator2 = map.entrySet().iterator();
            while (iterator2.hasNext())
            {
                Map.Entry<String ,String> pair2 = iterator2.next();
                String key2 = pair2.getKey();
                String value2 = pair2.getValue();

                if (value1.equals(value2)) n++;
            }
            if (n>1) setToRemove.add(value1); // использую метод для удаления повторяющихся имен
        }
        for (String removeValue : setToRemove) {
            removeItemFromMapByValue(map,removeValue);
        }
    }

    public static void removeItemFromMapByValue(HashMap<String, String> map, String value) {
        HashMap<String, String> copy = new HashMap<String, String>(map);
        for (Map.Entry<String, String> pair : copy.entrySet()) {
            if (pair.getValue().equals(value))
                map.remove(pair.getKey());
        }
    }

    public static void main(String[] args) {

        HashMap<String, String> map = createMap();
        removeTheFirstNameDuplicates(map);

    }
}
