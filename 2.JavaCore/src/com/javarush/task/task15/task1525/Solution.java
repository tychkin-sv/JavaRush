package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Файл в статическом блоке
*/

public class Solution {
    public static List<String> lines = new ArrayList<String>();

    static {
        try {
            File file = new File(Statics.FILE_NAME);
            System.out.println(file.getAbsolutePath());
            FileReader fr = new FileReader(file);
            BufferedReader reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line!=null){
                lines.add(line);
                line = reader.readLine();
            }


            fr.close();

        } catch (FileNotFoundException e) {
            //
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        System.out.println(lines);
    }
}
