package com.javarush.task.task08.task0816;

import java.text.DateFormat;
import java.util.*;

/* 
Добрая Зинаида и летние каникулы
*/

public class Solution {
    public static HashMap<String, Date> createMap() {
        HashMap<String, Date> map = new HashMap<String, Date>();
        map.put("Stallone", new Date("JUNE 1 1980"));
        //напишите тут ваш код
        map.put("Shwarz", new Date("MAY 5 1980"));
        map.put("Norris", new Date("DECEMBER 16 1980"));
        map.put("Dokaskos", new Date("AUGUST 8 1980"));
        map.put("VanDamm", new Date("APRIL 24 1980"));
        map.put("Lundgren", new Date("JANUARY 14 1980"));
        map.put("Lee", new Date("JULY 22 1980"));
        map.put("Chan", new Date("JUNE 5 1980"));
        map.put("Willis", new Date("MARCH 6 1980"));
        map.put("Snipes", new Date("SEPTEMBER 15 1980"));

        return map;
    }

    public static void removeAllSummerPeople(HashMap<String, Date> map) {
        //напишите тут ваш код
        Iterator<Map.Entry<String, Date>> iterator = map.entrySet().iterator();
        Set<String> forRemove = new HashSet<>();
        while (iterator.hasNext()){
            Map.Entry<String, Date> me = iterator.next();
            //System.out.println(me.getValue().getMonth());
            if ((me.getValue().getMonth()>=5) && (me.getValue().getMonth()<=7)) forRemove.add(me.getKey());
        }
        for (String summer:forRemove) map.remove(summer);
    }

    public static void main(String[] args) {
        HashMap<String, Date> www = createMap();
        //System.out.println(www.entrySet().toString());
        removeAllSummerPeople(www);
        //System.out.println(www.entrySet().toString());


    }
}
