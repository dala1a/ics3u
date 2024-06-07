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
        //change logo
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class Frame extends JFrame implements ActionListener {
    //menu vars
    JPanel menuPanel, howToPanel, scoreboardPanel, TheOneAndOnlyMainPanel; 
    private JLabel menuTitle, menuText;
    private JButton startButton, howToButton, scoreboardButton;

    //how to panel vars
    private JLabel howToTitle, text1, text2, text3, text4;
    private JPanel returnPanel;
    private JButton returnButton1;

    //player settings vars
    private JButton returnButton2, playButton;
    private JPanel playerSettings, settingsTitlePanel, settingsLayout, enterName1, enterName2, chooseColor1, chooseColor2, color1, color2, colorbox1, colorbox2, playPanel, playBtnPanel;
    private JLabel settingsTitle;
    private JTextField player1, player2;
  
    private String[] choices1 = {"Red", "Orange", "Yellow", "Green", "Blue", "Black"};
    private String[] choices2 = {"Blue", "Orange", "Yellow", "Green", "Red", "Black"};
    private JComboBox<String> colorChoice1 = new JComboBox<String>(choices1);
    private JComboBox<String> colorChoice2 = new JComboBox<String>(choices2);

    Font font1 = new Font("Display", Font.BOLD, 50);
    Font font2 = new Font("Display", Font.BOLD, 30);

    // Constructor
    public Frame() {
        // menu panel ------------------------------------------------------------------------------
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
        
        // establish menu panel
        menuPanel = new JPanel();
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


        // howto panel --------------------------------------------------------------------------
        //how to vars
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

        returnButton1 = new JButton("<");
        returnButton1.setPreferredSize(new Dimension(50, 50));
        returnButton1.addActionListener(this);


        //establish how to panel
        howToPanel = new JPanel();
        howToPanel.setLayout(new GridLayout(15,0));

        //return button
        returnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        returnPanel.add(returnButton1);
        
        // Adding components with proper sizing
        howToPanel.add(returnPanel);
        howToPanel.add(new JPanel());
        howToPanel.add(howToTitle);
        howToPanel.add(new JPanel());
        howToPanel.add(text1);
        howToPanel.add(new JLabel("Connect four of your colored game pieces in a row, either horizontally, vertically, or diagonally.", JLabel.CENTER));
        howToPanel.add(text2);
        howToPanel.add(new JLabel("The game board consists of a 7x6 grid. Each player chooses a color and receives 21 game pieces.", JLabel.CENTER));
        howToPanel.add(text3);
        howToPanel.add(new JLabel("On their turn, a player clicks and places one of their game pieces into any open column on the board. ", JLabel.CENTER));
        howToPanel.add(new JLabel("The game piece falls to the lowest available space in the column.", JLabel.CENTER));
        howToPanel.add(text4);
        howToPanel.add(new JLabel("Players alternate turns until one player wins by connecting four of their game pieces in a row. ", JLabel.CENTER));
        howToPanel.add(new JLabel("If the board is filled without either player connecting four of their game pieces, the game ends in a draw.", JLabel.CENTER));
        howToPanel.add(new JPanel());
        

        //Start panel -------------------------------------------------------------------------
       
        //CHOOSE A COLOR & NAME FOR PLAYERS
        //vars
        
        settingsTitlePanel = new JPanel(new BorderLayout());
        returnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        returnButton2 = new JButton("<");
        returnButton2.setPreferredSize(new Dimension(50, 50));
        returnButton2.addActionListener(this);
        returnPanel.add(returnButton2);

        settingsTitlePanel.add(returnPanel, BorderLayout.NORTH);
        settingsTitle = new JLabel("Player Setup");
        settingsTitle.setFont(font1);
        settingsTitle.setHorizontalAlignment(JLabel.CENTER);
        settingsTitlePanel.add(settingsTitle, BorderLayout.CENTER);

        player1 = new JTextField();
        player1.addActionListener(this);
        player2 = new JTextField();
        player2.addActionListener(this);
        settingsLayout = new JPanel(new GridLayout(4,2));
        enterName1 = new JPanel(new GridLayout(1,2));
        enterName2 = new JPanel(new GridLayout(1,2));
        chooseColor1 = new JPanel(new GridLayout(1,2));
        chooseColor2 = new JPanel(new GridLayout(1,2));
        

        enterName1.add(new JLabel("Enter Name:", JLabel.CENTER));
        enterName1.add(player1);

        enterName2.add(new JLabel("Enter Name:", JLabel.CENTER));
        enterName2.add(player2);

        chooseColor1.add(new JLabel("Choose Color:", JLabel.CENTER));
        chooseColor1.add(colorChoice1);

        chooseColor2.add(new JLabel("Choose Color:", JLabel.CENTER));
        chooseColor2.add(colorChoice2);

        color1 = new JPanel();
        color1.setBackground(Color.RED);
        
        colorbox1 = new JPanel(new GridLayout(1,2));
        colorbox1.add(new JPanel());
        colorbox1.add(color1);
        //colorbox1.add(new JPanel());

        color2 = new JPanel();
        color2.setBackground(Color.BLUE);
        
        colorbox2 = new JPanel(new GridLayout(1,2));
        colorbox2.add(new JPanel());
        colorbox2.add(color2);
        //colorbox2.add(new JPanel());

        playButton = new JButton("PLAY");
        playButton.setPreferredSize(new Dimension(250, 50));
        playButton.addActionListener(this);

        playBtnPanel = new JPanel();
        playBtnPanel.add(playButton);

        playPanel = new JPanel(new GridLayout(3,1));
        playPanel.add(new JPanel());
        playPanel.add(playBtnPanel);
        playPanel.add(new JPanel());
      

        settingsLayout.add(new JLabel("Player 1", JLabel.CENTER));
        settingsLayout.add(new JLabel("Player 2", JLabel.CENTER));
        settingsLayout.add(enterName1);
        settingsLayout.add(enterName2);
        settingsLayout.add(chooseColor1);
        settingsLayout.add(chooseColor2);
        settingsLayout.add(colorbox1);
        settingsLayout.add(colorbox2);


        playerSettings = new JPanel();
        playerSettings.setLayout(new GridLayout(3,1));
        
        

        //add components
        playerSettings.add(settingsTitlePanel);
        playerSettings.add(settingsLayout);
        playerSettings.add(playPanel);


        //pack();
        this.add(menuPanel); 
        TheOneAndOnlyMainPanel = menuPanel; // Making a variable to store what the main panel currently is. 
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // if How-To Button is clicked
        //System.out.println(TheOneAndOnlyMainPanel.toString());
        if (e.getActionCommand().equals("How-To")) {
            switchPanels(howToPanel);
        }

        if (e.getActionCommand().equals("<")) {
            switchPanels(menuPanel);
        }

        if (e.getActionCommand().equals("Start")) {
            switchPanels(playerSettings);
        }

        if (e.getActionCommand().equals("PLAY")) {
            String p1 = player1.getText().trim(); 
            String p2 = player2.getText().trim(); 
            if (p1.equalsIgnoreCase(p2)){
                
            }
        }
    }


    public void refresh(){
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }
    // Made this new method to be able to switch out panels. 
    /**
     * make sure to call this method whenever u switch lol otherwise it might mess things up. You can hardcode this if u want 
     * but i made a method for it so its easier. You can ask me if you dont get this
     * @param newPanel The Panel that you want to insert or i guess the panel u are changing it to
     */
    public void switchPanels(JPanel newPanel) { 
        this.getContentPane().remove(TheOneAndOnlyMainPanel);
        this.getContentPane().add(newPanel); 
        refresh();
        TheOneAndOnlyMainPanel = newPanel; // Updating the main panel to whatever u are changing it to XD kekw uwu
    }
}
