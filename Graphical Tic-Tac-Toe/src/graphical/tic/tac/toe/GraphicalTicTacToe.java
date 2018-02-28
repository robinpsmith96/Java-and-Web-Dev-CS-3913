//Keaton Smith kps325

package graphical.tic.tac.toe;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class myButton extends JButton{                                                 //My add on to JButton that gives each button a move
    static int i = 0;                                                           //Give each empty move a unique identifier to help with win checks
    Move m = new Empty(i++);
    void setMove(char c){                                                       //Set the type of move the button takes
        if(c == 'x'){
            m = new X();
        }
        else{
            m = new O();
        }
    }
}

abstract class Move{                                                            //Class is abstract because it doesn't need to hold any data
    abstract char getType();
    abstract Color getColor();
}

class X extends Move{                                                           //The X class
    @Override
    char getType(){
        return 'X';
    }
    @Override
    Color getColor(){
        return new Color(255, 0, 0);
    }
}

class O extends Move{                                                           //The O Class
    @Override
    char getType(){
        return 'O';
    }
    @Override
    Color getColor(){
        return new Color(0, 255, 0);
    }
}

class Empty extends Move{                                                       //Empty square class. The default for evey button.
    int val;
    Empty(int i){
        val = i;
    }
    @Override
    char getType(){
        return (char)val;
    }
    @Override
    Color getColor(){
        return new Color(0, 0, 255);
    }
}

public class GraphicalTicTacToe {
    static myButton jb;
    public static void main(String[] args) {
        JFrame jf = new JFrame("TIC-TAC-TOE, BUT THIS TIME IT'S PRETTY.");      //Titles our window
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                      //Tells the window when to close
        jf.setSize(600, 600);                                                   //Sets the size of the window to 600x600 pixels
        jf.setResizable(false);                                                 //Disallows resizing the window
        jf.setVisible(true);
        myButton[] butts = new myButton[9];                                     //Creates an array of buttons named butts because I am a child
        for (int h = 0; h < butts.length; h++){                                 //Fills butts with 9 empty buttons
            butts[h] = new myButton();                                             
            jf.add(butts[h]);         
        }
        jf.setLayout(new GridLayout(3, 3));                                     //Tells the window to display the number of buttons in a grid based on the sqaure root from the previous line and the number of buttons
        for(myButton b : butts){
            b.setBackground(b.m.getColor());
            b.setOpaque(true);
            b.setBorderPainted(false);
            b.addActionListener(new ButtonPress(butts, b));                     //Gives each button something to do if it gets clicked
        }
    }
}

class ButtonPress implements ActionListener{                                    //What the buttons do if they get clicked
    myButton[] butts;                                                           //Still a child
    myButton selected;   
    static boolean win = false;
    static int moves = 0;
    ButtonPress(myButton[] buttons, myButton selection){                        //Creates a copy of the pointer passed in by the button that points to the arraylist and of the pointer that points to the clicked button
        butts = buttons;                                                        //Child check: Success
        selected = selection;
    }
    @Override                                                                   //The compiler yelled at me to add this
    public void actionPerformed(ActionEvent event){                             //What the button does when it gets clicked
        for(int i = 0; i < butts.length; i++){                                  //Runs through the arraylist and randomly changes the color of all buttons but the one we selected
            if(!win){
                if(butts[i].m.getType() != 'X' && butts[i].m.getType() != 'O' && butts[i] == selected){
                    moves++;
                    if(moves % 2 == 1){                                         //Determine who's move it is.
                        butts[i].setMove('x');
                        butts[i].setBackground(butts[i].m.getColor());
                        if(checkWin(butts) == 1){                               //Check for win.
                            System.out.println("WINNER");
                            win = true;
                        }
                    }
                    else{
                        butts[i].setMove('o');
                        butts[i].setBackground(butts[i].m.getColor());
                        if(checkWin(butts) == 1){
                            System.out.println("WINNER");
                            win = true;
                        }
                    }
                }
            }
        }
        
    }
    
    public int checkWin(myButton[] butts){                                      //Check for win
        if(butts[1].m.getType() == butts[0].m.getType() && butts[0].m.getType() == butts[2].m.getType()){
            return 1;
        }
        else if(butts[3].m.getType() == butts[4].m.getType() && butts[4].m.getType() == butts[5].m.getType()){
            return 1;
        }
        else if(butts[6].m.getType() == butts[7].m.getType() && butts[7].m.getType() == butts[8].m.getType()){
            return 1;
        }
        else if(butts[0].m.getType() == butts[3].m.getType() && butts[3].m.getType() == butts[6].m.getType()){
            return 1;
        }
        else if(butts[1].m.getType() == butts[4].m.getType() && butts[4].m.getType() == butts[7].m.getType()){
            return 1;
        }
        else if(butts[2].m.getType() == butts[5].m.getType() && butts[5].m.getType() == butts[8].m.getType()){
            return 1;
        }
        else if(butts[0].m.getType() == butts[4].m.getType() && butts[4].m.getType() == butts[8].m.getType()){
            return 1;
        }
        else if(butts[2].m.getType() == butts[4].m.getType() && butts[4].m.getType() == butts[6].m.getType()){
            return 1;
        }
        return 0;
    }
}


