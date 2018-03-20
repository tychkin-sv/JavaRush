package com.javarush.task.task09.task0927;

import java.util.*;

/* 
Десять котов
*/

public class Solution {
    public static void main(String[] args) {
        Map<String, Cat> map = createMap();
        Set<Cat> set = convertMapToSet(map);
        printCatSet(set);
    }

    public static Map<String, Cat> createMap() {
        //напишите тут ваш код
        HashMap<String, Cat> map = new HashMap<>();
        map.put( "Мурка", new Cat( "Мурка" ) );
        map.put( "Мурзик", new Cat( "Мурзик" ) );
        map.put( "Васька", new Cat( "Васька" ) );
        map.put( "Пушек", new Cat( "Пушек" ) );
        map.put( "Бобик", new Cat( "Бобик" ) );
        map.put( "Жучка", new Cat( "Жучка" ) );
        map.put( "Лиза", new Cat( "Лиза" ) );
        map.put( "Димка", new Cat( "Димка" ) );
        map.put( "Кузька", new Cat( "Кузька" ) );
        map.put( "Маркиз", new Cat( "Маркиз" ) );
        return map;
    }

    public static Set<Cat> convertMapToSet(Map<String, Cat> map) {
        //напишите тут ваш код
        HashSet<Cat> set = new HashSet<Cat>();
        for (Map.Entry<String, Cat> pair: map.entrySet()){
            set.add(pair.getValue());
        }
        return set;
    }

    public static void printCatSet(Set<Cat> set) {
        for (Cat cat : set) {
            System.out.println(cat);
        }
    }

    public static class Cat {
        private String name;

        public Cat(String name) {
            this.name = name;
        }

        public String toString() {
            return "Cat " + this.name;
        }
    }


}
