package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        reader.close();

        //FileInputStream fis = new FileInputStream(fileName);
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String source = "";
        int id = Integer.parseInt(args[0]);

        while (br.ready()){

            source = br.readLine();
            //System.out.println(source.split(" ")[0]);

           if (source.split(" ")[0].equals(String.valueOf(id))) {System.out.println(source); break;}
        }

        br.close();
    }
}
