package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
Сложность высокая !!!

Пример файла
Info about Leela <span xml:lang=»en» lang=»en»><b><span>Turanga Leela
</span></b></span><span>Super</span><span>girl</span>

Пример вывода
<span xml:lang="en" lang="en"><b><span>Turanga Leela</span></b></span>
<span>Turanga Leela</span>
<span>Super</span>
<span>girl</span>
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static String TAG = "";
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        //1918.html
        String fileName = reader.readLine();
        reader.close();

        if (args==null) return;
        TAG = args[0];

        BufferedReader bfr = new BufferedReader(new FileReader(fileName));

        StringBuilder content = new StringBuilder();
            while (bfr.ready())
                content.append(bfr.readLine());
            bfr.close();
        //System.out.println(content);
        StringBuilder text = new StringBuilder(content.toString().replaceAll("\r\n", ""));

        String tmp = text.toString();
        //System.out.println(tmp);

        String tagOpen = "<"+TAG;
        String tagClose = "</"+TAG +">";

        int positionOpen = -1;
        int positionClose = -1;
        int shift = 0;

        Stack<Integer> openedTags = new Stack<>();
        //Queue<Integer> closedTags = new PriorityQueue<>();
        Map<Integer, Integer> tags = new TreeMap<>();


        while (true) {
            positionOpen = text.indexOf(tagOpen, shift);
            positionClose = text.indexOf(tagClose, shift);
            //System.out.println("shift = " +shift);
            //System.out.println(text.substring(shift, text.length()));

            //System.out.println("positionOpen = " + positionOpen);
            //System.out.println("positionClose = " + positionClose);
            // Выходим из цикла, если позиций больше нет
            if (positionOpen < 0 && positionClose < 0) break;

            if (positionOpen != -1 && positionOpen < positionClose) { //Open ближе чем close
                openedTags.push(positionOpen);
                shift = positionOpen + tagOpen.length();
                continue;
            }
            if (positionClose != -1 && (positionOpen > positionClose || positionOpen == -1)) { //Close ближе чем open
                if (openedTags.isEmpty())
                    break;
                tags.put(openedTags.pop(), positionClose + tagClose.length());
                shift = positionClose + tagClose.length();

            }
        }

        // Выводим по отсортированной
            for (Map.Entry<Integer, Integer> pair : tags.entrySet()) {
                System.out.println(text.substring(pair.getKey(), pair.getValue()));
            }
         bfr.close();
    }
}
