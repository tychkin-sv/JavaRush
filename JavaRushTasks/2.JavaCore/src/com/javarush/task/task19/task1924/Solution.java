package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static{
        map.put(new Integer(0),"ноль");
        map.put(new Integer(1),"один");
        map.put(new Integer(2),"два");
        map.put(new Integer(3),"три");
        map.put(new Integer(4),"четыре");
        map.put(new Integer(5),"пять");
        map.put(new Integer(6),"шесть");
        map.put(new Integer(7),"семь");
        map.put(new Integer(8),"восемь");
        map.put(new Integer(9),"девять");
        map.put(new Integer(10),"десять");
        map.put(new Integer(11),"одиннадцать");
        map.put(new Integer(12),"двенадцать");





    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();

        BufferedReader fbr = new BufferedReader(new FileReader(fileName));
        while (fbr.ready()){
         String line = fbr.readLine();
         String[] data = line.split(" ");
        StringBuilder out = new StringBuilder();
         for (String s:data) {
            try{
                int value = Integer.parseInt(s);
                //System.out.println(value);
                if (map.containsKey(value)){
                    String replaceStr = map.get(value);
                    out.append(replaceStr + " ");
                } else {
                    out.append(s + " ");
                }

            }
             catch (NumberFormatException e){
                // Добавляем слово как есть
                out.append(s + " ");
             }
         }

          System.out.println(out.toString().trim());


        }

        fbr.close();
        reader.close();
    }
}
