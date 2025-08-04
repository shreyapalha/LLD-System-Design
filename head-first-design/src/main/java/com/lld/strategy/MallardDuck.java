package com.lld.strategy;

public class MallardDuck extends Duck{

    public MallardDuck(){
        this.flyingBehaviour=new FlyWithWings();
        this.quackingBehaviour=new Quack();
    }

    public String display(){
        return "I am mallard";
    }
}
