package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException {
        BufferedReader bfr = new BufferedReader(new FileReader(args[0]));
        while (bfr.ready()){
            String line = bfr.readLine();
            String[] data = line.split(" ");
            int kol = data.length;
            int year = Integer.parseInt(data[kol-1]);
            int month = Integer.parseInt(data[kol-2]);
            int day = Integer.parseInt(data[kol-3]);
            String name = "";
            int countForName = 0;

            for (String s:data){
                name = name +  s+" ";
                countForName++;
                if (countForName==(kol-3)) break;
            }
            // Удаляем последний пробел
            name = name.trim();
            Date date = new GregorianCalendar(year, month-1, day).getTime();

            PEOPLE.add(new Person(name, date));



        }

        for (Person p : PEOPLE ) System.out.println(p);
        bfr.close();
    }
}
