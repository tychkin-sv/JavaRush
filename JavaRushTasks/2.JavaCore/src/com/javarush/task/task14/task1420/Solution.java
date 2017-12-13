package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String sValue1 = reader.readLine();
        String sValue2 = reader.readLine();

        Integer iValue1 = Integer.parseInt(sValue1);
        Integer iValue2 = Integer.parseInt(sValue2);

        if ((iValue1>0) && (iValue2>0)){
            ArrayList<Integer> arr1 = new ArrayList<>();
            for (int i=iValue1; i>0; i--){
                if (iValue1%i == 0) {arr1.add(i);}
            }
            ArrayList<Integer> arr2 = new ArrayList<>();
            for (int i=iValue2; i>0; i--){
                if (iValue2%i == 0) {arr2.add(i);}
            }

            //for (Integer i:arr1) System.out.println(i);
            //for (Integer i:arr2) System.out.println(i);
            ArrayList<Integer> arr = new ArrayList<>();
            Integer max = 0;
            for(Integer i:arr1) {
                for(Integer j:arr2) {
                    if ((i == j) && !arr.contains(i)) {arr.add(i);
                    if(max<i){max = i;}}
                }
            }
            if (max!=0) System.out.println(max);
            //for (Integer i:arr) System.out.println(i);
        }else throw new Exception();

    }
}
