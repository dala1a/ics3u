import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class connectfour {
    public static void main(String[] args) {
        Frame frame = new Frame();
        frame.setSize(700, 1200); // Set initial window size
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setTitle("CONNECT 4");
        frame.setUndecorated(true);
        //cahnge logo
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class Frame extends JFrame implements ActionListener {
    private JLabel menuTitle;
    private JLabel menuText;
    private JButton startButton;
    private JButton howToButton;
    private JButton scoreboardButton;

    private JLabel howToTitle;

    Font font1 = new Font("Display", Font.BOLD, 50);
    Font font2 = new Font("Display", Font.BOLD, 30);
    JPanel menu; 
    JPanel howToPanel; 
    JPanel scoreboardPanel; 

    // Constructor
    public Frame() {
        // menu panel ---------------
        // title
        menuTitle = new JLabel("CONNECT 4");
        menuTitle.setFont(font1);
        menuTitle.setHorizontalAlignment(JLabel.CENTER);

        // menuText
        menuText = new JLabel("MENU");
        menuText.setFont(font2);
        menuText.setHorizontalAlignment(JLabel.CENTER);

        // start button
        startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(400, 90));
        startButton.addActionListener(this);

        // howTo button
        howToButton = new JButton("How-To");
        howToButton.setPreferredSize(new Dimension(400, 90));
        howToButton.addActionListener(this);

        // scoreboard button
        scoreboardButton = new JButton("Scoreboard");
        scoreboardButton.setPreferredSize(new Dimension(400, 90));
        scoreboardButton.addActionListener(this);
        
        // menu panel
        menu = (JPanel) getContentPane();
        menu.setLayout(new GridLayout(8, 1));

        // Adding components with proper sizing
        menu.add(new JPanel()); // spacer
        menu.add(menuTitle);
        menu.add(menuText);
        menu.add(new JPanel()); // spacer

        // Adding buttons inside panels to enforce size
        JPanel startPanel = new JPanel();
        startPanel.add(startButton);
        menu.add(startPanel);

        JPanel howToPanel = new JPanel();
        howToPanel.add(howToButton);
        menu.add(howToPanel);

        JPanel scoreboardPanel = new JPanel();
        scoreboardPanel.add(scoreboardButton);
        menu.add(scoreboardPanel);

        menu.add(new JPanel()); // spacer

        //pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // if How-To is clicked
        if (e.getActionCommand().equals("How-To")) {
            menu.setVisible(false);
            // Show howToPanel or other actions
        }
    }
}
