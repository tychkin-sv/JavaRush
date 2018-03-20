package com.javarush.task.task19.task1917;

/* 
Свой FileWriter
Сложность высокая !!!
*/

import java.io.*;

public class FileConsoleWriter{

    private FileWriter fileWriter;

    public FileConsoleWriter(String fileName) throws IOException {
       this.fileWriter = new FileWriter(fileName);
    }

    public FileConsoleWriter(String fileName, boolean append) throws IOException {
        this.fileWriter = new FileWriter(fileName, append);
    }

    public FileConsoleWriter(File file) throws IOException {
        this.fileWriter = new FileWriter(file);
    }

    public FileConsoleWriter(File file, boolean append) throws IOException {
        this.fileWriter = new FileWriter(file, append);
    }

    public FileConsoleWriter(FileDescriptor fd) {
        this.fileWriter = new FileWriter(fd);
    }



    public void write(int c) throws IOException {
        this.fileWriter.write(c);
        System.out.println(c);
    }


    public void write(char[] cbuf, int off, int len) throws IOException {
        this.fileWriter.write(cbuf, off, len);
        System.out.println(new String(cbuf, off, len));
    }


    public void write(String str, int off, int len) throws IOException {
        this.fileWriter.write(str, off, len);
        System.out.println(str.substring(off, off + len));
    }


    public void write(char[] cbuf) throws IOException {
        this.fileWriter.write(cbuf);
        System.out.println(cbuf);
    }


    public void write(String str) throws IOException {
        this.fileWriter.write(str);
        System.out.println(str);
    }

    public void flush() throws IOException {
        this.fileWriter.flush();
    }

    public void close() throws IOException {
        this.fileWriter.close();
    }

    public static void main(String[] args) {

    }


}
