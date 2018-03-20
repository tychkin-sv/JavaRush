package com.javarush.task.task14.task1413;

/**
 * Created by Sergiy on 04.07.2017.
 */ /*
Computer
*/
public class Computer{
   private Keyboard keyboard;
   private Mouse mouse;
   private Monitor monitor;

    public Computer( Keyboard keyboard, Mouse mouse, Monitor monitor) {
        this.mouse = mouse;
        this.keyboard = keyboard;
        this.monitor = monitor;
    }

    public Mouse getMouse() {
        return mouse;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public Monitor getMonitor() {
        return monitor;
    }
}
