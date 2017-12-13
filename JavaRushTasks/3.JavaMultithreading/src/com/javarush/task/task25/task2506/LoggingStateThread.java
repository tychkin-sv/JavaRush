package com.javarush.task.task25.task2506;

/**
 * Created by TSV on 11.09.2017.
 */
public class LoggingStateThread extends Thread{
    private Thread thread;



    public LoggingStateThread(Thread thread) {
        this.thread = thread;
        System.out.println(thread.getState());
        this.setDaemon(true);
    }

    @Override
    public void run() {
        State state;
        State previous = State.NEW;

        while ( (state = thread.getState()) != State.TERMINATED) {
            if (state!=previous) System.out.println(state.toString());
            previous = state;
        }
        //state = thread.getState();
        if (state!=previous) System.out.println(state);
        this.interrupt();
    }
}
