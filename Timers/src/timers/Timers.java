package timers;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
public class Timers {
    public static void main(String[] args) {
        JFrame jf = new JFrame("My program!");
        jf.setSize(400,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        MyPanel mp = new MyPanel();
        jf.add(mp);
        jf.setVisible(true);
    }
}

class MyPanel extends JPanel{
    MyPanel(){
        super();
    }
    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        Font f = g.getFont().deriveFont((float) 45);
        g.setFont(f);
        g.fillOval(100, 100, 200, 200);
        g.setColor(Color.WHITE);
        g.fillOval(110, 110, 180, 180);
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.BLACK);
        Rectangle min = new Rectangle(198, 200, 5, 70);
        AffineTransform old = g2.getTransform();
        g2.rotate(Math.toRadians(180), 201, 200);
        g2.draw(min);
        g2.fill(min);
        g2.setTransform(old);
        old = g2.getTransform();
        Rectangle hour = new Rectangle(198, 200, 5, 40);
        g2.rotate(Math.toRadians(180), 201, 200);
        g2.draw(hour);
        g2.fill(hour);
        g2.setTransform(old);
        old = g2.getTransform();
        g2.setColor(Color.RED);
        Rectangle sec = new Rectangle(199, 200, 2, 65);
        g2.rotate(Math.toRadians(180), 201, 200);
        g2.draw(sec);
        g2.fill(sec);
        g2.setTransform(old);
    }
}