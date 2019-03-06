package com.javarush.task.task30.task3013;

/* 
Набираем код
*/

public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int number = 3456;//;/Integer.MAX_VALUE - 133;

        System.out.println(Integer.toString(number, 10));

        String result = Integer.toString(solution.resetLowerBits(number), 10);
        System.out.println(result);
    }

    public int resetLowerBits(int number) {
        //напишите тут ваш код
        number &= ~(number >> 1);
        number &= ~(number >> 2);
        number &= ~(number >> 4);
        number &= ~(number >> 8);
        number &= ~(number >> 16);

        return number;
    }
}