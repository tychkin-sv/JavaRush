package com.javarush.task.task25.task2504;

/* 
Switch для нитей
*/
public class Solution {
    public static void processThreads(Thread... threads) {
        //implement this method - реализуйте этот метод
        for (Thread thread: threads){
            Thread.State state = thread.getState();

            switch (state){
                case NEW: thread.start(); break;

                case BLOCKED: thread.interrupt(); break;
                case WAITING: thread.interrupt(); break;
                case TIMED_WAITING:  thread.interrupt(); break;

                case RUNNABLE: boolean threadSate = thread.isInterrupted(); break;
                case TERMINATED: System.out.println(thread.getPriority()); break;

                default: break;
            }
        }

    }

    public static void main(String[] args) {
    }
}
