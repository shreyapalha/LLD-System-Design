package com.base.snakeladder;

import java.util.HashMap;
import java.util.List;

public class Board {
    private final HashMap<Integer,Integer> snakeAndLadder;
    private final int size;

    public Board(int size, List<BoardEntity> boardEntityList){
        this.size=size;
        this.snakeAndLadder=new HashMap<>();
        for(BoardEntity boardEntity:boardEntityList){
            snakeAndLadder.put(boardEntity.getStart(),boardEntity.getEnd());
        }
    }

    public int getSize() {
        return size;
    }

    public int getPosition(int pos){
        return snakeAndLadder.getOrDefault(pos,pos);
    }
}
