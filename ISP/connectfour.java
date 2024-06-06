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
    private JLabel text1;
    private JLabel text2;
    private JLabel text3;
    private JLabel text4;

    Font font1 = new Font("Display", Font.BOLD, 50);
    Font font2 = new Font("Display", Font.BOLD, 30);
    JPanel menuPanel; 
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
        menuPanel = (JPanel) getContentPane();
        menuPanel.setLayout(new GridLayout(8, 1));

        // Adding components with proper sizing
        menuPanel.add(new JPanel()); // spacer
        menuPanel.add(menuTitle);
        menuPanel.add(menuText);
        menuPanel.add(new JPanel()); // spacer

        // Adding buttons inside panels to enforce size
        JPanel startPanel = new JPanel();
        startPanel.add(startButton);
        menuPanel.add(startPanel);

        
        howToPanel = new JPanel();
        howToPanel.add(howToButton);
        menuPanel.add(howToPanel);

        scoreboardPanel = new JPanel();
        scoreboardPanel.add(scoreboardButton);
        menuPanel.add(scoreboardPanel);

        menuPanel.add(new JPanel()); // spacer


        // howto panel ----------------------------
        //how to title
        howToTitle = new JLabel("How To Play CONNECT 4");
        howToTitle.setFont(font1);
        howToTitle.setHorizontalAlignment(JLabel.CENTER);

        text1 = new JLabel("OBJECTIVE");
        text1.setFont(font2);
        text1.setHorizontalAlignment(JLabel.CENTER);

        text2 = new JLabel("SETUP");
        text2.setFont(font2);
        text2.setHorizontalAlignment(JLabel.CENTER);

        text3 = new JLabel("GAMEPLAY");
        text3.setFont(font2);
        text3.setHorizontalAlignment(JLabel.CENTER);

        text4 = new JLabel("HOW TO WIN");
        text4.setFont(font2);
        text4.setHorizontalAlignment(JLabel.CENTER);


        //establish panel
        howToPanel = new JPanel();
        howToPanel.setLayout(new BorderLayout());

        //spacers
        howToPanel.add(new JPanel(), BorderLayout.NORTH);
        howToPanel.add(new JPanel(), BorderLayout.WEST);
        howToPanel.add(new JPanel(), BorderLayout.EAST);
        howToPanel.add(new JPanel(), BorderLayout.SOUTH);

        howToPanel.add(howToTitle, BorderLayout.NORTH);

        howToPanel.add(text1, BorderLayout.CENTER);
        howToPanel.add(new JLabel("Connect four of your colored game pieces in a row, either horizontally, vertically, or diagonally."), BorderLayout.CENTER);
        howToPanel.add(text2, BorderLayout.CENTER);
        howToPanel.add(new JLabel("The game board consists of a 7x6 grid. Each player chooses a color and receives 21 game pieces"), BorderLayout.CENTER);
        howToPanel.add(text3, BorderLayout.CENTER);
        howToPanel.add(new JLabel("On their turn, a player clicks and places one of their game pieces into any open column on the board."), BorderLayout.CENTER);
        howToPanel.add(new JLabel("The game piece falls to the lowest available space in the column."), BorderLayout.CENTER);
        howToPanel.add(text4, BorderLayout.CENTER);
        howToPanel.add(new JLabel("Players alternate turns until one player wins by connecting four of their game pieces in a row. "), BorderLayout.CENTER);
        howToPanel.add(new JLabel("If the board is filled without either player connecting four of their game pieces, the game ends in a draw."), BorderLayout.CENTER);
        //pack();
        setVisible(true);
        menuPanel.setVisible(true);
        howToPanel.setVisible(false);

    }

    public void actionPerformed(ActionEvent e) {
        // if How-To is clicked
        if (e.getActionCommand().equals("How-To")) {
            menuPanel.setVisible(false);
            howToPanel.setVisible(true);
            // Show howToPanel or other actions
        }
    }
}