package com.javarush.task.task31.task3112;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

/* 
Загрузчик файлов
Реализуй метод downloadFile(String urlString, Path downloadDirectory), на вход которого подается ссылка для скачивания файла и папка, куда нужно закачать файл.
Все ссылки имеют вид:
https://yastatic.net/morda-logo/i/citylogos/yandex19-logo-ru.png
http://toogle.com/files/rules.txt
https://pacemook.com/photos/image1.jpg

Метод должен создать объект URL и загрузить содержимое файла на локальный диск.
Выкачивай сначала во временную директорию, чтобы в случае неуспешной загрузки в твоей директории не оставались недокачанные файлы.
Затем перемести файл в пользовательскую директорию. Имя для файла возьми из ссылки.
Используй только классы и методы из пакета java.nio.
*/
public class Solution {

    public static void main(String[] args) throws IOException {
        Path passwords = downloadFile("https://javarush.ru/testdata/secretPasswords.txt", Paths.get("D:/MyDownloads"));

        for (String line : Files.readAllLines(passwords)) {
            System.out.println(line);
        }
    }

    public static Path downloadFile(String urlString, Path downloadDirectory) throws IOException {
        // implement this method
        String[] list = urlString.split("/");
        String fileName = list[list.length-1];
        //System.out.println(fileName);

        URL url = new URL(urlString);
        InputStream is = url.openStream();
        Path tempFile = Files.createTempFile("temp-",".tmp");
        Files.copy(is, tempFile, REPLACE_EXISTING);

        Path downloadFile = Paths.get(downloadDirectory.toString(), fileName);

        Files.move( tempFile, downloadFile);
        //is.close();
        return downloadFile;
    }

}
