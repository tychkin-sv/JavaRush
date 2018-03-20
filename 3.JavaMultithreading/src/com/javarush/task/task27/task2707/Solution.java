package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    static public Thread thread1;
    static public Thread thread2;

    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2) {
        synchronized (obj1) {
            {
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
            }
        }
    }

    public static boolean isNormalLockOrder(final Solution solution, final Object o1, final Object o2) throws Exception {
        //do something here
        thread1 = new Thread("thread1"){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": run");
               synchronized (o1){
                   try {
                       Thread.sleep(50);
                       synchronized (o2){

                       }
                   } catch (InterruptedException e) {
                       e.printStackTrace();
                   }
               }
            }
        };

        thread2 = new Thread("thread2"){
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + ": run");
                solution.someMethodWithSynchronizedBlocks(o1,o2);
            }
        };
        thread1.start();
        System.out.println("Шаг 1");

        System.out.println("Шаг 2");
        thread2.start();
        Thread.sleep(2000);
        return !(thread2.getState() == Thread.State.BLOCKED) ;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isNormalLockOrder(solution, o1, o2));

        System.out.println(thread1.getState());
        System.out.println(thread2.getState());

    }
}
