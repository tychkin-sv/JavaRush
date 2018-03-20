package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Locale;

public class Solution {
    // Длины данных в исходном файле
    public static final int ID_LENGTH = 8;
    public static final int PRODUCTNAME_LENGTH = 30;
    public static final int PRICE_LENGTH = 8;
    public static final int QUANTITY_LENGTH = 4;
    // команда
    public static final String CREATE_COMMAND = "-c";
    public static final String UPDATE_COMMAND = "-u";
    public static final String DELETE_COMMAND = "-d";

    // Индексы в аргументах
    public static final int COMMAND_INDEX = 0;
    public static final int ID_INDEX = 1;
    public static final int PRODUCTNAME_INDEX = 2;

    // Смещение индекса от конца массива аргументов
    public static final int PRICE_INDEX_DELTA = 2;
    public static final int QUANTITY_INDEX_DELTA = 1;


    // Записи из файла
    public static ArrayList<String> list = new ArrayList<>();

    //D:\Develop\JAVA\JavaRushTasks\1828.txt
    public static void main(String[] args) throws Exception {

        if ((args != null)) {
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String fileName = console.readLine();
            console.close();

            String command = args[COMMAND_INDEX];


            switch (command) {
                case CREATE_COMMAND:
                    break;
                case UPDATE_COMMAND:
                    readFromFileToList(fileName);
                    updateList(args);
                    writeAllRecordToFile(fileName);
                    break;
                case DELETE_COMMAND:
                    readFromFileToList(fileName);
                    deleteIdFromList(args);
                    writeAllRecordToFile(fileName);
                    break;
            }


        }
    }

    public static void deleteIdFromList(String[] args) {
        String id =args[ID_INDEX];
        //ArrayList index to delete
        int itemToDelete = -1;

        for (int i = 0; i<list.size(); i++) {
            if (list.get(i).substring(0,ID_LENGTH).trim().equals(id)) {
                itemToDelete = i;
            };
        }

        if (itemToDelete!=-1) System.out.println(list.remove(itemToDelete));

    }

    public static void updateList(String[] args) {
        String id          = args[ID_INDEX];

        //ArrayList index to update
        int itemToUpdate = -1;

        for (int i = 0; i<list.size(); i++) {
            if (list.get(i).substring(0,ID_LENGTH).trim().equals(id)) {
                itemToUpdate = i;
            };
        }

        if (itemToUpdate!=-1) {
            String productName = "";
            for (int i = PRODUCTNAME_INDEX; i < args.length - PRICE_INDEX_DELTA; i++) { //лепим имя продукта из параметров
                //System.out.println(args[i]);
                productName += args[i] + " ";
            }
            productName = productName.trim();
            String price = args[args.length - PRICE_INDEX_DELTA]; // -2
            String quantity = args[args.length - QUANTITY_INDEX_DELTA]; // -1

            String result = String.format(Locale.ROOT,"%-8.8s%-30.30s%-8.8s%-4.4s", id, productName, price, quantity);

            System.out.println(list.remove(itemToUpdate));
            list.add(itemToUpdate, result);
        }
    }


    // Перезаписываем весь файл
    public static void writeAllRecordToFile(String fileName) throws IOException {
        //boolean first = true;
        BufferedWriter file = new BufferedWriter(new FileWriter(fileName));

        for (int i = 0; i < list.size(); i++) {
            file.write(list.get(i));
            if (i != list.size() - 1) file.newLine();
        }
        file.close();
    }

    // Логика чтения из файла в массив list
    public static void readFromFileToList(String fileName) throws IOException {
        int count = 0;

        // Важно!!!!
        list.clear();
        FileReader fr = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fr);
        //System.out.println("FR :");
        //System.out.println("data :");
        while (reader.ready()) {
            String s = reader.readLine();
            list.add(s);
            // System.out.println(s);
            count++;
        }
        //System.out.println("Lines : " + count);
        fr.close();
        reader.close();
    }




}