package com.javarush.task.task03.task0318;

/* 
План по захвату мира
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        String name="";
        String sYear="";
        InputStream inputStream = System.in;
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        sYear = bufferedReader.readLine();
        name = bufferedReader.readLine();

        System.out.println(name + " захватит мир через " + sYear + " лет. Му-ха-ха!");
    }
}
