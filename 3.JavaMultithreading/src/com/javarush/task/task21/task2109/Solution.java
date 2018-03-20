package com.javarush.task.task21.task2109;

/* 
Запретить клонирование
*/
public class Solution {
    public static class A implements Cloneable {
        @Override
        protected A clone() throws CloneNotSupportedException {
            int i = getI();
            int j = getJ();
            return new A(i,j);
        }

        private int i;
        private int j;

        public A(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }

    public static class B extends A {
        @Override
        protected B clone() throws CloneNotSupportedException {
            throw new CloneNotSupportedException();
        }

        private String name;

        public B(int i, int j, String name) {
            super(i, j);
            this.name = name;
        }

        public String getName() {
            return name;
        }

    }

    public static class C extends B implements Cloneable {
        @Override
        protected C clone() throws CloneNotSupportedException {
            int i = getI();
            int j = getJ();
            String name = getName();

            return new C(i, j, name);
        }

        public C(int i, int j, String name) {
            super(i, j, name);
        }
    }

    public static void main(String[] args) {

    }
}
