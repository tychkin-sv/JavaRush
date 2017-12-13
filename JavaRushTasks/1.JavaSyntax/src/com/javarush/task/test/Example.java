package com.javarush.task.test;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by TSV on 24.08.2017.
 */
public class Example {
    public static HashSet newSet = new HashSet();

    public static void main(String[] args) throws IOException {
        HashSet<Integer> set = new HashSet();

        set.add(1);
        set.add(2);

        example1(set);
        example2(set);
    }

    public static void example1(Set<Integer> set) throws IOException {
        //newSet = (HashSet) set.clone();
        HashSet iCanClone= (HashSet) set;
        newSet = (HashSet) iCanClone.clone();
    }

    public static void example2(HashSet<Integer> set) throws IOException {
        newSet = (HashSet) set.clone();
    }
}
