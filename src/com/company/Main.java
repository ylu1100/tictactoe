package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        System.out.println("This is a text based tictactoe game");
        System.out.println("Please enter the corresponding key to your desired move");
        System.out.println("[q][w][e]\n[a][s][d]\n[z][x][c]");
        Scanner gamemode = new Scanner(System.in);
        String strMode;
        System.out.println("Would you like to play 'pve' or 'pvp' or watch 'botvbot'");
        boolean gamestart=false;
        strMode=gamemode.nextLine();
        if(strMode.equals("pve") || strMode.equals("pvp") || strMode.equals("botvbot")){
            gamestart=true;
        }
        while(!gamestart){
            System.out.println("Invalid game mode");
            strMode=gamemode.nextLine();
            if((strMode.equals("pve") || strMode.equals("pvp")|| strMode.equals("botvbot"))){
                gamestart=true;
            }
        }
         tttoe game =new tttoe(strMode);
         game.displayresult();
    }
}
