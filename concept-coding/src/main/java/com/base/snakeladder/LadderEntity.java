package com.base.snakeladder;

public class LadderEntity extends BoardEntity{

    public LadderEntity(int start, int end){
        super(start,end);
        if(end<start){
            throw new IllegalArgumentException("For Ladder start position should be smaller than end position");
        }
    }


}
