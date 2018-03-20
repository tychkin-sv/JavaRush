package com.javarush.task.task24.task2410;

import java.util.LinkedList;
import java.util.List;

/* 
Рефакторинг, анонимные классы
*/
public class SolutionOr {
    public static List<Iterator> iterators = new LinkedList<>();

    private int countItems;

    public Iterator getIterator(final String name) {
        class LocalIterator implements Iterator {
            public LocalIterator() {
                countItems++;
                System.out.println(name + " item " + countItems);
            }

            public Iterator next() {
                return new LocalIterator();
            }
        }
        return new LocalIterator();
    }

    public static void main(String[] args) {
        SolutionOr solutionOr = new SolutionOr();

        Iterator iterator = solutionOr.getIterator("iterator");
        for (int i = 1; i < 5; i++) {
            iterators.add(iterator.next());
        }
    }
}
