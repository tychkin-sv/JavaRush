package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static Map<String, Double> map = new TreeMap<>();

    public static void main(String[] args) throws IOException {

        FileReader fr = new FileReader(args[0]);
        BufferedReader bfr = new BufferedReader(fr);
        while (bfr.ready()){
            String line = bfr.readLine();
            String[] data = line.split(" ");
            String name = data[0];
            Double salary = Double.parseDouble(data[1]);

            if (map.containsKey(name)) {
                Double oldSalary = map.get(name);
                map.put(name, salary + oldSalary);
            }
            else map.put(name, salary);
        }

// 1919.txt
        for (Map.Entry<String, Double> pair: map.entrySet()){
            System.out.println(pair.getKey() + " " + pair.getValue());
        }
        bfr.close();

    }
}
