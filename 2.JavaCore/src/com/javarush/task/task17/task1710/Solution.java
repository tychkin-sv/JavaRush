package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    final static int COMMAND_INDEX = 0;
    final static int ID_INDEX = 1;
    final static int NAME_INDEX = 1;
    final static int SEX_INDEX = 2;
    final static int BIRTHDAY_INDEX = 3;

    final static String CREATE_COMMAND = "-c";
    final static String UPDATE_COMMAND = "-u";
    final static String DELETE_COMMAND = "-d";
    final static String INFO_COMMAND = "-i";

    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {
        //start here - начни тут
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String line = reader.readLine();
        //String[] arr = line.split(" ");

         String[] arr = args;

        switch (arr[COMMAND_INDEX]) {
            case CREATE_COMMAND : create(arr); break;
            case UPDATE_COMMAND : update(arr); break;
            case DELETE_COMMAND : delete(arr); break;
            case INFO_COMMAND : info(arr); break;
        }

       // for (Person p : allPeople)  System.out.println(p);
    }

    // пункт 3.
    public static void create(String[] arr) throws ParseException {
        Person person;
        Date birthDate = sdf.parse(arr[BIRTHDAY_INDEX]);
        if (arr[SEX_INDEX].equals("м")) person = Person.createMale(arr[NAME_INDEX], birthDate);
        else person = Person.createFemale(arr[NAME_INDEX], birthDate);


        // Последний индекс для отображения
        int lastIndex = allPeople.size();
        allPeople.add(person);
        System.out.println(lastIndex);
    }

    // пункт 4.
    public static void update(String[] arr) throws ParseException {
        int index = Integer.parseInt(arr[ID_INDEX]);
        Person person = allPeople.get(index);

        // индексы сдвигаются т.к. update
        Date birthDate = sdf.parse(arr[BIRTHDAY_INDEX+1]);
        Sex sex = (arr[SEX_INDEX+1].equals("м"))? Sex.MALE: Sex.FEMALE;

        person.setBirthDay(birthDate);
        person.setName(arr[NAME_INDEX+1]);
        person.setSex(sex);



    }
    // пункт 5.
    public static void delete(String[] arr){
        int index = Integer.parseInt(arr[ID_INDEX]);
        allPeople.get(index).setName(null);
        allPeople.get(index).setBirthDay(null);
        allPeople.get(index).setSex(null);
    }

    // пункт 6.
    public static void info(String[] arr){
        int index = Integer.parseInt(arr[ID_INDEX]);
        Person person = allPeople.get(index);
        //Миронов м 15-Apr-1990
        Sex sex = person.getSex();
        String sSex=(sex == Sex.MALE)? "м": "ж";

        Date birthDate = person.getBirthDay();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        String sBirthDate = sdf.format(birthDate);
        //System.out.println(sBirthDate);
        String outStr = person.getName() + " " + sSex + " " + sBirthDate;
        System.out.println(outStr);


    }
}
