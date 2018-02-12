package tic.tac.toe;
import java.util.*;
public class TicTacToe {
    public static void main(String[] args) {
        boolean end = false, twoPlayer = false;
        int[][] board = new int[3][3];
        int g = 3;
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = g;
                g++;
            }
        }
        Scanner sc = new Scanner(System.in);
        int numPlayers = 0;
        System.out.println("One or Two players? [1/2]: ");
        while(numPlayers != 1 && numPlayers != 2){
            numPlayers = sc.nextInt();
            if(numPlayers != 1 && numPlayers != 2){
                System.out.println("I'm sorry, that was not an option. Please try again.");
            }
        }
        if(numPlayers == 2){
            twoPlayer = true;
        }
        while(!end){
            System.out.println("You are X's. Where would you like to go?: ");
            System.out.println("  1 2 3");
            System.out.println("1 _|_|_");
            System.out.println("2 _|_|_");
            System.out.println("3  | | ");
            boolean move = false;
            while(!move){
                System.out.println("What row: ");
                int col = (sc.nextInt() - 1);
                System.out.println("What column: ");
                int row = (sc.nextInt() - 1);
                if(board[col][row] == 1 || board[col][row] == 0){
                    System.out.println("Sorry, that space is taken, please try again.");
                }
                else{
                    board[col][row] = 1;
                    move = true;
                }
            }
            display(board);
            if(checkWin(board) == 1){
                System.out.println("CONGRATS PLAYER! YOU WIN!");
                end = true;
            }
            if(!end){
                if(!twoPlayer){
                    Random ran = new Random();
                    boolean omove = false;
                    System.out.println("Opponent's Move: ");
                    while(!omove){
                        int oX = ran.nextInt(3);
                        int oY = ran.nextInt(3);
                        if(board[oX][oY] != 1 && board[oX][oY] != 0){
                            board[oX][oY] = 0;
                            omove = true;
                        }
                    }
                }
                else{
                    System.out.println("You are O's. Where would you like to go?: ");
                    System.out.println("  1 2 3");
                    System.out.println("1 _|_|_");
                    System.out.println("2 _|_|_");
                    System.out.println("3  | | ");
                    move = false;
                    while(!move){
                        System.out.println("What row: ");
                        int col = (sc.nextInt() - 1);
                        System.out.println("What column: ");
                        int row = (sc.nextInt() - 1);
                        if(board[col][row] == 1 || board[col][row] == 0){
                            System.out.println("Sorry, that space is taken, please try again.");
                        }
                        else{
                            board[col][row] = 0;
                            move = true;
                        }
                    }
                }
                display(board);
                if(checkWin(board) == 1){
                    System.out.println("BETTER LUCK NEXT TIME!");
                    end = true;
                }
            }
        }
    }
    public static void display(int[][] board){
        for(int colind = 0; colind < 3; colind++){
            String out = "";
            for(int rowind = 0; rowind < 3; rowind++){
                switch(board[colind][rowind]){
                    case 1:{
                        out += "X";
                        break;
                    }
                    case 0:{
                        out += "O";
                        break;
                    }
                    default:{
                        out += " ";
                        break;
                    }
                }
                if(rowind < 2){
                    out += "|";
                }
            }
            System.out.println(""+out+"");
            if(colind < 2){
                System.out.println("_ _ _");
            }
            out = "";
        }
    }
    public static int checkWin(int[][] board){
        if(board[0][0] == board[0][1] && board[0][1] == board[0][2]){
            return 1;
        }
        else if(board[1][0] == board[1][1] && board[1][1] == board[1][2]){
            return 1;
        }
        else if(board[2][0] == board[2][1] && board[2][1] == board[2][2]){
            return 1;
        }
        else if(board[0][0] == board[1][0] && board[1][0] == board[2][0]){
            return 1;
        }
        else if(board[0][1] == board[1][1] && board[1][1] == board[2][1]){
            return 1;
        }
        else if(board[0][2] == board[1][2] && board[1][2] == board[2][2]){
            return 1;
        }
        else if(board[0][0] == board[1][1] && board[1][1] == board[2][2]){
            return 1;
        }
        else if(board[0][2] == board[1][1] && board[1][1] == board[2][0]){
            return 1;
        }
        return 0;
    }
}
