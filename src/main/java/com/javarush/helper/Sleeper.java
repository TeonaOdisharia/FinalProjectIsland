package com.javarush.helper;

public class Sleeper {
    private static final int SPEED = 1000;
    public static void sleep(int timeout){
        try {
            Thread.sleep(timeout/SPEED);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
