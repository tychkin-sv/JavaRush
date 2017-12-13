package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int input;
//        do {
            input = Integer.parseInt(reader.readLine());
//        } while (input>150);

        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        //add your code here

        if (n<0) return "0";
        BigInteger result = BigInteger.valueOf(1);
        for (int i=n; i>0; i--){
            BigInteger bi = BigInteger.valueOf(i);
            //System.out.println(bd);
            result = result.multiply(bi);

        }
        //System.out.println(result);

        return result.toString();
    }
}
