//: concurrency/MainThread.java
package com.javarush.task.task17.task1709_test;

public class MainThread {
    public static void main(String[] args) {
      LiftOff launch = new LiftOff();
      launch.run();


      // 2-й экземпляк ID = 1
      LiftOff l = new LiftOff();
      l.run();
    }
  }