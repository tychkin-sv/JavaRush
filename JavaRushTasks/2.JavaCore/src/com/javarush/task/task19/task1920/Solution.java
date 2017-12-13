package com.javarush.task.task19.task1920;

/* 
Самый богатый
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

        String keyMax = "";
        Double valueMax = 0.0;
        for (Map.Entry<String, Double> pair: map.entrySet()){

            if (valueMax<pair.getValue()) {
                valueMax = pair.getValue();
                keyMax = pair.getKey();
            }
            //System.out.println(pair.getKey() + " " + pair.getValue());
        }

        double e= 0.0000000001;

        // 1920.txt
        // Симкин ! Точность
        //Вывод всех у кого не отлдичается от максимума
        for (Map.Entry<String, Double> pair: map.entrySet()){

            if (Math.abs(valueMax-pair.getValue())< e) {
               System.out.println(pair.getKey() );
            }
        }


        //System.out.println(keyMax);
        bfr.close();

    }
}
