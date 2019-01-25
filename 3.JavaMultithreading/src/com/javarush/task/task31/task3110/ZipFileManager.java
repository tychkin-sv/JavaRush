package com.javarush.task.task31.task3110;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipFileManager {

    private Path zipFile;

    public ZipFileManager(Path zipFile) {
        this.zipFile = zipFile;
    }

    public void createZip(Path source) {


        try (ZipOutputStream os = new ZipOutputStream(Files.newOutputStream(zipFile)) ;
             InputStream is = Files.newInputStream(source);)
        {
            String sourceName = source.getFileName().toString();
            String zipEntryName = sourceName.substring(sourceName.lastIndexOf("\\")+1);
            //System.out.println(zipEntryName);
            ZipEntry zipEntry = new ZipEntry(zipEntryName);

            os.putNextEntry(zipEntry);
            while (is.available()>0){
                int byteValue = is.read();
                os.write(byteValue);
            }
            os.closeEntry();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
