package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
http://info.javarush.ru/JavaRush_tasks_discussion/2016/02/14/level19-lesson10-bonus01-Графическое-пояснение-условия-задачи-.html
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();

        //1916_1.txt
        //1916_2.txt

        FileReader fr1 = new FileReader(file1);
        FileReader fr2 = new FileReader(file2);
        BufferedReader br1 = new BufferedReader(fr1);
        BufferedReader br2 = new BufferedReader(fr2);


        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        while (br1.ready()){
            String sLine = br1.readLine();
            if (!sLine.isEmpty()) list1.add(sLine);
        }

        while (br2.ready()){
            String sLine = br2.readLine();
            if (!sLine.isEmpty()) list2.add(sLine);
        }
        br1.close();
        br2.close();


        //for (String s:list1) System.out.println(s);
        //for (String s:list2) System.out.println(s);

       // Type type;


        //!!!!
        for (int i = 0; i<list1.size(); i++){
            //System.out.println("list1 : " + i);
            //System.out.println("list2.size : " + list2.size());

            // Строка из файла1
            String line1 = list1.get(i);

            int list2size = list2.size();

        if (list2size>0){
        for (int j = 0; j<list2size; j++){
            String line2_1 = list2.get(j);

            if (line1.equals(line2_1)) {
                lines.add(new LineItem( Type.SAME, line1));
                list2.remove(0);
                break;
            }
            else if (list2size>1){
                String line2_2 = list2.get(j + 1);
                if (line1.equals(line2_2)) {
                    lines.add(new LineItem(Type.ADDED, line2_1));
                    i--;
                    list2.remove(0);
                    break;
                }
                else {
                    lines.add(new LineItem( Type.REMOVED, line1));
                    //list2.remove(0);
                    break;
                }
            }
            else {
                lines.add(new LineItem( Type.REMOVED, line1));
                //list2.remove(0);
                break;
            }
        }

        } else {
        lines.add(new LineItem( Type.REMOVED, line1));
        }

        }
        //Если в массиве есть еще элементы
        for (int i = 0; i<list2.size(); i++)
        {
            String line2 = list2.get(i);
            lines.add(new LineItem(Type.ADDED, line2));
        }

        //System.out.println("list2.size : " + list2.size());

        for (LineItem lineItem:lines) System.out.println(lineItem);

    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }

        @Override
        public String toString() {
            return type + " " + line;
        }
    }
}
