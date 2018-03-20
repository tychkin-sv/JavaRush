package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/* 
User, Looser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Person person = null;
        String key = null;

        do//тут цикл по чтению ключей, пункт 1
        {
            key = reader.readLine();
            //создаем объект, пункт 2
            switch (key){
                //«user«, «loser«, «coder«, «proger«.
                case "user": person = new Person.User(); break;
                case "loser": person = new Person.Loser(); break;
                case "coder": person = new Person.Coder(); break;
            case "proger": person = new Person.Proger(); break;
            default: person = null;

        }
            if (person == null) break;
            doWork(person); //вызываем doWork

        } while (true);
    }

    public static void doWork(Person person) {
        // пункт 3
//  3.1. Вызывает метод live() у переданного обекта, если этот объект (person) имеет тип User.
        if (person instanceof Person.User) ((Person.User) person).live();
//  3.2. Вызывает метод doNothing(), если person имеет тип Loser.
        if (person instanceof Person.Loser) ((Person.Loser) person).doNothing();
//  3.3. Вызывает метод coding(), если person имеет тип Coder.
        if (person instanceof Person.Coder) ((Person.Coder) person).coding();
//  3.4. Вызывает метод enjoy(), если person имеет тип Proger.
        if (person instanceof Person.Proger) ((Person.Proger) person).enjoy();
    }
}
