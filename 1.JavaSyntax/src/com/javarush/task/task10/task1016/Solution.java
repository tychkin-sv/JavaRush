package com.javarush.task.task10.task1016;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/* 
Одинаковые слова в списке
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> words = new ArrayList<String>();
        for (int i = 0; i < 20; i++) {
            words.add(reader.readLine());
        }

        Map<String, Integer> map = countWords(words);

        for (Map.Entry<String, Integer> pair : map.entrySet()) {
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
    }

    public static Map<String, Integer> countWords(ArrayList<String> list) {
        HashMap<String, Integer> result = new HashMap<String, Integer>();

        //напишите тут ваш код
for (int i=0; i<list.size(); i++) {
    String s = list.get(i);
    if (result.containsKey(s)) continue;
    int count = 1;
    for (int j=i+1; j< list.size(); j++){
        if (list.get(j).equals(s)) count++;
    }
    if (!result.containsKey(s)) result.put(s, count);
}
// последнюю терял
//if (!result.containsKey(list.get(list.size()-1))) result.put(list.get(list.size()-1), 1);

        return result;
    }

}

