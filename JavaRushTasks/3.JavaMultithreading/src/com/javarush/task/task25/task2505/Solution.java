package com.javarush.task.task25.task2505;

/* 
Без дураков
*/
public class Solution {

    public static void main(String[] args) throws InterruptedException {
        MyThread myThread = new Solution().new MyThread("super secret key");
        myThread.start();
        //System.out.println("пока");
    }

    public class MyThread extends Thread {
        private String secretKey;

        private class MyUncaughtExceptionHandler implements Thread.UncaughtExceptionHandler {

            public MyUncaughtExceptionHandler() {
            }

            @Override
            public void uncaughtException(Thread t, Throwable e) {

                try {
                    Thread.sleep(500);
                    //System.out.println("привет");
                } catch (InterruptedException e1) {
                    e1.printStackTrace();
                }
                //super secret key, Thread-0, it's an example
                String out = String.format("%s, %s, %s",
                        secretKey, t.getName(), e.getMessage());
                System.out.println(out);
            }
        }

        public MyThread(String secretKey) {
            this.secretKey = secretKey;
            setUncaughtExceptionHandler(new MyUncaughtExceptionHandler());
            //setDaemon(true);
        }

        @Override
        public void run() {
            throw new NullPointerException("it's an example");
        }
    }

}

