package com.javarush.task.task22.task2210;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/*
StringTokenizer
*/
public class Solution {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getTokens("level22.lesson13.task01", ".")));

    }
    public static String [] getTokens(String query, String delimiter) {
        ArrayList<String> arrayList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(query, delimiter);
while (st.hasMoreElements()) {
    arrayList.add(st.nextToken());
}
        return arrayList.toArray(new String[arrayList.size()]);
    }
}
