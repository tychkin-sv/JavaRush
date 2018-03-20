package com.javarush.task.task14.task1408;

/**
 * Created by Администратор on 04.07.2017.
 */
public class RussianHen extends Hen {
        @Override
        int getCountOfEggsPerMonth() {
            return 5;
        }

        @Override
        String getDescription() {
            return super.getDescription() + " Моя страна - " + Country.RUSSIA + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
        }
}
