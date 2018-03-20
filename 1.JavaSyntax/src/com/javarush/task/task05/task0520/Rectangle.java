package com.javarush.task.task05.task0520;

/* 
Создать класс прямоугольник (Rectangle)
*/


public class Rectangle {
    //напишите тут ваш код
    private int left;
    private int top;
    private int width;
    private int height;

    public Rectangle(int left, int top, int width, int height) {
        this.left = left;
        this.top = top;
        this.width = width;
        this.height = height;
    }

    public Rectangle(int left, int top) {
        this(left, top, 0 ,0);
    }

    public Rectangle(int left, int top, int width) {
        this(left, top, width ,width);
    }

    public Rectangle(Rectangle anotherRectangle) {
        this(anotherRectangle.left, anotherRectangle.top, anotherRectangle.width ,anotherRectangle.width);
    }

    public static void main(String[] args) {

    }
}
