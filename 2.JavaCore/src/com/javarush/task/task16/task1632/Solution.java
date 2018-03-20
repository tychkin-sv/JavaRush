package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);

    static{
        threads.add(new ThreadP1("1"));
        threads.add(new ThreadP2("2"));
        threads.add(new ThreadP3("3"));
        threads.add(new ThreadP4("4"));
        threads.add(new ThreadP5("5"));
    }

    public static void main(String[] args) {
    }

}