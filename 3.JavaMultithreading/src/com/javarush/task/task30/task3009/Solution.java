package com.javarush.task.task30.task3009;

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;

/* 
Палиндром?
*/

public class Solution {

    private static Set<Integer> getRadix(String number){
        Set<Integer> set = new HashSet<>();
        try{
            BigInteger bi = new BigInteger(number);
            // Use BigInteger to convert radix
            // And StringBuilder reverse for check mirror
            for (int i=2; i<=36; i++){
               StringBuilder sb = new StringBuilder(bi.toString(i));
               if (sb.toString().equals(sb.reverse().toString())) set.add(i);
            }
        }
        catch (NumberFormatException e){
            //System.out.println("Число не корректно");
        }
        finally {
            return set;
        }
    }


    public static void main(String[] args) {
        System.out.println(getRadix("112"));        //expected output: [3, 27, 13, 15]
        System.out.println(getRadix("123"));        //expected output: [6]
        System.out.println(getRadix("5321"));       //expected output: []
        System.out.println(getRadix("1A"));         //expected output: []
    }
}