package com.javarush.task.task08.task0824;

/* 
Собираем семейство
*/

import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) {
        //напишите тут ваш код
        Human douter = new Human();
        douter.name = "douter";
        douter.sex =false;
        douter.age = 19;

        Human sun1 = new Human();
        sun1.name = "sun1";
        sun1.sex =true;
        sun1.age = 20;


        Human sun2 = new Human();
        sun2.name = "sun2";
        sun2.sex =true;
        sun2.age = 21;

        Human mother = new Human();
        mother.name = "mother";
        mother.sex =false;
        mother.age = 42;
        mother.children.add(douter);
        mother.children.add(sun1);
        mother.children.add(sun2);

        Human father = new Human();
        father.name = "father";
        father.sex =true;
        father.age = 42;
        father.children.add(douter);
        father.children.add(sun1);
        father.children.add(sun2);


        Human gMother1 = new Human();
        gMother1.name = "gMother1";
        gMother1.sex =false;
        gMother1.age = 75;
        gMother1.children.add(mother);

        Human gMother2 = new Human();
        gMother2.name = "gMother2";
        gMother2.sex =false;
        gMother2.age = 75;
        gMother2.children.add(father);

        Human gFather1 = new Human();
        gFather1.name = "gFather1";
        gFather1.sex =true;
        gFather1.age = 75;
        gFather1.children.add(mother);

        Human gFather2 = new Human();
        gFather2.name = "gFather2";
        gFather2.sex =true;
        gFather2.age = 75;
        gFather2.children.add(father);





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
        public String name;
        public int age;
        public boolean sex;
        public ArrayList<Human> children = new ArrayList<>();

        public String toString() {
            String text = "";
            text += "Имя: " + this.name;
            text += ", пол: " + (this.sex ? "мужской" : "женский");
            text += ", возраст: " + this.age;

            int childCount = this.children.size();
            if (childCount > 0) {
                text += ", дети: " + this.children.get(0).name;

                for (int i = 1; i < childCount; i++) {
                    Human child = this.children.get(i);
                    text += ", " + child.name;
                }
            }
            return text;
        }
    }

}
