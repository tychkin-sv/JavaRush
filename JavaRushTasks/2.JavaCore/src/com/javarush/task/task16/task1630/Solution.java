package com.javarush.task.task16.task1630;

import java.io.*;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;

    //add your code here - добавьте код тут
    //2 пункт
static {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            firstFileName = reader.readLine();
            secondFileName = reader.readLine();
            reader.close();
        } catch (IOException e) {
            //e.printStackTrace();
        }

    }
    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        //add your code here - добавьте код тут
        //4.1 пункт
        f.join(); //  Ждем пока будет готово содержимое файла
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    //add your code here - добавьте код тут
    public static class ReadFileThread extends Thread implements ReadFileInterface{
        //private String fullFileName;
        //private String fileContent;
        private StringBuilder builder = new StringBuilder();
        private BufferedReader reader;
        @Override
        public String getFileContent() {
            try {
                return builder.toString().trim();
            } catch (NullPointerException e) {
                //System.out.println(e);
                return null;
            }
        }

        //3.1 пункт
        @Override
        public void setFileName(String fullFileName) {
            //this.fullFileName = fullFileName;
            try {
                reader = new BufferedReader(new InputStreamReader(new FileInputStream(fullFileName)));
            } catch (FileNotFoundException e) {
               //e.printStackTrace();
            }
        }

        @Override
        public void run() {
            String s;
                try {
                    while ((s = reader.readLine()) != null) {
                        if (s.trim().length() != 0 ) {
                            builder.append(s.trim() + " ");
                        }
                    }
                    reader.close();
                    //fileContent = builder.toString().trim();
                } catch (IOException e) {}

        }
    }
}
