package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
    public static Properties myProperies = new Properties();

    public static String fileName;

    public void fillInPropertiesMap() throws Exception {
        //implement this method - реализуйте этот метод
        BufferedReader conReader = new BufferedReader(new InputStreamReader(System.in));
        fileName = conReader.readLine();
        conReader.close();

        FileInputStream fileInputStream = new FileInputStream (Solution.fileName);
        load(fileInputStream);
        fileInputStream.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        //implement this method - реализуйте этот метод
        myProperies.clear();
        for (Map.Entry<String, String> pair : properties.entrySet()) {
            myProperies.put (pair.getKey(), pair.getValue());
        }
        myProperies.store(outputStream,"Мои свойства");

    }

    public void load(InputStream inputStream) throws Exception {
        //implement this method - реализуйте этот метод
        myProperies.load(inputStream);
        for (Map.Entry<Object, Object> pair: myProperies.entrySet()) {
            properties.put((String) pair.getKey(), (String) pair.getValue());
        }
    }

    public static void main(String[] args) throws Exception {
        Solution solution = new Solution();
        properties.put("dimension","10x10");
        properties.put("language","russian");
        solution.fillInPropertiesMap();

        FileOutputStream fileOutputStream = new FileOutputStream(fileName);
        solution.save(fileOutputStream);
        fileOutputStream.close();
    }
}
