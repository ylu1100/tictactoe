package com.company;

import java.util.ArrayList;

public class tttoe {
    private String[][]board;
    public tttoe(){
        board=new String[3][3];
    }

    public void playermove(String marker,int row,int col){
        board[row][col]=marker;
    }
    public String convertkeytocoord(String key){
        if(key.equals("q")&&board[0][0].equals("[ ]")){
            return "0,0";
        }
        if(key.equals("w")&&board[0][1].equals("[ ]")){
            return "0,1";
        }
        if(key.equals("e")&&board[0][2].equals("[ ]")){
            return "0,2";
        }
        if(key.equals("a")&&board[1][0].equals("[ ]")){
            return "1,0";
        }
        if(key.equals("s")&&board[1][1].equals("[ ]")){
            return "1,1";
        }
        if(key.equals("d")&&board[1][2].equals("[ ]")){
            return "1,2";
        }
        if(key.equals("z")&&board[2][0].equals("[ ]")){
            return "2,0";
        }
        if(key.equals("x")&&board[2][1].equals("[ ]")){
            return "2,1";
        }
        if(key.equals("c")&&board[2][2].equals("[ ]")){
            return "2,2";
        }
        else{
            return "invalid";
        }
    }
    public void pveAddMoves(ArrayList<String>moves){
        moves.add("q");
        moves.add("w");
        moves.add("e");
        moves.add("a");
        moves.add("s");
        moves.add("d");
        moves.add("z");
        moves.add("x");
        moves.add("c");
    }

    public void reset(){
        for(int x = 0; x<board.length;x++){
            for(int y = 0;y<board[0].length;y++){
                board[x][y]="[ ]";
            }
        }
    }


