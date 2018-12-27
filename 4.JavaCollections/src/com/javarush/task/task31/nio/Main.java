package com.javarush.task.task31.nio;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

    public static void main(String[] args) throws URISyntaxException, IOException {
        Path testFilePath = Paths.get("d:/javarush/nioTest.txt");
        System.out.println("Files.readAllLines(Path path): " + Files.readAllLines(testFilePath));
        System.out.println("path.getFileName(): " + testFilePath.getFileName());
        System.out.println("path.getFileSystem(): " + testFilePath.getFileSystem());
        System.out.println("path.getRoot(): " + testFilePath.getRoot());
        System.out.println("path.getParent(): " + testFilePath.getParent());
        //Вывод элементов пути
        System.out.println("Printing elements of the path: ");
        for (Path element : testFilePath) {
            System.out.println("\t path element: " + element);
        }

        Path testFile = Paths.get("test.txt");
        System.out.println("The file name is: " + testFile.getFileName());
        System.out.println("It's URI is: " + testFile.toUri());
        System.out.println("It's absolute path is: " + testFile.toAbsolutePath());
        System.out.println("It's normalized path is: " + testFile.normalize());



    }
}
