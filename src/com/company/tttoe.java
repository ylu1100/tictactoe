package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class tttoe {
    private String[][]board;
    private String key;
    private boolean gamestart;
    private int turn;
    private int rowpos;
    private int colpos;
    private Scanner position;
    private String pos;
    private ArrayList<String>availablemoves;
    public tttoe(String mode)throws InterruptedException {
        board=new String[3][3];
        gamestart=false;
        turn=1;
        availablemoves=new ArrayList<>();
        pveAddMoves(availablemoves);
        position = new Scanner(System.in);
        reset();
        if (mode.equals("pve")) {
            pveMode();
        }
        else  if(mode.equals("pvp")){
            pvpmode();
        }
        else{
            botvbot();
        }
    }
    public void displayresult(){
        if(win("[X]")){
            System.out.println(printBoard());
            System.out.println("Player X wins");

        }
        else if(win("[O]")){
            System.out.println(printBoard());
            System.out.println("Player O wins");
        }
        else{
            System.out.println(printBoard());
            System.out.println("It's a draw");

        }
    }
    public void pveMode() {
        while (!gameover()) {
            System.out.println();
            System.out.println(printBoard());
            System.out.println("You are Player X");
            if (turn % 2 != 0) {
                System.out.println("Your turn");
                key = position.nextLine();
                pos = convertkeytocoord(key);
                while (pos.equals("invalid")) {
                    System.out.println(printBoard());
                    System.out.println("Please enter a valid move");
                    key = position.nextLine();
                    pos = convertkeytocoord(key);
                }
                availablemoves.remove(key);
                rowpos = Integer.valueOf(pos.substring(0, 1));
                colpos = Integer.valueOf(pos.substring(2));
                playermove("[X]", rowpos, colpos);
            } else {
                key = botMove("[O]"); //bot finds winning move if possible
                if (key.equals("invalid")) {
                    key = botMove("[X]");   //prevents winning move from the player
                }
                if (key.equals("invalid")) {
                    key = availablemoves.get((int) (Math.random() * availablemoves.size()));
                }//chooses a random available move
                availablemoves.remove(key);
                pos = convertkeytocoord(key);
                rowpos = Integer.valueOf(pos.substring(0, 1));
                colpos = Integer.valueOf(pos.substring(2));
                playermove("[O]", rowpos, colpos);
            }
            turn++;
        }
    }

    public void pvpmode() {
        while (!gameover()) {
            System.out.println();
            System.out.println(printBoard());
            if (turn % 2 != 0) {
                System.out.println("Player X's turn");
                pos = convertkeytocoord(position.nextLine());
                while (pos.equals("invalid")) {
                    System.out.println(printBoard());
                    System.out.println("Please enter a valid move");
                    pos = convertkeytocoord(position.nextLine());
                }

                rowpos = Integer.valueOf(pos.substring(0, 1));
                colpos = Integer.valueOf(pos.substring(2));
                playermove("[X]", rowpos, colpos);
            } else {
                System.out.println("Player O's turn");
                pos = convertkeytocoord(position.nextLine());
                while (pos.equals("invalid")) {
                    System.out.println(printBoard());
                    System.out.println("Please enter a valid move");
                    pos = convertkeytocoord(position.nextLine());
                }
                rowpos = Integer.valueOf(pos.substring(0, 1));
                colpos = Integer.valueOf(pos.substring(2));

                playermove("[O]", rowpos, colpos);

            }
            turn++;
        }
    }
    public void botvbot() throws InterruptedException {
        while (!gameover()) {
            System.out.println();
            System.out.println(printBoard());
            if (turn % 2 != 0) {
                Thread.sleep(1000);
                System.out.println("BOT X's turn");
                key = botMove("[X]"); //bot finds winning move if possible
                if (key.equals("invalid")) {
                    key = botMove("[O]");   //prevents winning move from the opponent
                }
                if (key.equals("invalid")) {
                    key = availablemoves.get((int) (Math.random() * availablemoves.size()));
                }//chooses a random available move
                availablemoves.remove(key);
                pos = convertkeytocoord(key);
                rowpos = Integer.valueOf(pos.substring(0, 1));
                colpos = Integer.valueOf(pos.substring(2));
                playermove("[X]", rowpos, colpos);
            } else {
                Thread.sleep(1000);
                System.out.println("BOT O's turn");
                key = botMove("[O]"); //bot finds winning move if possible
                if (key.equals("invalid")) {
                    key = botMove("[X]");   //prevents winning move from the opponent
                }
                if (key.equals("invalid")) {
                    key = availablemoves.get((int) (Math.random() * availablemoves.size()));
                }//chooses a random available move
                availablemoves.remove(key);
                pos = convertkeytocoord(key);
                rowpos = Integer.valueOf(pos.substring(0, 1));
                colpos = Integer.valueOf(pos.substring(2));
                playermove("[O]", rowpos, colpos);
            }
            turn++;
        }
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
