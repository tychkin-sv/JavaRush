package com.javarush.task.task03.task0319;

/* 
Предсказание на будущее
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String name="";
        String sValue1="";
        String sValue2="";
        InputStream inputStream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        name = bufferedReader.readLine();
        sValue1 = bufferedReader.readLine();
        sValue2 = bufferedReader.readLine();


        System.out.println(name + " получает " + sValue1 + " через " + sValue2 + " лет.");

    }
}
