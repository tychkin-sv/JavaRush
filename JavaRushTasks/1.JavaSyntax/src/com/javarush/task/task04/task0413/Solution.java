package com.javarush.task.task04.task0413;

/* 
День недели
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    enum Days {понедельник, вторник, среда, четверг, пятница, суббота, воскресенье}
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        Days days;
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        //«понедельник», «вторник», «среда», «четверг», «пятница», «суббота», «воскресенье»,
        //если введен номер больше 7 или меньше 1 – вывести «такого дня недели не существует».
        if (num>7 || num<1) System.out.println("такого дня недели не существует");
        else System.out.println(Days.values()[num -1]);
      //  System.out.println(Arrays.toString(Days.values()));
    }
}