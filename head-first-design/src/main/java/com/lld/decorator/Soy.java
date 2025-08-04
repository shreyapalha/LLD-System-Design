package com.lld.decorator;

public class Soy extends CondimentDecorater{

    public Soy(Beverage beverage){
        this.beverage=beverage;
    }


    @Override
    public double cost() {
        return beverage.cost()+31;
    }


}
