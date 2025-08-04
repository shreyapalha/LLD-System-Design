package com.lld.strategy;

public class Quack implements QuackingBehaviour{
    @Override
    public String quack() {
        return "i quack";
    }
}
