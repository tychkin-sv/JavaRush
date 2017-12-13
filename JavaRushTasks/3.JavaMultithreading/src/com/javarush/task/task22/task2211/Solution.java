package com.javarush.task.task22.task2211;

import java.io.*;
import java.nio.charset.Charset;

/* 
Смена кодировки
*/
public class Solution {
    static String win1251TestString = "РќР°СЂСѓС€РµРЅРёРµ РєРѕРґРёСЂРѕРІРєРё РєРѕРЅСЃРѕР»Рё?"; //only for your testing

    public static void main(String[] args) throws IOException {
        Charset utf8 = Charset.forName("UTF-8");
        Charset windows1251 = Charset.forName("Windows-1251");

        //System.out.println(new String(win1251TestString.getBytes(windows1251), utf8));

        String file1251 = args[0];
        String fileUTF8 = args[1];
        FileInputStream inputStream = new FileInputStream(file1251);
        FileOutputStream outputStream = new FileOutputStream(fileUTF8);

        while (inputStream.available()>0) {
            byte[] buffer = new byte[inputStream.available()];
            inputStream.read(buffer);

            outputStream.write(new String(buffer, utf8).getBytes(windows1251));
        }
        inputStream.close();
        outputStream.close();
    }

}
