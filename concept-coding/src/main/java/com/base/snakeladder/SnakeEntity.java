package com.base.snakeladder;

public class SnakeEntity extends BoardEntity{

    public SnakeEntity(int start, int end){
        super(start,end);
        if(end>start){
            throw new IllegalArgumentException("For Snake start position should be greater than end position");
        }
    }


}
