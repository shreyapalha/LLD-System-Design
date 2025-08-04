package com.lld.observer;

public class FirstDis implements Observer{


    @Override
    public void display(Weather weather) {
        System.out.println("First Display with humid "+weather.temp);
    }
}