    public boolean winacross(String marker){
        if(board[0][0].equals(marker)&&board[1][0].equals(marker)&&board[2][0].equals(marker)){
            return true;
        }
        else if(board[0][1].equals(marker)&&board[1][1].equals(marker)&&board[2][1].equals(marker)){
            return true;
        }
        else if(board[0][2].equals(marker)&&board[1][2].equals(marker)&&board[2][2].equals(marker)){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean winvertical(String marker){
        if(board[0][0].equals(marker)&&board[0][1].equals(marker)&&board[0][2].equals(marker)){
            return true;
        }
        else if(board[1][0].equals(marker)&&board[1][1].equals(marker)&&board[1][2].equals(marker)){
            return true;
        }
        return(board[2][0].equals(marker)&&board[2][1].equals(marker)&&board[2][2].equals(marker));
    }
    public boolean windiagonal(String marker){
        if(board[0][0].equals(marker)&&board[1][1].equals(marker)&&board[2][2].equals(marker)){
            return true;
        }
        return(board[2][0].equals(marker)&&board[1][1].equals(marker)&&board[0][2].equals(marker));
    }
    public boolean win(String marker){
        if(winacross(marker)){
            return true;
        }
        else if(winvertical(marker)){
            return true;
        }
        return (windiagonal(marker));
    }
    public boolean tie(){
        boolean tie=true;
        for(int x = 0;x<board.length;x++){
            for(int y = 0;y<board[x].length;y++){
                if(board[x][y].equals("[ ]")){
                    tie=false;
                }
            }
        }
        return tie;
    }
    public boolean gameover(){
        if(win("[X]")||win("[O]")||tie()){
            return true;
        }
        else{
            return false;
        }
    }
    public String printBoard(){
        String boardstr="";
        for(int x = 0;x<board.length;x++){
            for(int y = 0;y<board[0].length;y++){
                boardstr+=board[x][y];
            }
            boardstr+="\n";
        }
        return boardstr;
    }
    //algorithms for smarter bot moves
    public String botDiagonalMove(String marker){
        if(board[0][0].equals(marker)&&board[1][1].equals(marker)&&board[2][2].equals("[ ]")){
            return "c";
        }
        else if(board[0][0].equals(marker)&&board[2][2].equals(marker)&&board[1][1].equals("[ ]")){
            return "s";
        }
        else if(board[1][1].equals(marker)&&board[2][2].equals(marker)&&board[0][0].equals("[ ]")){
            return "q";
        }
        else if(board[0][2].equals(marker)&&board[1][1].equals(marker)&&board[2][0].equals("[ ]")){
            return "z";
        }
        else if(board[0][2].equals(marker)&&board[2][0].equals(marker)&&board[1][1].equals("[ ]")){
            return "s";
        }
        else if(board[1][1].equals(marker)&&board[2][0].equals(marker)&&board[0][2].equals("[ ]")){
            return "e";
        }
        else{
            return "invalid";
        }
    }
    public String botAcrossMove(String marker){
        if(board[0][2].equals(marker)&&board[0][1].equals(marker)&&board[0][0].equals("[ ]")){
            return "q";
        }
        else if(board[0][0].equals(marker)&&board[0][2].equals(marker)&&board[0][1].equals("[ ]")){
            return "w";
        }
        else if(board[0][0].equals(marker)&&board[0][1].equals(marker)&&board[0][2].equals("[ ]")){
            return "e";
        }
        else if(board[1][1].equals(marker)&&board[1][2].equals(marker)&&board[1][0].equals("[ ]")){
            return "a";
        }
        else if(board[1][0].equals(marker)&&board[1][2].equals(marker)&&board[1][1].equals("[ ]")){
            return "s";
        }
        else if(board[1][0].equals(marker)&&board[1][1].equals(marker)&&board[1][2].equals("[ ]")){
            return "d";
        }
        else if(board[2][1].equals(marker)&&board[2][2].equals(marker)&&board[2][0].equals("[ ]")){
            return "z";
        }
        else if(board[2][0].equals(marker)&&board[2][2].equals(marker)&&board[2][1].equals("[ ]")){
            return "x";
        }
        else if(board[2][0].equals(marker)&&board[2][1].equals(marker)&&board[2][2].equals("[ ]")){
            return "c";
        }
        else {
            return "invalid";
        }
    }
    public String botVerticalMove(String marker){
        if(board[1][0].equals(marker)&&board[2][0].equals(marker)&&board[0][0].equals("[ ]")){
            return "q";
        }
        else if(board[1][1].equals(marker)&&board[2][1].equals(marker)&&board[0][1].equals("[ ]")){
            return "w";
        }
        else if(board[2][1].equals(marker)&&board[2][2].equals(marker)&&board[0][2].equals("[ ]")){
            return "e";
        }
        else if(board[0][0].equals(marker)&&board[2][0].equals(marker)&&board[1][0].equals("[ ]")){
            return "a";
        }
        else if(board[0][1].equals(marker)&&board[2][1].equals(marker)&&board[1][1].equals("[ ]")){
            return "s";
        }
        else if(board[0][2].equals(marker)&&board[2][2].equals(marker)&&board[1][2].equals("[ ]")){
            return "d";
        }
        else if(board[0][0].equals(marker)&&board[1][0].equals(marker)&&board[2][0].equals("[ ]")){
            return "z";
        }
        else if(board[1][1].equals(marker)&&board[0][1].equals(marker)&&board[2][1].equals("[ ]")){
            return "x";
        }
        else if(board[0][2].equals(marker)&&board[1][2].equals(marker)&&board[2][2].equals("[ ]")){
            return "c";
        }
        else {
            return "invalid";
        }
    }
    public String botMove(String marker){
        if(!botDiagonalMove(marker).equals("invalid")){
            return botDiagonalMove(marker);
        }
        else if(!botVerticalMove(marker).equals("invalid")){
            return botVerticalMove(marker);
        }
        else if(!botAcrossMove(marker).equals("invalid")){
            return botAcrossMove(marker);
        }
        else{
            return "invalid";
        }
    }
}
