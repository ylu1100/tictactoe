package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("This is a text based tictactoe game");
        Thread.sleep(1000);
        System.out.println("Please enter the corresponding key to your desired position");
        Thread.sleep(1000);
        System.out.println("[q][w][e]\n[a][s][d]\n[z][x][c]");
        Thread.sleep(1000);
        tttoe game = new tttoe();
        game.reset();
        Scanner position = new Scanner(System.in);
        int mode=0;
        Scanner gamemode = new Scanner(System.in);
        String strMode;
        System.out.println("Would you like to play 'pve' or 'pvp'");
        boolean gamestart=false;
        strMode=gamemode.nextLine();
        if(strMode.equals("pve") || strMode.equals("pvp")){
            gamestart=true;
        }
        while(gamestart==false){
            System.out.println("Invalid game mode");
            strMode=gamemode.nextLine();
            if((strMode.equals("pve") || strMode.equals("pvp"))){
                gamestart=true;
            }
        }
        if (strMode.equals("pve")) {
            mode = 1;
        } else if (strMode.equals("pvp")) {
            mode = 2;
        }
        String pos;
        int rowpos;
        int colpos;
        int turn = 1;
        if(mode==1){
            String key;
            ArrayList<String>availablemoves=new ArrayList<>();
            availablemoves.add("q");
            availablemoves.add("w");
            availablemoves.add("e");
            availablemoves.add("a");
            availablemoves.add("s");
            availablemoves.add("d");
            availablemoves.add("z");
            availablemoves.add("x");
            availablemoves.add("c");
            while(game.gameover()==false){
                System.out.println();
                System.out.println(game.printBoard());
                System.out.println("You are Player X");
                if (turn % 2 != 0) {
                    System.out.println("Your turn");
                    key=position.nextLine();
                    pos = game.convertkeytocoord(key);
                    while (pos == "invalid") {
                        System.out.println("Please enter a valid move");
                        key=position.nextLine();
                        pos = game.convertkeytocoord(key);
                    }
                    availablemoves.remove(key);
                    rowpos = Integer.valueOf(pos.substring(0, 1));
                    colpos = Integer.valueOf(pos.substring(2));
                    game.playermove("[X]", rowpos, colpos);
                }
                else{
                    System.out.println(game.printBoard());
                    key=availablemoves.get((int)(Math.random()*availablemoves.size()));   //chooses a random available move
                    availablemoves.remove(key);
                    pos=game.convertkeytocoord(key);
                    rowpos = Integer.valueOf(pos.substring(0, 1));
                    colpos = Integer.valueOf(pos.substring(2));
                    game.playermove("[O]", rowpos, colpos);
                }
                turn++;
            }
        }
        else
        if (mode == 2){
            while (game.gameover() == false) {
                System.out.println();
                System.out.println(game.printBoard());
                if (turn % 2 != 0) {
                    System.out.println("Player X's turn");
                    pos = game.convertkeytocoord(position.nextLine());
                    while (pos == "invalid") {
                        System.out.println("Please enter a valid move");
                        pos = game.convertkeytocoord(position.nextLine());
                    }

                    rowpos = Integer.valueOf(pos.substring(0, 1));
                    colpos = Integer.valueOf(pos.substring(2));
                    game.playermove("[X]", rowpos, colpos);
                }
                else
                    {
                    System.out.println(game.printBoard());
                    System.out.println("Player O's turn");
                    pos = game.convertkeytocoord(position.nextLine());
                    while (pos == "invalid") {
                        System.out.println("Please enter a valid move");
                        pos = game.convertkeytocoord(position.nextLine());
                    }
                    rowpos = Integer.valueOf(pos.substring(0, 1));
                    colpos = Integer.valueOf(pos.substring(2));

                    game.playermove("[O]", rowpos, colpos);

                }
                turn++;
                // write your code here
            }
    }
        if(game.xwin()==true){
            System.out.println(game.printBoard());
            System.out.println("Player X wins");

        }
        else if(game.owin()==true){
            System.out.println(game.printBoard());
            System.out.println("Player O wins");

        }
        else{
            System.out.println(game.printBoard());
            System.out.println("It's a draw");

        }
    }
}
