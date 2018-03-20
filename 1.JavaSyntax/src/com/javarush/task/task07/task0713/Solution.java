package com.javarush.task.task07.task0713;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Играем в Jолушку
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        //напишите тут ваш код
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> listDiv3 = new ArrayList<>();
        ArrayList<Integer> listDiv2 = new ArrayList<>();
        ArrayList<Integer> listDiv = new ArrayList<>();


        for (int i = 0; i<20; i++) {
            String s = bufferedReader.readLine();
            list.add(Integer.parseInt(s));
        }

        for (int i = 0; i<20; i++) {
            Integer val = list.get(i);
            boolean div2 = val%2 == 0;
            boolean div3 = val%3 == 0;
            if (div3 || div2) {
                if (div3) listDiv3.add(val);
                if (div2) listDiv2.add(val);
            }
            else listDiv.add(val);

        }

        printList(listDiv3);
        printList(listDiv2);
        printList(listDiv);
    }

    public static void printList(List<Integer> list) {
        //напишите тут ваш код
        for (Integer i: list) System.out.println(i);
    }
}
