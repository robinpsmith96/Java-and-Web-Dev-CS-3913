package buttons;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Buttons {
    static JButton jb;
    static int numButtons = 8;
    
    public static void main(String[] args) {
        JFrame jf = new JFrame("The Magnificient Color Changing Buttons!");
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(600, 600);
        jf.setResizable(false);
        jf.setVisible(true);
        ArrayList<JButton> butts = new ArrayList<JButton>();
        for (int h = 0; h < numButtons; h++){
            butts.add(jb = new JButton("" + (int)(h + 1)));
            jf.add(jb);
        }
        int col = (int) Math.sqrt((double) numButtons);
        jf.setLayout(new GridLayout((numButtons / col), col));
    }
}
