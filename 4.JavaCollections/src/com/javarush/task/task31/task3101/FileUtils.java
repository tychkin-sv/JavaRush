package com.javarush.task.task31.task3101;

import java.io.File;
import java.io.IOException;

public class FileUtils {

    public static void deleteFile(File file) {
        if (!file.delete()) System.out.println("Can not delete file with name " + file.getName());
    }

    public static void renameFile(File source, File destination) throws IOException {
        if (isExist(source)) if (!source.renameTo(destination)) System.out.println("Can not rename file with name " + source.getName());
        else destination.createNewFile();
    }

    public static boolean isExist(File file) {
        return file.exists();
    }
}
