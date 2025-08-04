package com.lld.strategy;

public class Duck {
     FlyingBehaviour flyingBehaviour;

     int value;

    public int getValue() {
        return value;
    }

    QuackingBehaviour quackingBehaviour;

    public String swim(){
        return "can swim";
    }

    public void setValue(int value){
        this.value=value;
    }

    public String display(){
        return "looks pretty";
    }

    public String performFly(){
        return flyingBehaviour.fly();
    }

    public String performQuack(){
        return quackingBehaviour.quack();
    }
}
