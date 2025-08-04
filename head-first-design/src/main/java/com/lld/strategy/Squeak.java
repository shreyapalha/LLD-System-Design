package com.lld.strategy;

public class Squeak implements QuackingBehaviour{
    @Override
    public String quack() {
        return "i squeak";
    }
}
