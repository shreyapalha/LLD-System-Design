package com.lld.strategy;

public class FlyNoWings implements FlyingBehaviour{

    @Override
    public String fly() {
        return "I am flying with no wings";
    }
}
