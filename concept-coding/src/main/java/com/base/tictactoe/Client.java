package com.base.tictactoe;

import com.base.tictactoe.tictactoe.Board;

public class Client {

    public static void main(String[] args){
        Game game=new Game();

        String winner = game.startGame();
        System.out.println("Winner of the game: " + winner);
    }
}
