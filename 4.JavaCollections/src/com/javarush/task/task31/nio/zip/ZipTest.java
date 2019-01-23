package com.javarush.task.task31.nio.zip;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipTest {
    public static void main(String[] args) throws IOException {
        // создаем архив
        FileOutputStream zipFile = new FileOutputStream("d:/JavaRush/ziptest/archive.zip");
        ZipOutputStream zip = new ZipOutputStream(zipFile);

        //кладем в него ZipEntry – «архивный объект»
        zip.putNextEntry(new ZipEntry("document.txt"));

        //копируем файл «document-for-archive.txt» в архив под именем «document.txt»
        File file = new File("d:/JavaRush/ziptest/document-for-archive.txt");
        Files.copy(file.toPath(), zip);

        // закрываем архив
        zip.close();
    }
}
