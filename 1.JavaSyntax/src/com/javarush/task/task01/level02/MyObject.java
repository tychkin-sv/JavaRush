package com.javarush.task.task01.level02;

/**
 * Created by userPG on 06.04.2017.
 */
public class MyObject {
    private int id;

    public MyObject(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MyObject{" +
                "id=" + id +
                '}';
    }
}
