package com.base.tictactoe.tictactoe;

public class Board {

    private PlayingPiece[][] board;

    private int size;

    public Board(int size){
        this.size=size;
        board=new PlayingPiece[size][size];
    }

    public PlayingPiece[][] getBoard() {
        return board;
    }

    public void setBoard(PlayingPiece[][] board) {
        this.board = board;
    }

    public boolean assignPiece(int x,int y,PlayingPiece playingPiece){
        if(board[x][y]!=null){
            return false;
        }
        board[x][y]=playingPiece;
        return true;
    }

    public boolean isThereFreeSpace(){
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]==null){
                    return true;
                }
            }
        }
        return false;
    }

    public void printBoard(){
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]!=null)
                    System.out.print(" "+board[i][j].getPieceType().name()  + "    |");
                else{
                    System.out.print("  "+"    |");
                }
            }
            System.out.println();
        }
    }

    public boolean checkForCross(PlayingPiece playingPiece) {
        boolean ans=false;
        int i=0,j=0;

        for( j=0;j<size;j++){
            for(i=0;i<size;i++){
                if(board[i][j]!=null && board[i][j].getPieceType().equals(playingPiece.getPieceType())){
                }else{
                    break;
                }
            }
            if(i==size){
                return true;
            }
        }

        for( j=0;j<size;j++){
            for(i=0;i<size;i++){
                if(board[j][i]!=null && board[j][i].getPieceType().equals(playingPiece.getPieceType())){
                }else{
                    break;
                }
            }
            if(i==size){
                return true;
            }
        }

        for( j=0;j<size;j++){
                if(board[j][j]!=null && board[j][j].getPieceType().equals(playingPiece.getPieceType())){
                }else{
                    break;
                }
        }
        if(j==size){
            return true;
        }

        for( j=size-1;j>=0;j--){
            if(board[j][j]!=null && board[j][j].getPieceType().equals(playingPiece.getPieceType())){
            }else{
                break;
            }
        }
        if(j==-1){
            return true;
        }

        return ans;
    }

    public boolean isValid(int x, int y) {
        if(board[x][y]!=null){
            return false;
        }
        return true;
    }
}
