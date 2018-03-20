package com.javarush.task.task27.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        // 3. Метод get класса TransferObject должен ждать появления value, и возвращать его после того, как оно появится.
        while (!isValuePresent)
            try {
                //System.out.println("get wait");
                this.wait();
                //System.out.println("get stop wait");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        System.out.println("Got: " + value);
        // 5. Метод get класса TransferObject должен устанавливать флаг isValuePresent в false
        // и уведомлять другие нити ожидающие освобождения монитора перед возвратом значение поля value.
        isValuePresent = false;
        this.notifyAll();
        return value;

    }


    public synchronized void put(int value) {
        // 4. Метод put класса TransferObject должен ждать пока value заберут и
        // обновлять его значение после того, как оно пропадет.
        while (isValuePresent) {
           try {
               //System.out.println("put wait");
               this.wait();
               //System.out.println("put stop wait");
           } catch (InterruptedException e) {
               e.printStackTrace();
           }
        }

        this.value = value;
        System.out.println("Put: " + value);
        // 6. Метод put класса TransferObject должен устанавливать флаг isValuePresent в true
        // и уведомлять другие нити ожидающие освобождения монитора после обновления значение поля value.
        isValuePresent = true;
        this.notifyAll();
    }

}
