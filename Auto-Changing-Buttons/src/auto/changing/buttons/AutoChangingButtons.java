//Keaton Smith kps325

package auto.changing.buttons;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class MyButton extends JButton{                                                 //My version of JButton that contains a thread
    boolean pressed;                                                            //To know if the user pressed the button or not
    ButtThread thr;                                                             //The thread. Yes I know I'm a child.
    MyButton(String name){                                                      //Give each button its thread and set pressed to false.
        pressed = false;
        thr = new ButtThread(this);
    }
}

class ButtThread extends Thread{                                                //My version of thread that contains buttons
    MyButton mb;
    ButtThread(MyButton b){                                                     //Tell each thread which button it's paired with.
        mb = b;
    }
    @Override
    public void run(){                                                          //What the thread does.
        while(true){
            try{
                sleep(1000);                                                    //Make the buttons change once per second.
                if(!mb.pressed){                                                //If not pressed then randomly change the color.
                    Random r = new Random();
                    int a = r.nextInt(255);
                    int b = r.nextInt(255);
                    int c = r.nextInt(255);
                    mb.setBackground(new Color(a, b, c));
                }
                if(mb.pressed){                                                 //If pressed then wait a second
                    Thread.sleep(1000);
                }
            }catch(Exception e){}
        }
    }
}

public class AutoChangingButtons {
    static MyButton jb;                                                          //Creates our first button
    static int numButtons = 16;                                                  //Sets the number of buttons we will display
    
    public static void main(String[] args) {
        JFrame jf = new JFrame("The Automatic Color Changing Buttons!");        //Titles our window
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                      //Tells the window when to close
        jf.setSize(600, 600);                                                   //Sets the size of the window to 600x600 pixels
        jf.setResizable(false);                                                 //Disallows resizing the window
        jf.setVisible(true);                                                    //Makes the window visible
        ArrayList<MyButton> butts = new ArrayList<MyButton>();                  //Creates an arraylist of buttons named butts because I am a child
        for (int h = 0; h < numButtons; h++){                                   //Fills butts with a number buttons equal to the amount from the beginning
            butts.add(jb = new MyButton("" + (int)(h + 1)));                    //Offset the number by one because we start counting at 0
            jf.add(jb);         
        }
        int col = (int) Math.sqrt((double) numButtons);                         //Gets the square root of the number of buttons
        jf.setLayout(new GridLayout((numButtons / col), col));                  //Tells the window to display the number of buttons in a grid based on the sqaure root from the previous line and the number of buttons
        for(MyButton b : butts){                                                //This loop goes and gives each button a random color
            Random ran = new Random();
            int r, g, bl;
            r = ran.nextInt(255);
            g = ran.nextInt(255);
            bl = ran.nextInt(255);
            b.setBackground(new Color(r, g, bl));
            b.setOpaque(true);
            b.setBorderPainted(false);
            b.addActionListener(new ButtonPress(butts, b));                     //Gives each button something to do if it gets clicked
            b.thr.start();                                                      //Starts each buttons thread
        }
    }
}

class ButtonPress implements ActionListener{                                    //What the buttons do if they get clicked
    ArrayList<MyButton> butts;                                                  //Still a child
    MyButton selected;                                                           
    ButtonPress(ArrayList<MyButton> buttons, MyButton selection){               //Creates a copy of the pointer passed in by the button that points to the arraylist and of the pointer that points to the clicked button
        butts = buttons;                                                        //Child check: Success
        selected = selection;
    }
    @Override                                                                   //The compiler yelled at me to add this
    public void actionPerformed(ActionEvent event){                             //What the button does when it gets clicked
        for(MyButton b : butts){                                                
            if(b == selected){                                                  //A simple switch.
                if(b.pressed){
                    b.pressed = false;
                    return;
                }
                b.pressed = true;
                return;
            }
        }
    }
}
