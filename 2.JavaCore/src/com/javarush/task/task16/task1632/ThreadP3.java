package com.javarush.task.task16.task1632;

/**
 * Created by userPG on 10.07.2017.
 */
public class ThreadP3 extends Thread {
    public ThreadP3(String name) {
        super(name);
    }

    @Override
    public void run() {
        while(true){
            try {
                System.out.println("Ура");
                Thread.sleep(500);
            } catch (InterruptedException e) {
                //e.printStackTrace();
            }
        }
    }
}
