package com.javarush.task.task07.task0716;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

/* 
Р или Л
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bis = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> list = new ArrayList<String>();
        list.add("роза"); //0
        list.add("лира"); //1
        list.add("лоза"); //2
        list = fix(list);

        for (String s : list) {
            System.out.println(s);
        }
    }

    public static ArrayList<String> fix(ArrayList<String> list) {
        //напишите тут ваш код
        ArrayList<String> result = new ArrayList<>();
        boolean presetR = false;
        boolean presetL = false;

        for (String s : list) {
            presetR = s.toLowerCase().indexOf('р') != -1;
            presetL = s.toLowerCase().indexOf('л') != -1;
            if (presetL || presetR) {
                if (presetL &&  presetR) {result.add(s);}
                if (presetL && !presetR) Collections.addAll(result, s, s);
            }
            else result.add(s);

        }
        return result;
    }
}