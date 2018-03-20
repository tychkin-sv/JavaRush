package com.javarush.task.task14.task1420;

/**
 * Created by userPG on 16.08.2017.
 */
import java.io.BufferedReader;
import java.io.InputStreamReader;
public class Solution1 {
        public static void main(String[] args) throws Exception {
            BufferedReader rd = new BufferedReader(new InputStreamReader(System.in));
            String str1 = rd.readLine();
            String str2 = rd.readLine();
            int int1 = 0;
            int int2 = 0;
            try {
                int1 = Integer.parseInt(str1);
                int2 = Integer.parseInt(str2);
                if (int1 < 0) int1 = int1 * (-1);
                if (int2 < 0) int2 = int2 * (-1);
            } catch (NumberFormatException e) {
                System.out.println("NumberFormatException");
            }
            while (int2 != 0) {
                int tmp = int1 % int2;
                int1 = int2;
                int2 = tmp;
            }
            System.out.println(int1);
        }
    }

