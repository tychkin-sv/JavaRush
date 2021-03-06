package com.javarush.task.task28.task2805;

import java.util.concurrent.atomic.AtomicInteger;

public class MyThread extends Thread {
    public static AtomicInteger myPriority = new AtomicInteger(Thread.MIN_PRIORITY);


    public MyThread() {
        super();
        newPriority(Thread.MAX_PRIORITY);


    }

    public MyThread(Runnable target) {
        super(target);
        newPriority(Thread.MAX_PRIORITY);
    }

    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        newPriority(Thread.MAX_PRIORITY);
    }

    public MyThread(String name) {
        super(name);
        newPriority(Thread.MAX_PRIORITY);
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        newPriority(Thread.MAX_PRIORITY);

    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        newPriority(Thread.MAX_PRIORITY);
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        newPriority(Thread.MAX_PRIORITY);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        newPriority(Thread.MAX_PRIORITY);
    }

    public void newPriority(int maxGroupPriority){

        if (myPriority.get()<10) {this.setPriority(myPriority.getAndIncrement());}
        else {
            this.setPriority(myPriority.get());
            myPriority.set(Thread.MIN_PRIORITY);
        }



    }

}
