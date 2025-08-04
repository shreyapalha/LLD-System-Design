package com.lld.observer;

import java.util.ArrayList;

public class Weather {
    int temp;
    int humidity;
    int aqi;
   ArrayList<Observer> observerList=new ArrayList<>();

   public void subscribe(Observer observer){
       this.observerList.add(observer);
   }

   public void notifyAllObs(){
       for(Observer obs:observerList){
           obs.display(this);
       }
   }

   public void update(int temp,int humidity,int aqi){
       this.temp=temp;
       this.humidity=humidity;
       this.aqi=aqi;
       notifyAllObs();
   }
}
