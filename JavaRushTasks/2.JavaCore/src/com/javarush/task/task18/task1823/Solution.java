package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Thread> list = new ArrayList<>();
        while(true){
            String fileName = reader.readLine();
            if (fileName.equals("exit")) break;
            Thread thread = new ReadThread(fileName);
            list.add(thread);
            thread.start();

        }

       // Thread.sleep(2000);
       // for (Map.Entry<String, Integer> pair: resultMap.entrySet()) System.out.println(pair.getKey() + " " + pair.getValue());

    }

    public static class ReadThread extends Thread {
        String fileName;
        FileInputStream fis;
        Map<Integer, Integer> map = new HashMap<>();

        public ReadThread(String fileName) throws FileNotFoundException {
            //implement constructor body
            super(fileName);
            this.fileName = fileName;
            fis = new FileInputStream(fileName);
        }

        // implement file reading here - реализуйте чтение из файла тут
        @Override
        public void run() {
            try {
                while (fis.available()>0){
                int symbol = fis.read();
                if (!map.containsKey(symbol)) map.put(symbol, 1);
                else {
                    int count = map.get(symbol);
                    map.put(symbol, count + 1);
                }

                }
            } catch (IOException e) {
               // e.printStackTrace();
            }
            if (map.size()>0) {
                int maxSymbol = 0;
                int maxCount = 0;

                for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                    if (maxCount<pair.getValue()) {
                        maxCount = pair.getValue();
                        maxSymbol = pair.getKey();
                    }
                }
                synchronized (resultMap){
                    resultMap.put(fileName, maxSymbol);
                    //System.out.println(maxSymbol);
                }

            }
            try {
                fis.close();
            } catch (IOException e) {
                // e.printStackTrace();
            }
        }
    }
}
