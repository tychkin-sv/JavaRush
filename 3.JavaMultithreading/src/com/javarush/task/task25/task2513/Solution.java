package com.javarush.task.task25.task2513;

import java.util.Random;

import static java.lang.Thread.yield;

/* 
Обеспечение отсутствия прерывания важной операции
*/
public class Solution {
    private static final Integer THRESHOLD_VALUE = 500;
    private static final Random RANDOM = new Random();

    public synchronized void moveMoney(Account from, Account to, int amount) {
        int random = RANDOM.nextInt(5000);
        from.setBalance(from.getBalance() - amount);
        if (random>THRESHOLD_VALUE) Thread.yield();
        to.setBalance(to.getBalance() + amount);

    }

    class Account {
        private int balance;

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }
    }

    public static void main(String[] args) {

    }
}
