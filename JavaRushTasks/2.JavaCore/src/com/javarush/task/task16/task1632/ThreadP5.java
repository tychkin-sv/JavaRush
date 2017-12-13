package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by userPG on 10.07.2017.
 */
public class ThreadP5 extends Thread {
    public ThreadP5(String name) {
        super(name);
    }
    public void run(){
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line;
        int sum = 0;
        try{
        while(!(line = reader.readLine()).equals("N")) {
            sum += Integer.parseInt(line);
        }
        System.out.println(sum);
        }catch(IOException e){}
    }
}
