package com.javarush.task.task17.task1709_test;

class Clock implements Runnable
{
private boolean isCancel = false;

public void cancel()
{
this.isCancel = true;
}

public void run()
{
while (!this.isCancel)
{
    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        //e.printStackTrace();
    }
    System.out.println("Tik");
}
}

    public static void main(String[] args) throws InterruptedException {
        Clock clock = new Clock();
        Thread clockThread = new Thread(clock);
        clockThread.start();

        Thread.sleep(10000);
        clock.cancel();
    }
}