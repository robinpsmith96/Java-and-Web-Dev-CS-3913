//Keaton Smith kps325

package buttons;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Buttons {
    static JButton jb;                                                          //Creates our first button
    static int numButtons = 8;                                                  //Sets the number of buttons we will display
    
    public static void main(String[] args) {
        JFrame jf = new JFrame("The Magnificient Color Changing Buttons!");     //Titles our window
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                      //Tells the window when to close
        jf.setSize(600, 600);                                                   //Sets the size of the window to 600x600 pixels
        jf.setResizable(false);                                                 //Disallows resizing the window
        jf.setVisible(true);                                                    //Makes the window visible
        ArrayList<JButton> butts = new ArrayList<JButton>();                    //Creates an arraylist of buttons named butts because I am a child
        for (int h = 0; h < numButtons; h++){                                   //Fills butts with a number buttons equal to the amount from the beginning
            butts.add(jb = new JButton("" + (int)(h + 1)));                     //Offset the number by one because we start counting at 0
            jf.add(jb);         
        }
        int col = (int) Math.sqrt((double) numButtons);                         //Gets the square root of the number of buttons
        jf.setLayout(new GridLayout((numButtons / col), col));                  //Tells the window to display the number of buttons in a grid based on the sqaure root from the previous line and the number of buttons
        for(JButton b : butts){                                                 //This loop goes and gives each button a random color
            Random ran = new Random();
            int r, g, bl;
            r = ran.nextInt(255);
            g = ran.nextInt(255);
            bl = ran.nextInt(255);
            b.setBackground(new Color(r, g, bl));
            b.setOpaque(true);
            b.setBorderPainted(false);
            b.addActionListener(new ButtonPress(butts, b));                     //Gives each button something to do if it gets clicked
        }
    }
}

class ButtonPress implements ActionListener{                                    //What the buttons do if they get clicked
    ArrayList<JButton> butts;                                                   //Still a child
    JButton selected;                                                           
    ButtonPress(ArrayList<JButton> buttons, JButton selection){                 //Creates a copy of the pointer passed in by the button that points to the arraylist and of the pointer that points to the clicked button
        butts = buttons;                                                        //Child check: Success
        selected = selection;
    }
    @Override                                                                   //The compiler yelled at me to add this
    public void actionPerformed(ActionEvent event){                             //What the button does when it gets clicked
        for(JButton b : butts){                                                 //Runs through the arraylist and randomly changes the color of all buttons but the one we selected
            if(b != selected){
                Random ran = new Random();
                int r, g, bl;                                                   //bl is called that and not b because I had already used b in the for loop
                r = ran.nextInt(255);
                g = ran.nextInt(255);
                bl = ran.nextInt(255);
                b.setBackground(new Color(r, g, bl));
            }
        }
    }
}
