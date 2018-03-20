package com.javarush.task.test;

public class Solution {
public int step;
public static void main(String[] args) {
    method1();
}
public static void method1() {
    method2();
}
public static void method2() {
    new Solution().method3();
}
public  void method3() {
    method4();
}
public void method4() {
    step++;
    System.out.println(step);
    for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
        System.out.println(step);
        System.out.println(element);
    }
    if (step > 1)
        return;
    main(null);
}
}