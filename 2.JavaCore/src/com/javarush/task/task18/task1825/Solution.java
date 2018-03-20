package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Solution {
    public static ArrayList<String> files = new ArrayList<>();
    public static Map<String, Integer> out= new HashMap<>();

    public static final String SEPARATOR = ".";
    public static final String SEQUENCE = ".part";

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String line, fileName;
        Integer part;
        //Собираем файл
        //Собираем файл из кусочков.
        //Считывать с консоли имена файлов.
        //Каждый файл имеет имя: [someName].partN.
        //Например, Lion.avi.part1, Lion.avi.part2, …, Lion.avi.part37.
        while (true) {
            line = console.readLine();
            if (line.equals("end")) {break;}

            files.add(line);

            //lost.avi.part37
            //Разделяем файл источник
            String[] arr = line.split(SEPARATOR);
            fileName = line.substring(0, line.indexOf(SEQUENCE));

            // Выделяем номер части
            part = Integer.parseInt(line.substring( line.indexOf(SEQUENCE) + SEQUENCE.length() , line.length()));

            // Если Map не содержит файла добавляем
            if (!out.containsKey(fileName)) {
                //System.out.println(part);
                out.put(fileName, part);

            } // Иначе проверяем на максимальную часть
              // если новая часть больше - оюновляем значение
            else {
                //System.out.println(part);
                if (part>out.get(fileName)) {
                    //System.out.println("Обновляем");
                    out.put(fileName, part);
                }
            }
        }
        // Закрываем пото чтения
        console.close();

/*
Для теста
lost.avi.part1
lost.avi.part2
end
*/
        for (Map.Entry<String, Integer> pair: out.entrySet()) {
            //System.out.println(pair.getKey() + " " + pair.getValue());
            File file = new File(pair.getKey());
            file.createNewFile();
            // if file doesnt exists, then create it
            //if (!file.exists()) {
             //   file.createNewFile();
            //}

            FileOutputStream fos = new FileOutputStream(file, true);

            for (int i =1; i<=pair.getValue(); i++){
                String sourceFile = pair.getKey()+ ".part"+ i;
                //System.out.println(sourceFile);
                FileInputStream fis = new FileInputStream(sourceFile);
                byte[] buffer = new byte[fis.available()];
                fis.read(buffer, 0 , buffer.length);

                //System.out.println(Arrays.toString(buffer));

                fos.write(buffer, 0, buffer.length);
                fos.flush();

                //System.out.println(buffer.length);

                // закрываем поток файла чтения
                fis.close();
            }
            // закрываем поток файла записи
            fos.close();
        }

    }
}
