package com.javarush.task.task24.task2401;

/**
 * Created by userPG on 31.08.2017.
 */
public class SelfInterfaceMarkerImpl implements SelfInterfaceMarker {
   private int size = 1000;
    private String data = "Data";
   public String getData(){
        return data;
    }

    public int getSize(){
        return size;
    }

}
