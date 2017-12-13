package com.javarush.task.task26.task2601;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Почитать в инете про медиану выборки
*/
public class Solution {
    public static double accuracy = 0.0000001;

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{13, 8, 15, 5, 17};
        arr = sort(arr);
        //System.out.println(Arrays.toString(arr));
    }

    public static Integer[] sort(Integer[] array) {
        //implement logic here
        Arrays.sort(array);
        int len = array.length;
        int medianLeft = (len%2 == 0)? len/2 -1 :  len/2 ;
        int medianRight = len/2;

        double medianValue = (array[medianLeft] + array[medianRight])/2.0;
        //System.out.println(medianValue);

        Comparator<Integer> compareByMedian = new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                double compareValue = Math.abs(o1-medianValue) - Math.abs(o2-medianValue);
                if (Math.abs(compareValue) < accuracy)
                    compareValue = o1 - o2;
                return (int)compareValue;
            }
        };
        Arrays.sort(array, compareByMedian);
        //System.out.println("medianLeft " + medianLeft);
        //System.out.println("medianRight " + medianRight);

        return array;
    }

}
