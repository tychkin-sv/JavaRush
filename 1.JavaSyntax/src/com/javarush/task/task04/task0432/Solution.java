package com.javarush.task.task04.task0432;



/* 
Хорошего много не бывает
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String s = bufferedReader.readLine();
        int num = Integer.parseInt(bufferedReader.readLine());
        int i = 1;
        while (i<=num){
            System.out.println(s);
            i++;
        }

    }
}
