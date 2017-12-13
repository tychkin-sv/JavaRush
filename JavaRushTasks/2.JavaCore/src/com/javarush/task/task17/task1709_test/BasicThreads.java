package com.javarush.task.task17.task1709_test;

public class BasicThreads {
  public static void main(String[] args) {
    Thread t = new Thread(new LiftOff());
    Thread t1 = new Thread(new LiftOff());
    t.start();
    t1.start();
    System.out.println("Waiting for LiftOff");

  }
}