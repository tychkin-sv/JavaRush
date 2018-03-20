package com.javarush.task.task31.task3101;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

/*
Проход по дереву файлов
*/
public class Solution {
    public static ArrayList<File> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        if (args.length>1) {
            File path = new File(args[0]);
            File resultFileAbsolutePath = new File(args[1]);

            File allFilesContent = new File(resultFileAbsolutePath.getParent() + "\\allFilesContent.txt");
            FileUtils.renameFile(resultFileAbsolutePath, allFilesContent);

            try (FileOutputStream outputStream = new FileOutputStream(allFilesContent)) {

                fillFileList(path.getPath());
                list.sort(new FileNameComparator());

                for (File file : list) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    while (fileInputStream.available() > 0) {
                       outputStream.write(fileInputStream.read());
                    }
                    outputStream.write(System.lineSeparator().getBytes());
                    outputStream.flush();

                    fileInputStream.close();
                }
            }

        }

    }

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }

    //Рекурсивно пробегаем поддиректории и заполняем список файлов
    private static void fillFileList(String path) {
        File[] files = new File(path).listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                fillFileList(file.getAbsolutePath());
                continue;
            }
            if (file.length() > 50)
                FileUtils.deleteFile(file);
            else
                list.add(file);
        }
    }
    //Компаратор для сравнения
    static class FileNameComparator implements Comparator<File> {
        public int compare(File first, File second) {
            return first.getName().compareTo(second.getName());
        }
    }


}
