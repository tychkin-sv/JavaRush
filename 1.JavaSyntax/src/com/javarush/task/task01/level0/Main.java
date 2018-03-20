package com.javarush.task.task01.level0;

/**
 * Created by userPG on 21.06.2017.
 */
class Main
{
    public int count = 0;     //объявили переменную класса

    public void run()
    {
        count = 15;           //обращение к переменной класса
        int count = 10;       //объявили локальную переменную метода
        count ++;             //обращение к переменной метода
    }
}