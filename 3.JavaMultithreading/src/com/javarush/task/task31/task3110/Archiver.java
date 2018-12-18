package com.javarush.task.task31.task3110;

import com.sun.nio.zipfs.ZipPath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Archiver {




    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Введите полный путь архива :");
        String uriZip = bufferedReader.readLine();
        //System.out.println(fileName);
        Path zipFile = Paths.get(uriZip);
        ZipFileManager zipFileManager = new ZipFileManager(zipFile);
        System.out.print("Введите полный путь файла :");
        String sourceURI = bufferedReader.readLine();
        Path sourceFile = Paths.get(sourceURI);
        zipFileManager.createZip(sourceFile);

    }
}
