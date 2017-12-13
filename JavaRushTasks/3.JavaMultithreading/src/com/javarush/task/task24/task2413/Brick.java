package com.javarush.task.task24.task2413;

/**
 * Created by userPG on 29.08.2017.
 */
public class Brick extends BaseObject {
    // (скорость шарика) типа
    private double speed;
    // (направление движения по оси x: 1 — вправо, -1 — влево, 0 — начальное значение, стоим на месте)
    private double direction;


    public Brick(double x, double y) {
        super(x, y, 3);
    }

    @Override
    public void draw(Canvas canvas) {

    }

    @Override
    public void move() {

    }
}
