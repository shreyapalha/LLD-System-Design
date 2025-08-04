package com.lld.observer;

public class ThirdDis implements Observer{


    @Override
    public void display(Weather weather) {
        System.out.println("Third Display with aqi "+weather.aqi);
    }
}
