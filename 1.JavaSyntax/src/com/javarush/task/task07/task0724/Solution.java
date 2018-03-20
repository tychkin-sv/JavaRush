package com.javarush.task.task07.task0724;

/* 
Семейная перепись
*/

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human gMother1 = new Human("gMother1", false, 75);
        Human gMother2 = new Human("gMother2", false, 75);

        Human gFather1 = new Human("gFather1", true, 76);
        Human gFather2 = new Human("gFather2", true, 76);

        Human mother = new Human("mother", false, 42, gFather1, gMother1);
        Human father = new Human("father", false, 42, gFather2, gMother2);


        Human douter = new Human("douter", false, 19, father, mother);
        Human sun1 = new Human("sun1", true, 20, father, mother);
        Human sun2 = new Human("sun2", true, 21, father, mother);


        System.out.println(gMother1);
        System.out.println(gMother2);
        System.out.println(gFather1);
        System.out.println(gFather2);
        System.out.println(mother);
        System.out.println(father);
        System.out.println(douter);
        System.out.println(sun1);
        System.out.println(sun2);


    }

    public static class Human {
        //напишите тут ваш код
        String name;
        boolean sex;
        int age;
        Human father;
        Human mother;

        public Human(String name, boolean sex, int age) {
            this.name = name;
            this.sex = sex;
            this.age = age;
        }

        public Human(String name, boolean sex, int age, Human father, Human mother) {

            this.name = name;
            this.sex = sex;
            this.age = age;
            this.father = father;
            this.mother = mother;
        }

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            if (this.father != null)
                text += ", отец: " + this.father.name;

            if (this.mother != null)
                text += ", мать: " + this.mother.name;

            return text;
        }
    }
}






















