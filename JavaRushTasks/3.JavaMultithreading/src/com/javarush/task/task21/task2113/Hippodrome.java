package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TSV on 14.08.2017.
 */
public class Hippodrome {
    public static Hippodrome game;

    private List<Horse> horses;

    public Hippodrome(List<Horse> horses) {
        this.horses = horses;
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public static void main(String[] args) {
        game = new Hippodrome(new ArrayList<Horse>());
        Horse horse1 = new Horse("1", 3, 0);
        Horse horse2 = new Horse("2", 3, 0);
        Horse horse3 = new Horse("3", 5, 0);
        game.getHorses().add(horse1);
        game.getHorses().add(horse2);
        game.getHorses().add(horse3);
        game.run();
        game.printWinner();

    }

    public void move(){
        for (Horse horse: horses) horse.move();

    }
    public void print(){
        for (Horse horse: horses) horse.print();
        for (int i =0; i<10; i++) System.out.println();
    }
    public void run(){

        for (int i=0; i<100; i++){
            move();
            print();


            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
    public Horse getWinner(){
        Horse result = null;
        double max = Double.MIN_VALUE;
        for (Horse horse: horses) {
           if (max<horse.getDistance()) {
               max = horse.getDistance();
               result = horse;
           }
       }
       return result;
    }

    public  void printWinner(){
        System.out.println("Winner is " + getWinner().getName() + "!");
    }




}
