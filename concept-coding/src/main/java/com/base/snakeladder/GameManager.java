package com.base.snakeladder;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class GameManager {
    private Board board;
    private Dice dice;
    private Queue<Player> players;

    private GameStatus gameStatus;

    private Player winner;

    public GameManager(GameBuilder builder){
        this.board=builder.board;
        this.dice=builder.dice;
        this.players=new LinkedList<>(builder.players);
        this.gameStatus=GameStatus.NOT_STARTED;
    }

    public void play(){
        gameStatus=GameStatus.IN_PROGRESS;

        while(gameStatus==GameStatus.IN_PROGRESS){
            Player player=players.poll();
            int roll=dice.rollDice();

            makeTurn(player);

            if(gameStatus==GameStatus.IN_PROGRESS){
                players.add(player);
            }

        }

        System.out.println(winner.getName() + " wins");
    }

    private void makeTurn(Player player) {
        int roll=dice.rollDice();
        int initialPosition=player.getPosition();
        int nextPosition=initialPosition+roll;

        if(nextPosition > board.getSize()){
            System.out.println("Oh you need to score exact "+board.getSize());
            return;
        }
        if(nextPosition== board.getSize()){
            System.out.println("We found the winner ");
            gameStatus=GameStatus.COMPLETED;
            winner=player;
            return;
        }

        int finalPosition= board.getPosition(nextPosition);

        if(finalPosition>nextPosition){
            //ladder has come

        }else if(finalPosition<nextPosition){
            //snake has come
        }

        if(finalPosition== board.getSize()){
            System.out.println("We found the winner ");
            gameStatus=GameStatus.COMPLETED;
            winner=player;
            return;
        }

        player.setPosition(finalPosition);

        if (roll == 6) {
            System.out.printf("%s rolled a 6 and gets another turn!\n", player.getName());
            makeTurn(player);
        }


    }


    public static class GameBuilder{
        private Board board;
        private Dice dice;
        private Queue<Player> players;

        public GameBuilder setBoard(int size,List<BoardEntity> boardEntityList){
            board=new Board(size,boardEntityList);
            return this;
        }

        public GameBuilder setDice(int min,int max){
            dice=new Dice(min,max);
            return this;
        }

        public GameBuilder setPlayers(List<String> playerNames){
            players=new LinkedList<>();
            for(String name:playerNames){
                players.add(new Player(name));
            }
            return this;
        }

        public GameManager build(){
            if(board==null && dice==null && players==null){
                throw new IllegalArgumentException("Game Manager is not fully intialised");
            }
            return new GameManager(this);
        }
    }
}
