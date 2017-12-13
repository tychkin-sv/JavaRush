package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}

        };
        detectAllWords(crossword, "home", "same", "rr");
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        List<Word> result =  new ArrayList();
        List<String> data = new ArrayList<>();

        int min = Integer.MAX_VALUE;
        // определяем самое короткое слово для минимальной длины
        for (String word: words){
            if (word.length()<min) min = word.length();
        }
        //System.out.println(crossword.length);
        //System.out.println(crossword[0].length);
        // размер кроссворда
        int dimI = crossword.length;
        int dimJ= crossword[0].length;

        // Находим все возможные строки строки
        StringBuilder sbCross =  new StringBuilder();
        StringBuilder sbCrossReverse =  new StringBuilder();

        // по горизонтали
        for (int i = 0; i<dimI; i++){

            sbCross.setLength(0);
            for (int j = 0; j<dimJ; j++){
                sbCross.append((char) crossword[i][j]);
            }
            data.add(sbCross.toString());
            //System.out.println(sbCross.toString());
            sbCrossReverse = new StringBuilder(sbCross).reverse();

            // определяем наличие слова
            for (String word: words){
                //System.out.println(word);
                Word w = null;
                // прямая последовательность
                int index = sbCross.toString().indexOf(word);
                //System.out.println(index);
                if (index!=-1) {
                    //System.out.println(sbCross.toString());
                    System.out.println("Содержится в прямом - " + word);
                    w = new Word(word);
                    w.setStartPoint(index, i);
                    w.setEndPoint(index + word.length()-1, i);
                }
                if (w!=null) result.add(w);
                // обратная последовательность
                index = sbCrossReverse.toString().indexOf(word);
                if (index!=-1) {
                    System.out.println("Содержится в обратном - " + word);
                    w = new Word(word);
                    w.setStartPoint(dimJ - index - 1, i);
                    w.setEndPoint(dimJ - index - word.length(), i);
                }
                if (w!=null) result.add(w);
            }
        }

        // по вертикали
        for (int j = 0; j<dimJ; j++){
            sbCross.setLength(0);
            for (int i = 0; i<dimI; i++){
                sbCross.append((char) crossword[i][j]);
            }
            data.add(sbCross.toString());
            //System.out.println(sbCross.toString() +" " +sbCross.reverse().toString());
            sbCrossReverse = new StringBuilder(sbCross).reverse();

            // определяем наличие слова
            for (String word: words){
                //System.out.println(word);
                Word w = null;
                // прямая последовательность
                int index = sbCross.toString().indexOf(word);
                //System.out.println(index);
                if (index!=-1) {
                    //System.out.println(sbCross.toString());
                    //System.out.println("Содержится в прямом");
                    w = new Word(word);
                    w.setStartPoint(j, index);
                    w.setEndPoint(j, index + word.length()-1);
                }

                // обратная последовательность
                index = sbCrossReverse.toString().indexOf(word);
                if (index!=-1) {
                    //System.out.println("Содержится в обратном");
                    w = new Word(word);
                    w.setStartPoint( j, dimI - index - 1);
                    w.setEndPoint( j,dimI - index - word.length());
                }

                if (w!=null) result.add(w);
            }


        }

        // Наклон спуск слева направо.
        // количество строк
        int dimIJ = dimI + dimJ - 1;
        int ij = 0;

        while (ij<dimIJ) {
            sbCross.setLength(0);
            // Определяем индекс начальный индекс для i
            // Определяем индекс начальный индекс для J
            int startI;
            int startJ;
            if (ij<dimI) {
                startI = dimI - 1 - ij%dimI;
                startJ = 0;
            }
            else {
                startI = 0;
                startJ = ij%dimIJ - dimI + 1;
            }
           // System.out.println(ij + ". startI : " + startI + " startJ : " + startJ);

            int j = startJ;
            for (int i = startI; i<dimI; i++)
            {
                sbCross.append((char) crossword[i][j]);
                j++; // изменяем также и j
                if (j == dimJ) break;
            }
            data.add(sbCross.toString());
            //System.out.println(sbCross.toString() +" " +sbCross.reverse().toString());
            sbCrossReverse = new StringBuilder(sbCross).reverse();

            // определяем наличие слова
            for (String word: words){
                //System.out.println(word);
                Word w = null;
                // прямая последовательность
                int index = sbCross.toString().indexOf(word);
                //System.out.println(index);
                if (index!=-1) {
                    //System.out.println(sbCross.toString());
                    //System.out.println("Содержится в прямом");
                    w = new Word(word);
                    w.setStartPoint(startJ + index, startI + index);
                    w.setEndPoint(startJ + index + word.length() - 1, startI + index + word.length() - 1);
                } // работает!!!!

                // обратная последовательность
                index = sbCrossReverse.toString().indexOf(word);
                int len = sbCrossReverse.length();
                if (index!=-1) {
                    //System.out.println("Содержится в обратном");
                    w = new Word(word);
                   // System.out.println(dimJ + " " + dimI);
                    w.setStartPoint( startJ + len - index - 1, startI + len - index - 1);
                    w.setEndPoint( startJ + len - index - word.length(),startI + len - index - word.length());
                }// работает!!!!

                if (w!=null) result.add(w);
            }
            ij++;
        }

        // Наклон спуск с права налево.
        ij = 0;
        while (ij<dimIJ)
        {
            sbCross.setLength(0);
            // Определяем индекс начальный индекс для i
            // Определяем индекс начальный индекс для J
            int startI;
            int startJ;
            if (ij<dimI) {
                startI = ij%dimI;
                startJ = 0;
            }
            else {
                startI = dimI - 1;
                startJ = ij%dimIJ - dimI + 1;
            }
            //System.out.println(ij + ". startI : " + startI + " startJ : " + startJ);

            int i = startI;
            for (int j = startJ; j<dimJ; j++)
            {
                //System.out.println(i + " " + j );
                sbCross.append((char) crossword[i][j]);

                i--; // изменяем также и i
                if (i == -1) break;
            }
            data.add(sbCross.toString());
            //System.out.println(sbCross.toString());
            sbCrossReverse = new StringBuilder(sbCross).reverse();
            //System.out.println(sbCross.toString());
            // определяем наличие слова
            for (String word: words){
                //System.out.println(word);
                Word w = null;
                // прямая последовательность
                int index = sbCross.toString().indexOf(word);
                //System.out.println(index);
                if (index!=-1) {
                    //System.out.println(sbCross.toString());
                    //System.out.println("Содержится в прямом");
                    w = new Word(word);
                    w.setStartPoint(startJ + index, startI - index);
                    //System.out.println(startI + " - " + index + " - " + word.length());
                    w.setEndPoint(startJ + index + word.length() - 1, startI - index - word.length() + 1);
                } // работает!!!!

                // обратная последовательность
                index = sbCrossReverse.toString().indexOf(word);
                int len = sbCrossReverse.length();
                if (index!=-1) {
                    //System.out.println("Содержится в обратном");
                    w = new Word(word);
                    // System.out.println(dimJ + " " + dimI);
                    System.out.println(startI + " + " + len + " - " + index + " - " + 1);
                    w.setStartPoint( startJ + len - index - 1, startI - len - index + 1);
                    //System.out.println(startJ + " + " + index + " - " );
                    w.setEndPoint( startJ  + len - word.length() - index ,startI - len + index + word.length());
                }// !!!!
                if (w!=null) result.add(w);
            }
            ij++;
        }
        System.out.println("result :");
        for (Word w: result){
            System.out.println(w);
        }
        return result;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }
}
