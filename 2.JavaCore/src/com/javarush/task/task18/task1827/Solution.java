package com.javarush.task.task18.task1827;
/*
Прайсы
CrUD для таблицы внутри файла
Считать с консоли имя файла для операций CrUD
Программа запускается со следующим набором параметров:
-c productName price quantity
Значения параметров:
где id - 8 символов
productName - название товара, 30 chars (60 bytes)
price - цена, 8 символов
quantity - количество, 4 символа
-c  - добавляет товар с заданными параметрами в конец файла, генерирует id самостоятельно, инкрементируя максимальный id, найденный в файле
В файле данные хранятся в следующей последовательности (без разделяющих пробелов):
id productName price quantity
Данные дополнены пробелами до их длины
Пример:
19846   Шорты пляжные синие           159.00  12
198478  Шорты пляжные черные с рисунко173.00  17
19847983Куртка для сноубордистов, разм10173.991234
*/
import java.io.*;
import java.util.ArrayList;
import java.util.Locale;
import java.util.TreeSet;

public class Solution {
    // Длины данных в исходном файле
    public static final int ID_LENGTH = 8;
    public static final int PRODUCTNAME_LENGTH = 30;
    public static final int PRICE_LENGTH = 8;
    public static final int QUANTITY_LENGTH = 4;
    // команда
    public static final String CREATE_COMMAND = "-c";
    // Индексы в аргументах
    public static final int COMMAND_INDEX = 0;
    public static final int PRODUCTNAME_INDEX = 1;
    // Смещение индекса от конца массива аргументов
    public static final int PRICE_INDEX_DELTA = 2;
    public static final int QUANTITY_INDEX_DELTA = 1;
    // Записи из файла
    public static ArrayList<String> list = new ArrayList<>();
    // Множиство всех ID
    public static TreeSet<Integer> setID= new TreeSet<>();
    //D:\Develop\JAVA\JavaRushTasks\1827.txt
    //String result = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", idMax, productName, price, quantity);
    public static void main(String[] args) throws Exception {
        if ((args!=null) && (args.length>3)) {
            BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
            String fileName = console.readLine();
            console.close();
            String command = args[COMMAND_INDEX];
            switch (command){
                case CREATE_COMMAND:
                    readFromFileToList(fileName);
                    int newId = findMaxIdAndCreateNew();
                    if (newId >= 99999999)
                        return;
                    //System.out.println(newId);
                    String id          = ""+newId;
                    String productName = "";
                    for (int i = PRODUCTNAME_INDEX; i < args.length - PRICE_INDEX_DELTA; i++) { //лепим имя продукта из параметров
                        //System.out.println(args[i]);
                        productName += args[i] + " ";
                    }
                    productName = productName.trim();
                    // if(productName.length() > 30)
                    //    productName = productName.substring(0,PRODUCTNAME_LENGTH); //обрубаем если больше 30 символов
                    //возможно лишнее
                    // System.out.println(productName.trim().length());
                    //System.out.println(productName);

                    String price = args[args.length - PRICE_INDEX_DELTA]; // -2
                    String quantity = args[args.length - QUANTITY_INDEX_DELTA]; // -1
                    //Пробовал форматировать все
                    //listFormat();
                    String result = String.format(Locale.ROOT,"%-8.8s%-30.30s%-8.8s%-4.4s", id, productName, price, quantity);
                    //for (int i: result.toCharArray()) System.out.println("==="+i/*Integer.toHexString(i)*/ + " " + (char)i);
                    //System.out.println("bytes = " + result.toCharArray().length);
                    //System.out.println("bytes = " +  String.format("%-30.30s",productName).toCharArray().length);
                    list.add(result);
                    writeAllRecordToFile(fileName);
                    break;
            }
        }
    }
    public static int findMaxIdAndCreateNew() throws IOException {
        String sId ="";
        setID.clear();
        // Очень красивое решение, через TreeSet
        for (String s:list) {
            if (s.length()!=0) sId = s.substring(0,ID_LENGTH).trim();
            try {
                setID.add(Integer.parseInt(sId));
            }
            catch (NumberFormatException e){
                setID.add(0);
            }
        }
       if (setID.isEmpty()) setID.add(0);
        // Метод last() возвращает максимальное значение
        return setID.last()+1;
    }
    // Перезаписываем весь файл
    public static void writeAllRecordToFile(String fileName) throws IOException {
        //boolean first = true;
        BufferedWriter file = new BufferedWriter(new FileWriter(fileName));

        for (int i=0; i<list.size(); i++){
            //String lineSeparator = System.getProperty("line.separator");
            file.write(list.get(i));
            if (i!=list.size()-1) file.newLine();
            //System.out.println(line);
        }

        file.close();
    }
    // Логика чтения из файла в массив list
    public static void readFromFileToList(String fileName) throws IOException {
        int count = 0;
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
    // На всякий случай. Приведение в порядок полученных из файла данных
    public static void listFormat(){
        for (int i=0; i<list.size(); i++) {
            String line = list.get(i);
            String id = line.substring(0, ID_LENGTH);
            String productName = line.substring(ID_LENGTH, ID_LENGTH + PRODUCTNAME_LENGTH);
            String price = line.substring(ID_LENGTH + PRODUCTNAME_LENGTH, ID_LENGTH + PRODUCTNAME_LENGTH + PRICE_LENGTH);
            String quantity = line.substring(ID_LENGTH + PRODUCTNAME_LENGTH + PRICE_LENGTH);
            String result = String.format("%-8.8s%-30.30s%-8.8s%-4.4s", id, productName, price, quantity);
            list.set(i, result);
            //System.out.println(result);
        }
    }
}