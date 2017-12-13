package com.javarush.task.task10.task1013;

/* 
Конструкторы класса Human
*/

public class Solution {
    public static void main(String[] args) {
    }

    public static class Human {
        // напишите тут ваши переменные и конструкторы
        private String lastName;
        private String firstName;
        private int age;
        private boolean sex;
        private int height;
        private int weight;

        public Human(String lastName, String firstName, int age, boolean sex, int height, int weight) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.age = age;
            this.sex = sex;
            this.height = height;
            this.weight = weight;
        }

        public Human(String lastName, String firstName, int age, boolean sex) {
            this(lastName, firstName, age, sex, 0, 0);
        }

        public Human(String lastName, String firstName, int age) {
            this(lastName, firstName, age, true, 170, 75);
        }

        public Human(String lastName, String firstName, boolean sex) {
            this(lastName, firstName, 0, sex, 170, 75);
        }

        public Human(String lastName, String firstName, int height, int weight) {
            this(lastName, firstName,0, false, height, weight);
        }

        public Human(String lastName, String firstName) {
            this(lastName, firstName,0, false, 0, 0);
        }

        public Human(int height, int weight) {
            this("", "", 0,false, height, weight);
        }

        public Human(boolean sex) {
            this("", "", 0, sex, 0, 0);
        }

        public Human(int age) {
            this("", "", age, false, 0, 0);
        }

        public Human() {
            this("", "", 0,false, 0, 0);
        }

    }
}
