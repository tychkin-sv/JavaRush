package com.javarush.task.task17.task1709_test;

import java.util.ArrayList;
import java.util.List;
/**
 * Created by userPG on 11.07.2017.
 */
public class Main {
    public static List<String> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new ThreadTest("1");
        Thread thread2 = new ThreadTest("2");
        thread1.start();
        thread2.start();

        Thread.sleep(10000);

        // запрос на прерывание потоков
        thread1.interrupt();
        thread2.interrupt();

        System.out.println("Потоки добавили = " + (ThreadTest.count) + " записей");

        // прерваны ли потоки
        System.out.println("поток thread1 прерван = " + thread1.isInterrupted());
        System.out.println("поток thread2 прерван = " + thread2.isInterrupted());

        // Ожтдание пока потоки не погибнут
        while (thread1.isAlive()) System.out.println("thread1 живет = " + thread1.isAlive());
        System.out.println("выход из while1");

        // Ожидание пока потоки не погибнут
        while (thread2.isAlive()) System.out.println("thread2 живет = " + thread2.isAlive());
        System.out.println("выход из while2");

        // вывод того, что потоки добавили
        for (String s:list) System.out.println(s);
    }

    public static class ThreadTest extends Thread{
        public static int count;
        public ThreadTest(String name) {
            super(name);
        }

        @Override
        public void run() {
            while (!interrupted()){
                try {
                    Thread.sleep(1000);
                    synchronized (list){
                        list.add("Мы добавили из потока " + getName()+ ", запись номер " + count);
                        count++;
                    }
                } catch (InterruptedException e) {
                    //e.printStackTrace();
                }

            }
        }
    }
}
