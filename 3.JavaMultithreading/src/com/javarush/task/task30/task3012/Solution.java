package com.javarush.task.task30.task3012;

/* 
Получи заданное число
*/

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.createExpression(74);
        solution.createExpression(1234);
        solution.createExpression(19);
        solution.createExpression(463);
    }

    public void createExpression(int number) {
        //напишите тут ваш код
        //1, 3, 9, 27, 81, 243, 729, 2187
        int x = number;
        List<Integer> temp = new ArrayList<>();

        while (x>2) {
            if (x%3==2) {
                x = (x / 3) + 1;
                temp.add(-1);

            }
            else {
                temp.add(x % 3);
                x /= 3;
            }

        }
        if (x == 2) {
            temp.add(-1);
            temp.add(+1);
        } else {
            temp.add(x);
        }

        //for (Integer i: temp) System.out.print(i + "  ");
        //System.out.println();
        Collections.reverse(temp);
        //for (Integer i: temp) System.out.print(i + "  ");
        //System.out.println();

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < temp.size(); i++) {
            int n = (int) Math.pow(3, temp.size() - (i + 1)) * temp.get(i);
            if (n != 0) {
                result.add(n);
            }
        }

        //for (Integer i: result) System.out.print(i + "  ");
        //System.out.println();
        Collections.reverse(result);
        //for (Integer i: result) System.out.print(i + "  ");
        //System.out.println();

        StringBuilder sb = new StringBuilder();
        for (Integer i : result) {
            if (i >= 0) {
                sb.append(" + ").append(i);
            } else {
                sb.append(" - ").append(Math.abs(i));
            }
        }
        System.out.println(String.format("%d = %s", number, sb.toString().trim()));

    }
}