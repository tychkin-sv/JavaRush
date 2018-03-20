package com.javarush.task.task16.task1632;

/**
 * Created by userPG on 10.07.2017.
 */
public class ThreadP4 extends Thread implements Message{
    public ThreadP4(String name) {
        super(name);
    }

    @Override
    public void showWarning() {
        if (this.isAlive()) this.interrupt();
    }
}
