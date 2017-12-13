package com.javarush.task.task29.task2909.car;

public class Truck extends Car {

    public Truck(int numberOfPassengers) {
        super(Car.SEDAN, numberOfPassengers);
    }

    @Override
    public int getMaxSpeed() {
        return Car.MAX_TRUCK_SPEED;
    }
}
