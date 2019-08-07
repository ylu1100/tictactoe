package com.company;

public class tttoe {
    private String[][]board;
    public tttoe(){
        board=new String[3][3];
    }

    public void playermove(String marker,int row,int col){
        board[row][col]=marker;
    }
    public String convertkeytocoord(String key){
        if(key.equals("q")&&board[0][0]=="[ ]"){
            return "0,0";
        }
        if(key.equals("w")&&board[0][1]=="[ ]"){
            return "0,1";
        }
        if(key.equals("e")&&board[0][2]=="[ ]"){
            return "0,2";
        }
        if(key.equals("a")&&board[1][0]=="[ ]"){
            return "1,0";
        }
        if(key.equals("s")&&board[1][1]=="[ ]"){
            return "1,1";
        }
        if(key.equals("d")&&board[1][2]=="[ ]"){
            return "1,2";
        }
        if(key.equals("z")&&board[2][0]=="[ ]"){
            return "2,0";
        }
        if(key.equals("x")&&board[2][1]=="[ ]"){
            return "2,1";
        }
        if(key.equals("c")&&board[2][2]=="[ ]"){
            return "2,2";
        }
        else{
            return "invalid";
        }
    }

    public void reset(){
        for(int x = 0; x<board.length;x++){
            for(int y = 0;y<board[0].length;y++){
                board[x][y]="[ ]";
            }
        }
    }

    public String[][] getBoard() {
        return board;
    }

    public boolean winacross(String marker){
        if(board[0][0]==marker&&board[1][0]==marker&&board[2][0]==marker){
            return true;
        }
        else if(board[0][1]==marker&&board[1][1]==marker&&board[2][1]==marker){
            return true;
        }
        else if(board[0][2]==marker&&board[1][2]==marker&&board[2][2]==marker){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean winvertical(String marker){
        if(board[0][0]==marker&&board[0][1]==marker&&board[0][2]==marker){
            return true;
        }
        else if(board[1][0]==marker&&board[1][1]==marker&&board[1][2]==marker){
            return true;
        }
        else if(board[2][0]==marker&&board[2][1]==marker&&board[2][2]==marker){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean windiagonal(String marker){
        if(board[0][0]==marker&&board[1][1]==marker&&board[2][2]==marker){
            return true;
        }
        else if(board[2][0]==marker&&board[1][1]==marker&&board[0][2]==marker){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean xwin(){
        if(winacross("[X]")==true){
            return true;
        }
        else if(winvertical("[X]")==true){
            return true;
        }
        else if (windiagonal("[X]")==true){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean owin(){
        if(winacross("[O]")==true){
            return true;
        }
        else if(winvertical("[O]")==true){
            return true;
        }
        else if (windiagonal("[O]")==true){
            return true;
        }
        else{
            return false;
        }
    }
    public boolean tie(){
        boolean tie=true;
        for(int x = 0;x<board.length;x++){
            for(int y = 0;y<board[x].length;y++){
                if(board[x][y]=="[ ]"){
                    tie=false;
                }
            }
        }
        return tie;
    }
    public boolean gameover(){
        if(xwin()==true||owin()==true||tie()==true){
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


}
