package com.javarush.task.task25.task2510;

/* 
Поживем - увидим
*/
public class Solution extends Thread {

    public Solution() throws Throwable {

        setDefaultUncaughtExceptionHandler(
                new UncaughtExceptionHandler(){
            @Override
            public void uncaughtException(Thread t, Throwable e) {

                String outStr;

                if (e instanceof Error) {outStr = "Нельзя дальше работать";}
                else if (e instanceof Exception){outStr = "Надо обработать";}
                else outStr = "ХЗ";
                System.out.println(outStr);

            }
        });

    }


    public static void main(String[] args) throws Throwable {
        Thread solution1 = new Solution();
    }



}
