import java.awt.*;
import javax.swing.*;

public class graphicsDemo {
    public static void main (String [] args){
    //Create Frame
    JFrame frame = new JFrame("New Hello World");
    frame.setSize(400,100);
    JPanel pane = (JPanel) frame.getContentPane();
    pane.add(new GUIHelloWorld());
    frame.setVisible(true);
    int sum = 0 ;
    int j = -5 ;
    while ( sum <= 350 )
    {
    sum += j ;
    j += 5 ;
    }
    System.out.println(sum + " " + j);
    }
}
//Create child of JComponent
    class GUIHelloWorld extends JComponent {
        public GUIHelloWorld() {
            repaint();
        }
        public void paint(Graphics g){
            Font MyFontTitle = new Font("Serif", Font.PLAIN, 35);
            g.setFont(MyFontTitle);
            g.drawString("Hello World!", 50, 50);
        }
    }

