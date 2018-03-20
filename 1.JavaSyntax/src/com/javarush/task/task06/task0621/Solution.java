package com.javarush.task.task06.task0621;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Родственные связи кошек
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String grandFatherName = reader.readLine();
        Cat catGrandFather = new Cat(grandFatherName);

        String grandMotherName = reader.readLine();
        Cat catGrandMother = new Cat(grandMotherName);

        String fatherName = reader.readLine();
        Cat catFather = new Cat(fatherName, null, catGrandFather);

        String motherName = reader.readLine();
        Cat catMother = new Cat(motherName, catGrandMother, null);

        String sonName = reader.readLine();
        Cat catSon = new Cat(sonName, catMother, catFather);

        String daughterName = reader.readLine();
        Cat catDaughter = new Cat(daughterName, catMother, catFather);

        System.out.println(catGrandFather);
        System.out.println(catGrandMother);
        System.out.println(catFather);
        System.out.println(catMother);
        System.out.println(catSon);
        System.out.println(catDaughter);
        /*
        Cat name is дедушка Вася, no mother, no father
        Cat name is бабушка Мурка, no mother, no father
        Cat name is папа Котофей, no mother, father is дедушка Вася
        Cat name is мама Василиса, mother is бабушка Мурка, no father
        Cat name is сын Мурчик, mother is мама Василиса, father is папа Котофей
        Cat name is дочь Пушинка, mother is мама Василиса, father is папа Котофей
        */
    }

    public static class Cat {
        private String name;
        private Cat parentMother;
        private Cat parentFather;

        Cat(String name) {
            this.name = name;
        }

        public Cat(String name, Cat parentMother, Cat parentFather) {
            this.name = name;
            this.parentMother = parentMother;
            this.parentFather = parentFather;
        }

        @Override
        public String toString() {
            String sMother;
            String sFather;
            if (parentMother == null)
                sMother = "no mother";
            else
                sMother = "mother is " + parentMother.name;

            if (parentFather == null)
                sFather = "no father";
            else
                sFather = "father is " + parentFather.name;

            return "Cat name is " + name + ", " + sMother+ ", " +sFather;
        }
    }

}
