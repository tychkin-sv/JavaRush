package com.javarush.task.task21.task2101;

import java.util.Arrays;

/*
Определяем адрес сети
*/
public class Solution {
    public static void main(String[] args) {
        byte[] ip = new byte[]{(byte) 192, (byte) 168, 1, 2};
        byte[] mask = new byte[]{(byte) 255, (byte) 255, (byte) 254, 0};
        byte[] netAddress = getNetAddress(ip, mask);
        print(ip);          //11000000 10101000 00000001 00000010
        print(mask);        //11111111 11111111 11111110 00000000
        print(netAddress);  //11000000 10101000 00000000 00000000
    }

    public static byte[] getNetAddress(byte[] ip, byte[] mask) {
        byte[] result = new byte[4];

        result[0] = (byte) (ip[0] & mask[0]);
        result[1] = (byte) (ip[1] & mask[1]);
        result[2] = (byte) (ip[2] & mask[2]);
        result[3] = (byte) (ip[3] & mask[3]);
        return result;
    }

    public static void print(byte[] bytes) {
        // Зачем такая сложность? См. ниже.
        String s0 = Integer.toBinaryString((bytes[0] & 0xFF) + 0x100).substring(1);
        String s1 = Integer.toBinaryString((bytes[1] & 0xFF) + 0x100).substring(1);
        String s2 = Integer.toBinaryString((bytes[2] & 0xFF) + 0x100).substring(1);
        String s3 = Integer.toBinaryString((bytes[3] & 0xFF) + 0x100).substring(1);

        // всегда int, хотя и byte. А int у нас 32 бита
        for (int i=0; i<bytes.length; i++){
            System.out.println(bytes[i]); // используется println(int x)!!
            System.out.println(Byte.toString(bytes[i])); // Даже тут.
        }

        //System.out.println(Arrays.toString(bytes));
        //String tmp = Integer.toBinaryString(bytes[0] & 0xFF);
        //System.out.println(tmp);

       System.out.println(s0 + " " + s1 + " " + s2 + " " +s3);
    }
}
