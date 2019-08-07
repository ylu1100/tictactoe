package com.company;

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
        String pos;
        String input;
        int rowpos;
        int colpos;
        int turn = 1;
        while (game.gameover() == false) {
            System.out.println();
            System.out.println(game.printBoard());
            if (turn % 2 != 0) {
                System.out.println("Player X's turn");
                    pos = game.convertkeytocoord(position.nextLine());
                    while(pos=="invalid"){
                        System.out.println("Please enter a valid move");
                        pos = game.convertkeytocoord(position.nextLine());
                    }

                rowpos = Integer.valueOf(pos.substring(0, 1));
                colpos = Integer.valueOf(pos.substring(2));
                game.playermove("[X]", rowpos, colpos);
            }
            else {
                System.out.println(game.printBoard());

                    System.out.println("Player O's turn");

                pos = game.convertkeytocoord(position.nextLine());
                while(pos=="invalid"){
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
