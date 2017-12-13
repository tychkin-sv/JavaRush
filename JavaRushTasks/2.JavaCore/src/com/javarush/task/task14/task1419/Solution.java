package com.javarush.task.task14.task1419;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }

        //напишите тут ваш код

        // 2)массив с отрицательным размером.
        try {
            int[] arrNeg = new int[-1];
        } catch (Exception e){
            exceptions.add(e);
        }
        // 3)запрос элемента с индексом больше чем размер массива
        try{
            int[] arr = new int[5];
            System.out.println(arr[5]);
        } catch (ArrayIndexOutOfBoundsException e){
            exceptions.add(e);
        }
        // 4)аналогичный для коллекций
        try{
            ArrayList<Integer> list = new ArrayList<>();
            list.add(1);
            System.out.println(list.get(1));
        } catch (Exception e){
            exceptions.add(e);
        }
        // 5)обращение к методу объекта, который является null
        try {
            Object object = null;
            System.out.println(object.hashCode());
        } catch (Exception e){
            exceptions.add(e);
        }
        // 6)недопустимое преобразование строки в число
        try {
            String string = "10 10";
            System.out.println(Integer.parseInt(string));
        } catch (Exception e){
            exceptions.add(e);
        }
        // 7)неверное сужение расширенной ссылки.
        try {
            Object object = new Object();
            Integer integer = (Integer) object;
        } catch (ClassCastException e){
            exceptions.add(e);
        }
        // 8)запрос символа строки большего чем её размер
        try {
String str = "123";
char ch = str.charAt(3);
        } catch (Exception e){
            exceptions.add(e);
        }

        // 9)отсутствие файла на жестком диске
        try{
            FileInputStream fin = new FileInputStream("text.txt");
        } catch (FileNotFoundException e){
            exceptions.add(e);
        }
        // 10)удаление элементов коллекции при итерации через for each

        try {
            ArrayList<String> sList = new ArrayList<>();
            sList.add("123");
            sList.add("456");
            Iterator<String> iterator = sList.iterator();
            while (iterator.hasNext()){
                String s = iterator.next();

                sList.add(s);
            }
        } catch (Exception e){
            exceptions.add(e);
        }
    }
}
