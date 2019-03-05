package com.javarush.task.task30.task3010;

/* 
Минимальное допустимое основание системы счисления
*/

import java.math.BigDecimal;
import java.math.BigInteger;

public class Solution {
    // args[0] = 0123456789abcdefghijklmnopqrstuvwxyz; правильное
    // args[0] = жз; не правильное

    public static void main(String[] args) {
        //напишите тут ваш код
        try{
            String source = args[0];
            //System.out.println(source);

            for (int i=2; i<37; i++)
            {
             try {
                 new BigInteger(source, i).toString(10);
                 System.out.println(i);
                 break;

             }
             catch (Exception e){
                 //System.out.println("incorrect");
             }
             if (36==i) System.out.println("incorrect");
            }

        }
        catch (Exception e){
            //e.printStackTrace();
        }
    }
}