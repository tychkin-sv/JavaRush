package com.javarush.task.task14.task1408;

/**
 * Created by Администратор on 04.07.2017.
 */
public class UkrainianHen extends Hen {

    @Override
    int getCountOfEggsPerMonth() {
        return 10;
    }
    // < Моя страна - Sssss. Я несу N яиц в месяц.> где Sssss - название страны, а N - количество яиц в месяц.


    @Override
    String getDescription() {
        return super.getDescription() + " Моя страна - " + Country.UKRAINE + ". Я несу " + this.getCountOfEggsPerMonth() + " яиц в месяц.";
    }
}


