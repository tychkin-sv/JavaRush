package com.javarush.task.task22.task2207;

import java.io.*;
import java.util.*;

/* 
Обращенные слова
*/
public class Solution {
    public static List<Pair> result = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String fileName = console.readLine();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));

        StringBuilder sb = new StringBuilder();
        while (reader.ready()){
            sb.append(reader.readLine() + " ");
        }

        Set<Pair> set = new LinkedHashSet<>();

            String[] words = sb.toString().split(" ");
            for (int i=0; i<words.length - 1; i++ ) {
                StringBuilder direct = new StringBuilder(words[i]);
                //System.out.println("Step " + i + " " + direct.toString());
                 for (int j=i+1; j<words.length; j++) {
                     StringBuilder obr = new StringBuilder(words[j]).reverse();
                     boolean compare = direct.toString().equals(obr.toString());
                     //System.out.println("   " + obr.toString()+ " " + compare);

                     if (compare) {
                         Pair pair = new Pair();
                         pair.setFirst(direct.toString());
                         pair.setSecond(direct.reverse().toString());
                         set.add(pair);
                         break;
                     }
                 }
            }

        result.addAll(set);
        console.close();
        reader.close();

        for (Pair pair: result ) System.out.println(pair);

    }

    public static class Pair {
        String first;
        String second;

        public void setFirst(String first) {
            this.first = first;
        }

        public void setSecond(String second) {
            this.second = second;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (first != null ? !first.equals(pair.first) : pair.first != null) return false;
            return second != null ? second.equals(pair.second) : pair.second == null;

        }

        @Override
        public int hashCode() {
            int result = first != null ? first.hashCode() : 0;
            result = 31 * result + (second != null ? second.hashCode() : 0);
            return result;
        }

        @Override
        public String toString() {
            //System.out.println();
            return  first == null && second == null ? "" :
                    first == null && second != null ? second :
                    second == null && first != null ? first :
                    first.compareTo(second) < 0 ? first + " " + second : second + " " + first;

        }
    }

}
