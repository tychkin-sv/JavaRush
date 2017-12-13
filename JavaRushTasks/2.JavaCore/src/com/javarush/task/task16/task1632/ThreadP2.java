package com.javarush.task.task16.task1632;

/**
 * Created by userPG on 10.07.2017.
 */
public class ThreadP2 extends Thread {
    public ThreadP2(String name) {
        super(name);
    }

    @Override
    public void interrupt() {
        super.interrupt();
        System.out.println("InterruptedException");
    }
}
