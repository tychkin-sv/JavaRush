package com.javarush.task.task17.task1711;

import com.javarush.task.task17.task1710.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    final static int COMMAND_INDEX = 0;
    final static int ID_INDEX = 1;
    final static int NAME_INDEX = 1;
    final static int SEX_INDEX = 2;
    final static int BIRTHDAY_INDEX = 3;
    final static int FIELD_COUNT = 3;


    final static String CREATE_COMMAND = "-c";
    final static String UPDATE_COMMAND = "-u";
    final static String DELETE_COMMAND = "-d";
    final static String INFO_COMMAND = "-i";

    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy");

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        //start here - начни тут
        //BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //String line = reader.readLine();
        //String[] arr = line.split(" ");

        //String[] arr = args;
        //System.out.println("main: " + Arrays.toString(args));
        switch (args[0]) {
            case CREATE_COMMAND : synchronized (allPeople) {create(args);} break;
            case UPDATE_COMMAND : synchronized (allPeople) {update(args);} break;
            case DELETE_COMMAND : synchronized (allPeople) {delete(args);} break;
            case INFO_COMMAND : synchronized (allPeople) {info(args);} break;
        }

        // for (Person p : allPeople)  System.out.println(p);
    }
    // пункт 3.
    public static void create(String[] arr) throws ParseException {
        // test -c Миронов м 15/04/1990 Миронова ж 15/04/1990
        //System.out.println("create = " + arr);
        for (int position = 0; position< arr.length/FIELD_COUNT; position++ )
        {
            Person person;
            Date birthDate = sdf.parse(arr[BIRTHDAY_INDEX + FIELD_COUNT*position]);
            if (arr[SEX_INDEX+ FIELD_COUNT*position].equals("м")) person = Person.createMale(arr[NAME_INDEX+ FIELD_COUNT*position], birthDate);
            else person = Person.createFemale(arr[NAME_INDEX+ FIELD_COUNT*position], birthDate);

            // Последний индекс для отображения
            int lastIndex = allPeople.size();
            allPeople.add(person);
            System.out.println(lastIndex);
            //System.out.println(person);
        }

        //System.out.println("create: " + allPeople);
    }

    // пункт 4.
    public static void update(String[] arr) throws ParseException {
        // test -u 0 Миронов м 15/04/1990 1 Миронова ж 15/04/1990
        //System.out.println("update = " + Arrays.toString(arr));
        for (int position =0; position< arr.length/(FIELD_COUNT +1); position++ ) {
            int id_index = ID_INDEX + (FIELD_COUNT+1)*position;
            int birthday_index = BIRTHDAY_INDEX + 1 + (FIELD_COUNT+1)*position;
            int sex_index = SEX_INDEX + 1 + (FIELD_COUNT+1)*position;
            int name_index =NAME_INDEX + 1 + (FIELD_COUNT+1)*position;

            //System.out.println(id_index + " " +arr[id_index]);
            //System.out.println(name_index);
            //System.out.println(sex_index);
            //System.out.println(birthday_index);


            int index = Integer.parseInt(arr[id_index]);
            Person person = allPeople.get(index);

            // индексы сдвигаются т.к. update
            Date birthDate = sdf.parse(arr[birthday_index]);
            Sex sex = (arr[sex_index].equals("м")) ? Sex.MALE : Sex.FEMALE;

            person.setBirthDay(birthDate);
            person.setName(arr[name_index]);
            person.setSex(sex);

        }
        //System.out.println("update: " + allPeople);
    }
    // пункт 5.
    public static void delete(String[] arr){
        //test
        //-d 0 1

        for (int position = 1; position< arr.length; position++ ) {
            int index = Integer.parseInt(arr[ID_INDEX*position]);
            allPeople.get(index).setName(null);
            allPeople.get(index).setBirthDay(null);
            allPeople.get(index).setSex(null);
        }
       // System.out.println("delete: " + allPeople);
    }

    // пункт 6.
    public static void info(String[] arr){
        //test
        //-i 0 1
        for (int position = 1; position< arr.length; position++ ) {
            int index = Integer.parseInt(arr[ID_INDEX*position]);
            Person person = allPeople.get(index);
            //Миронов м 15-Apr-1990
            Sex sex = person.getSex();
            String sSex = (sex == Sex.MALE) ? "м" : "ж";

            Date birthDate = person.getBirthDay();
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
            String sBirthDate = sdf.format(birthDate);
            //System.out.println(sBirthDate);
            String outStr = person.getName() + " " + sSex + " " + sBirthDate;
            System.out.println(outStr);
        }

    }
}
