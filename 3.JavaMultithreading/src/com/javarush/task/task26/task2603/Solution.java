package com.javarush.task.task26.task2603;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
Убежденному убеждать других не трудно
*/
public class Solution {

    public static void main(String[] args) {

    }

    public static class CustomizedComparator<T> implements Comparator<T>{
       private Comparator<T>[] comparators;

        public CustomizedComparator(Comparator<T>...vararg) {
          comparators = vararg;
        }

        @Override
        public int compare(T o1, T o2) {
           int comp = 0;
            for (Comparator<T> comparator:comparators) {
                comp = comparator.compare(o1, o2);
                if (comp!=0) break;
            };
            return comp;
        }
    }
}
