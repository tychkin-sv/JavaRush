package com.javarush.task.task20.task2000;

import java.io.*;

/**
 * Created by TSV on 31.07.2017.
 */
public class Main {
public static class Cat implements Serializable{
    private String name = "Cat";
}

    public static void main(String[] args) throws Exception
    {
        Cat cat = new Cat();

        //save cat to file
        FileOutputStream fileOutput = new FileOutputStream("cat.dat");
        ObjectOutputStream outputStream = new ObjectOutputStream(fileOutput);
        outputStream.writeObject(cat);
        fileOutput.close();
        outputStream.close();

        //load cat from file
        FileInputStream fiStream = new FileInputStream("cat.dat");
        ObjectInputStream objectStream = new ObjectInputStream(fiStream);
        Object object = objectStream.readObject();
        fiStream.close();
        objectStream.close();

        Cat newCat = (Cat) object;

        System.out.println(cat.equals(newCat));
    }
}
