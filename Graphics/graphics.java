import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class graphics {
    public static void main(String[] args) {
        NameFrame frame = new NameFrame();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }


    
}
