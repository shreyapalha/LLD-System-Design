package com.base.tictactoe;

import com.base.tictactoe.tictactoe.*;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Game {

    private Deque<Player> players;
    private Board board;

    public Game(){
        players=new LinkedList<>();
        board=new Board(3);
        initializeGame();
    }

    private void initializeGame(){
        XPlayingPiece xPlayingPiece=new XPlayingPiece();
        Player player1=new Player("Charan", xPlayingPiece);

        OPlayingPiece oPlayingPiece=new OPlayingPiece();
        Player player2=new Player("Shivam",oPlayingPiece);

        players.add(player1);
        players.add(player2);
    }

    public String startGame(){

        boolean notWinner=true;
        while(notWinner){
            Player player=players.removeFirst();

            board.printBoard();

            System.out.print(player.getName()+ "'s turn. Please enter row,column: ");
            Scanner inputScanner=new Scanner(System.in);
            String[] s=inputScanner.nextLine().split(",");
            int x=Integer.valueOf(s[0]);
            int y=Integer.valueOf(s[1]);

            if(!board.isValid(x,y)){
                System.out.println("Piece already present, Enter again");
                players.addFirst(player);
                continue;
            }

            if(board.isThereFreeSpace()){
                board.assignPiece(x,y,player.getPlayingPiece());
            }else{
                notWinner=false;
                continue;
            }

            boolean isWinner=board.checkForCross(player.getPlayingPiece());
            if(isWinner){
                board.printBoard();
                return " "+player.getName();
            }
            players.addLast(player);

        }
        return "Tie";

    }


}
