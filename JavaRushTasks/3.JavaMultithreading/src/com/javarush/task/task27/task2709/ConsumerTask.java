package com.javarush.task.task27.task2709;

public class ConsumerTask implements Runnable {
    private TransferObject transferObject;
    protected volatile boolean stopped;

    public ConsumerTask(TransferObject transferObject) {
        this.transferObject = transferObject;
        new Thread(this, "ConsumerTask").start();
    }

    public void run() {
        // 1. В методе run класса ConsumerTask должен содержаться synchronized блок, монитор - transferObject.


            while (!stopped) {
                synchronized (transferObject){
                transferObject.get();
                }
            }

    }

    public void stop() {
        stopped = true;
    }
}