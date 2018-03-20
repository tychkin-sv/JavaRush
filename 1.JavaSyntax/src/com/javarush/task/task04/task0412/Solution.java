package com.javarush.task.task04.task0412;

/* 
Положительное и отрицательное число
*/

import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num = Integer.parseInt(bufferedReader.readLine());
        if (num < 0 ) System.out.println(++num);
        else if (num == 0) System.out.println(num);
        else System.out.println(num + num);
    }

}