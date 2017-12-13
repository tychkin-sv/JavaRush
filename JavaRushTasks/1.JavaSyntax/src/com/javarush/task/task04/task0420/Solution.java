package com.javarush.task.task04.task0420;

/* 
Сортировка трех чисел
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num1 = Integer.parseInt(bufferedReader.readLine());
        int num2 = Integer.parseInt(bufferedReader.readLine());
        int num3 = Integer.parseInt(bufferedReader.readLine());
        int order1 = num1, order2 = num2, order3 = num3;

        if (num1>=num2 && num1>num3) order1 = num1;
        else  if (num2>=num1 && num2>=num3) order1 = num2;
        else order1 = num3;

        if (order1 == num1){
            if (num2>=num3) {
                order2 = num2;
                order3 = num3;
            }
            else {
                order2 = num3;
                order3 = num2;
            }
        }

        if (order1 == num2){
            if (num1>=num3) {
                order2 = num1;
                order3 = num3;
            }
            else {
                order2 = num3;
                order3 = num1;
            }
        }

        if (order1 == num3){
            if (num1>=num2) {
                order2 = num1;
                order3 = num2;
            }
            else {
                order2 = num2;
                order3 = num1;
            }
        }

        System.out.println(order1 + " " + order2 + " " + order3);

    }
}
