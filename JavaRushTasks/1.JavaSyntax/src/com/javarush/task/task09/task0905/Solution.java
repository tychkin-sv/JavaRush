package com.javarush.task.task09.task0905;

/* 
Там, в синих глубинах стек-трейса…
*/

public class Solution {
    //public static StackTraceElement[] stackTraceElements;
    public static void main(String[] args) throws Exception {
        int deep = getStackTraceDeep();
       // for (StackTraceElement stackTraceElement:stackTraceElements) System.out.println(stackTraceElement.getMethodName());
    }

    public static int getStackTraceDeep() {
        //напишите тут ваш код
        StackTraceElement[] stack = Thread.currentThread().getStackTrace();
       // stackTraceElements = stack;
        System.out.println(stack.length);
       // for (StackTraceElement el: stack) System.out.println(el.getMethodName());
        return stack.length;
    }
}

