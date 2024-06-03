import java.awt.*;
import java.awt.event.*;
//import java.awt.event.WindowEvent;

import javax.swing.*;

public class graphicsDemo2 {
    public static void main (String [] args){
        //Create Frame
        JFrame frame = new JFrame("Graphics");
        
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e){
                System.exit(0); 
                    }//closes window closing
                }//close adaptor
            ); //Close window listener 
            
        frame.setSize(200,200);
        JPanel pane = (JPanel) frame.getContentPane();
        pane.add(new Picture(), BorderLayout.CENTER);
        frame.setVisible(true);
        }
}

class Picture extends JComponent{
    public Picture() {
        repaint();
    }
    public void paint (Graphics g) {
        g.setColor(Color.green);
        g.fillOval(30, 30, 40, 40);
        g.setColor(Color.yellow);
        g.fillOval(35, 35, 30, 30);
        g.setColor(Color.orange);
        g.fillOval(40, 40, 20, 20);
        g.setColor(Color.red);
        g.fillOval(45, 45, 10, 10);
    }
}