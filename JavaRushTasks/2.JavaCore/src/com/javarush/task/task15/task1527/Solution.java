package com.javarush.task.task15.task1527;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Парсер реквестов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        //add your code here
        //String test = "http://javarush.ru/alpha/index.html?obj=314&name=Amigo";
        //String test = "http://javarush.ru/alpha/index.html?lvl=15&view&name=Amigo";

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line = reader.readLine();

        StringBuilder sb = new StringBuilder();
        // выделяем строку переменных
        String vars = line.substring(line.indexOf('?')+1,line.length());
        String varName = "";
        String varValue = "";
        int count = 0;
        for (String s:vars.split("&")) {
            count++;
            String[] arr =s.split("=");
            if ((arr.length>1) && arr[0].equals("obj"))  {
                varName = arr[0];
                varValue = arr[1];
            }
            if (count>1) System.out.print(" ");
            System.out.print(arr[0]);
        }
        System.out.println();

        if (varName.equals("obj")){
           // if (varValue.contains(".")) {
                try {
                    Double d = Double.parseDouble(varValue);
                    alert(d);
                }
                catch (Exception e) {
                    alert(varValue);
                }
           // }
           // else alert(varValue);
        }

        //System.out.println(varName + "    " + varValue);

        reader.close();;

    }

    public static void alert(double value) {
        System.out.println("double " + value);
    }

    public static void alert(String value) {
        System.out.println("String " + value);
    }
}
