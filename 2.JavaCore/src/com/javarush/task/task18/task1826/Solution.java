package com.javarush.task.task18.task1826;

/* 
Шифровка
*/

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Arrays;

public class Solution {
    public static final String COMMAND_ENCRYPT = "-e";
    public static final String COMMAND_DECRYPT= "-d";
    public static final int INDEX_COMMAND = 0;
    public static final int INDEX_SOURCE_FILE = 1;
    public static final int INDEX_DESTINATION_FILE = 2;
    private static FileInputStream fis;
    private static FileOutputStream fos;

    public static void main(String[] args) throws IOException {

        if ((args !=null) && (args.length>2)){

            //task1826_1.txt
            String sourceFileName = args[INDEX_SOURCE_FILE];
            //System.out.println(sourceFileName);
            //task1826_2.txt
            String destinationFileName = args[INDEX_DESTINATION_FILE];
            //System.out.println(destinationFileName);

            fis = new FileInputStream(sourceFileName);
            //System.out.println(fis.available());

            //System.out.println(fis);
            fos = new FileOutputStream(destinationFileName);
            String command = args[INDEX_COMMAND];
            //System.out.println(command);

            switch (command){
                case COMMAND_ENCRYPT:  decrypt_encrypt(sourceFileName, destinationFileName); break;
                case COMMAND_DECRYPT:  decrypt_encrypt(sourceFileName, destinationFileName); break;
            }

            fis.close();
            fos.close();
        }
    }

    public static void decrypt_encrypt(String sourceFileName, String destinationFileName) throws IOException {


        //System.out.println("КОДИРУЕМ");
        //System.out.println(fis.available());
        //System.out.println(fis);
        byte[] buffer = new byte[fis.available()];
        int size = fis.read(buffer, 0, buffer.length);
        //System.out.println(size);
        //printArr("перед",buffer);
        coding_decoding(buffer);
        //printArr("после",buffer);
        fos.write(buffer, 0, buffer.length);

    }

    private static void coding_decoding(byte[] arr){
        int size = arr.length;
        for (int i=0; i<size/2;i++){
            byte tmp = arr[i];
            arr[i] = arr[size - 1 - i];
            arr[size - 1 - i] = tmp;
        }
    }
    private static void printArr(String msg, byte[] arr){
       // int size = arr.length;
        System.out.println(msg + " : " +Arrays.toString(arr));
    }


}
