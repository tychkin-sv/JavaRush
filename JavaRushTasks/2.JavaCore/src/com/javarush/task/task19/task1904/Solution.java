package com.javarush.task.task19.task1904;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException {
Scanner scanner = new Scanner(new FileInputStream("1904.txt"));
PersonScannerAdapter adapter =  new PersonScannerAdapter(scanner);
        System.out.println(adapter.read().toString());
        System.out.println(adapter.read().toString());
    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {

            String[] s = fileScanner.nextLine().split(" ");
            System.out.println(Arrays.toString(s));
            Date date = new GregorianCalendar(Integer.parseInt(s[5]), Integer.parseInt(s[4]) - 1, Integer.parseInt(s[3])).getTime();
            Person person = new Person(s[1], s[2], s[0], date);
            return person;
        }

        @Override
        public void close() throws IOException {
            fileScanner.close();

        }
    }
}
