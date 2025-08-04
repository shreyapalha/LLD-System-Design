package com.lld.strategy;

public class MuteQuack implements QuackingBehaviour{
    @Override
    public String quack() {
        return "i quack mutely";
    }
}
