package com.javarush.task.task20.task2026;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/*
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };

        byte[][] my = new byte[][]{
                {1, 1, 1, 1, 1, 1},
                {1, 0, 0, 0, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 1},
                {1, 1, 1, 1, 1, 1}
        };


        int count = getRectangleCount(a);
        System.out.println("count = " + count + ". Должно быть 2");
    }

    public static int getRectangleCount(byte[][] a) {
        int count = 0;
        for (int x = 0; x < a[0].length; x++) {
            for (int y = 0; y < a[0].length; y++) {
               //System.out.println(a[x][y]);
                if ( (a[x][y] == 1) && (( (x==0) || (a[x-1][y] == 0) ) && ( (y==0) || (a[x][y-1] == 0) )) ) {
                    count++;
                }
            }
        }

        return count;
    }



}
