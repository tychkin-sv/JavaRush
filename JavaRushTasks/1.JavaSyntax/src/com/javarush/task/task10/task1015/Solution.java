package com.javarush.task.task10.task1015;

import java.util.ArrayList;

/* 
Массив списков строк
*/

public class Solution {
    public static void main(String[] args) {
        ArrayList<String>[] arrayOfStringList = createList();
        printList(arrayOfStringList);
    }

    public static ArrayList<String>[] createList() {
        //напишите тут ваш код
        ArrayList<String>[] arrayLists = new ArrayList[2];
        arrayLists[0] = new ArrayList<>();
        arrayLists[0].add("Первый элемент");
        arrayLists[0].add("Второй элемент");

        arrayLists[1] = new ArrayList<>();
        arrayLists[1].add("Первый элемент");
        arrayLists[1].add("Второй элемент");
        return arrayLists;

       /* ArrayList<String>[] result;
        result = new ArrayList[10];
        for (int i=0; i<10; i++) {
            ArrayList<String> arr = new ArrayList<>();
            arr.add("String 0");
            for (int index=0; index<i; index++) arr.add("String " + (index+1));
            result[i] = arr;
        };
        return result;*/
    }

    public static void printList(ArrayList<String>[] arrayOfStringList) {
        for (ArrayList<String> list : arrayOfStringList) {
            for (String s : list) {
                System.out.println(s);
            }
        }
    }
}