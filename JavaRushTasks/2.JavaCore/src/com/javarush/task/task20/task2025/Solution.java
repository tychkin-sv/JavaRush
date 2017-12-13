package com.javarush.task.task20.task2025;

/* 
Алгоритмы-числа
*/
public class Solution {

    private static long[][] degree; // = new long[10][19];
    private static int nRang;

    public static long[] getNumbers(long N) {
        long[] result = null;

        // подготавливаем таблицу степеней
        valuesPrepare(N);
        for (long i =0; i<9_000_000_000L; i++){
            long k=i+i+i;
            if (i%1000 == 0) System.out.println(i);
        }

        return result;
    }

    public static void valuesPrepare(long N) {
        String s = "" + N;
        nRang = s.length();
        degree = new long[10][nRang];

        for (int i = 0; i < 10; i++) {
            degree[i][0] = 1;
            degree[i][1] = i;
            for (int curRang = 2; curRang < nRang; curRang++) {
                degree[i][curRang] = degree[i][curRang-1] * i;
            }
        }

    }
    public  static void printValues(long[][] arr){
        for (int i=0; i<arr.length; i++){

            for (int j=0; j<arr[i].length; j++)
            {
                System.out.print(arr[i][1]+"^" + j + "=" + arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
      valuesPrepare(9223372036854775807L);
      printValues(degree);
      getNumbers(9223372036854775807L);
    }
}
