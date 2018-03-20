package com.javarush.task.task17.task1709_test;

public class VolatileDemo {
    
    public static void main(String[] args) {
        new VolatileDemo().start();
    }
    //----------------------------------------------

    volatile
    private boolean btExit = false; //попробуйте убрать volatile
    
    // запуск потоков
    public void start() {
        new Thread(gui).start();
        System.out.println("gui thread started");
        new Thread(game).start();
        System.out.println("game thread started");
    }
    
    // поток для интерфейса
    Runnable gui = new Runnable() {
        @Override
        public void run() {
            try {
                Thread.sleep(2000); // типа пользователь общается с GUI и выходит из игры
            } catch (InterruptedException ignored) {}
            btExit = true; // поток game не видит это изменение без volatile
            System.out.println("gui thread finished");
        }
    };

    // поток для игры
    Runnable game = new Runnable() {
        @Override
        public void run() {
            while (!btExit) {
                // без volatile этот цикл крутится бесконечно
            }
            System.out.println("game thread finished");
        }
    };
}