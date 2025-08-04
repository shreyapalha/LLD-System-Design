package com.lld.observer;

public class SecondDis implements Observer{


    @Override
    public void display(Weather weather) {
        System.out.println("Second Display with humidity "+weather.humidity);
    }
}
