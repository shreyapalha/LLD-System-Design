package com.lld.decorator;

public class Mocha extends CondimentDecorater{

    public Mocha(Beverage beverage){
        this.beverage=beverage;
    }


    @Override
    public double cost() {
        return beverage.cost()+20;
    }


}
