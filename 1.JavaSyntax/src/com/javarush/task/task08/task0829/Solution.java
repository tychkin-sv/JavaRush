package com.javarush.task.task08.task0829;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Модернизация ПО
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        //list of addresses
        List<String> addresses = new ArrayList<String>();
        List<String> families = new ArrayList<String>();
        String sFamily;
        String sAddress;

        int i = 0;
        while (true) {
            i = i+1;

            String inputString = reader.readLine();

            if (inputString.isEmpty()) break;

            if (i%2 == 0) {

                families.add(inputString);
            }
            else {

                addresses.add(inputString);
            }

        }
        //for (String s: families) System.out.println(s);
        //for (String s: addresses) System.out.println(s);

        //read home number
        String cityAddress = reader.readLine();
        int n = addresses.size();
        for (int index = 0; index <  n ; index++)
        {
            if (addresses.get(index).equals(cityAddress)) System.out.println(families.get(index));
        }
    }
}
