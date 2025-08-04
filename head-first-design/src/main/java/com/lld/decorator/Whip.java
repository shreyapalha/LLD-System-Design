package com.lld.decorator;

public class Whip extends CondimentDecorater{

    public Whip(Beverage beverage){
        this.beverage=beverage;
    }


    @Override
    public double cost() {
        return beverage.cost()+25;
    }


}
