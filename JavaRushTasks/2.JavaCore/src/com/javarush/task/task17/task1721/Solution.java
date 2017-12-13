package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String fileNameAllLines = reader.readLine();
        String fileNameForRemoveLines = reader.readLine();

        FileReader fileReaderAllLines = new FileReader(new File(fileNameAllLines));
        FileReader fileReaderForRemoveLines = new FileReader(new File(fileNameForRemoveLines));
        BufferedReader readerAllLines = new BufferedReader(fileReaderAllLines);
        BufferedReader readerForRemoveLines = new BufferedReader(fileReaderForRemoveLines);

        String line;
        while ((line=readerAllLines.readLine())!=null){
            allLines.add(line);
        }
        while ((line=readerForRemoveLines.readLine())!=null){
            forRemoveLines.add(line);
        }

        reader.close();
        readerAllLines.close();
        readerForRemoveLines.close();

        new Solution().joinData();
        //System.out.println("все");
        //for (String s:allLines) System.out.println(s);
    }

    public void joinData () throws CorruptedDataException {


       //  boolean result = allLines.removeAll(forRemoveLines);
       // if (!result) throw new CorruptedDataException();
        if (allLines.containsAll(forRemoveLines)){
            allLines.removeAll(forRemoveLines);
           // System.out.println("удалили");
        }
        else {
           allLines.clear();
           throw new CorruptedDataException();
        }

        //System.out.println(result);
    }
}
