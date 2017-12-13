package com.javarush.task.task29.task2909.car;

import java.util.Date;

public abstract class Car {
    public static final int TRUCK = 0;
    public static final int SEDAN = 1;
    public static final int CABRIOLET = 2;
    public static final int MAX_TRUCK_SPEED = 80;
    public static final int MAX_SEDAN_SPEED = 120;
    public static final int MAX_CABRIOLET_SPEED = 90;

    double fuel;

    public double summerFuelConsumption;
    public double winterFuelConsumption;
    public double winterWarmingUp;

    private int type;

    private boolean driverAvailable;
    private int numberOfPassengers;

    public static Car create(int type, int numberOfPassengers){
        Car car = null;
        switch (type) {
            case TRUCK: car = new Truck(numberOfPassengers); break;
            case SEDAN: car = new Sedan(numberOfPassengers); break;
            case CABRIOLET: car = new Cabriolet(numberOfPassengers); break;
        }
        return car;
    }

    protected Car(int type, int numberOfPassengers) {
        this.type = type;
        this.numberOfPassengers = numberOfPassengers;
    }

    public void fill(double numberOfLiters) throws Exception {
        if (numberOfLiters < 0) throw new Exception();
        fuel += numberOfLiters;
     }

    public double getTripConsumption(Date date, int length, Date SummerStart, Date SummerEnd) {
        if ( isSummer(date, SummerStart, SummerEnd)) {
            return getSummerConsumption(length);
        }
        return getWinterConsumption(length);
    }

    public int getNumberOfPassengersCanBeTransferred() {
        if (!canPassengersBeTransferred())
            return 0;
        return numberOfPassengers;
    }

    public boolean isDriverAvailable() {
        return driverAvailable;
    }

    public void setDriverAvailable(boolean driverAvailable) {
        this.driverAvailable = driverAvailable;
    }

    private boolean canPassengersBeTransferred(){

        return isDriverAvailable() && fuel>0;
    }

    public void startMoving() {
        if (numberOfPassengers > 0) fastenPassengersBelts();
            fastenDriverBelt();
    }

    public void fastenPassengersBelts() {
    }

    public void fastenDriverBelt() {
    }

    public abstract int getMaxSpeed();

   public boolean isSummer(Date date , Date summerStart, Date summerEnd){
       if ( date.before(summerStart) || date.after(summerEnd)  )  return false;

       return true;
   }

   public double getWinterConsumption(int length){
       return length * winterFuelConsumption + winterWarmingUp;
   }

   public double getSummerConsumption(int length){
       return length * summerFuelConsumption;
   }
}