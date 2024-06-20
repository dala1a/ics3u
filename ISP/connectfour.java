/*
 * Name: Yunseo Jeon
 * Date: June 19, 2024
 * Description: A CONNECT 4 game with a scoreboard of players who won
 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;

public class connectfour {
    public static void main(String[] args) {
        Frame game = new Frame();   
        ImageIcon logo = new ImageIcon("Logo.png"); //Get the Logo image
        game.setIconImage(logo.getImage()); // Set the Logo for the Frame
        game.setSize(700, 900); // Set initial window size
        game.setResizable(false);  
        game.setLocationRelativeTo(null);  // Make it appear in the middle of the screen
        game.setTitle("CONNECT 4");
        game.addWindowListener(new WindowAdapter() {
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
    private String[] choices1 = {"CHOOSE", "Red", "Orange", "Yellow", "Green", "Blue"};
    private String[] choices2 = {"CHOOSE", "Red", "Orange", "Yellow", "Green", "Blue"};
    private JComboBox<String> colorChoice1;
    private JComboBox<String> colorChoice2;

    //game panel vars
    private JPanel gamePanel, gameboard, gameTitlePanel;
    private JLabel gameTitle, playerTurn;
    private JButton[][] grid = new JButton[7][7];
    private JButton box, returnButton3, restartButton;
    private JButton[] buttons = new JButton[7];
    private int[][] backend = new int[6][7]; 
    private int columnChosen = 0; 
    private int currentPlayer = 1;  
    private String p1Name, p2Name; 
    private Color player1Color; 
    private Color player2Color;   
    ImageIcon crown = new ImageIcon("crown.png");
    private String[] options = {"OK", "Go to Scoreboard"};
    int choice;
    private boolean switchScoreboard = false;

    //scoreboard panel vars
    private JPanel scoreboard, scoreboardTitlePanel;
    private JLabel scoreboardTitle;
    private JButton returnButton4;
    String file = "scoreboard.txt";
    private JButton[][] score = new JButton[10][3];
    private JButton[] labels = new JButton[3];
    private ArrayList<String> names = new ArrayList<>();
    private ArrayList<Integer> scores = new ArrayList<>();

    //Text size
    Font font1 = new Font("Display", Font.BOLD, 50);
    Font font2 = new Font("Display", Font.BOLD, 30);

    // Constructor
    public Frame() {

        // ======================================================== MENU PANEL ========================================================
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

        // estable howTo panel
        howToPanel = new JPanel();
        howToPanel.add(howToButton); // Add the button
        menuPanel.add(howToPanel);   // Add the panel to menu

        // establish scoreboard panel
        scoreboardPanel = new JPanel();
        scoreboardPanel.add(scoreboardButton); // Add the button
        menuPanel.add(scoreboardPanel); // Add the panel to the menu
        menuPanel.add(new JPanel()); // spacer


        // ======================================================== HOWTO PANEL ========================================================
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

        // Initializing return button
        returnButton1 = new JButton("⌂");  
        returnButton1.setPreferredSize(new Dimension(50, 50));
        returnButton1.addActionListener(this);


        //establish how to panel
        howToPanel = new JPanel();
        howToPanel.setLayout(new GridLayout(15,0));

        // establish return panel and add the return button to it
        returnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        returnPanel.add(returnButton1);
        
        // adding all the howTo components to the main howTo panel
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
        

        // ======================================================== START PANEL ========================================================

        // Choose color options initialized
        colorChoice1 = new JComboBox<String>(choices1); 
        colorChoice1.addActionListener(this);
        colorChoice2 = new JComboBox<String>(choices2);
        colorChoice2.addActionListener(this);
        
        // Add the return button to the return panel
        returnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        returnButton2 = new JButton("⌂");
        returnButton2.setPreferredSize(new Dimension(50, 50));
        returnButton2.addActionListener(this);
        returnPanel.add(returnButton2);

        // Initialize the player setup panel and add Title
        settingsTitlePanel = new JPanel(new BorderLayout());
        settingsTitlePanel.add(returnPanel, BorderLayout.NORTH);
        settingsTitle = new JLabel("Player Setup");
        settingsTitle.setFont(font1);
        settingsTitle.setHorizontalAlignment(JLabel.CENTER);
        settingsTitlePanel.add(settingsTitle, BorderLayout.CENTER);

        // Initialize Player Text Fields
        player1 = new JTextField();
        player1.addActionListener(this);
        player2 = new JTextField();
        player2.addActionListener(this);

        // Initializing panels for each setting. 
        settingsLayout = new JPanel(new GridLayout(4,2));
        enterName1 = new JPanel(new GridLayout(1,2));
        enterName2 = new JPanel(new GridLayout(1,2));
        chooseColor1 = new JPanel(new GridLayout(1,2));
        chooseColor2 = new JPanel(new GridLayout(1,2));
        
        // Adding Text Field and Color Chooser for Player 1
        enterName1.add(new JLabel("Enter Name:", JLabel.CENTER));
        enterName1.add(player1);
        chooseColor1.add(new JLabel("Choose Color:", JLabel.CENTER));
        chooseColor1.add(colorChoice1);

        // Adding Text Field and Color Chooser for Player 2
        enterName2.add(new JLabel("Enter Name:", JLabel.CENTER));
        enterName2.add(player2);
        chooseColor2.add(new JLabel("Choose Color:", JLabel.CENTER));
        chooseColor2.add(colorChoice2);

        // Initialize panel to display color picked for Player 1
        color1 = new JPanel();
        color1.setBackground(Color.WHITE);
        
        // Color Box for Player 1
        colorbox1 = new JPanel(new GridLayout(1,2));
        colorbox1.add(new JPanel());
        colorbox1.add(color1);

        // Initialize panel to display color picked for Player 2
        color2 = new JPanel();  
        color2.setBackground(Color.WHITE);
        
        // Color Box for Player 2
        colorbox2 = new JPanel(new GridLayout(1,2));
        colorbox2.add(new JPanel());
        colorbox2.add(color2);

        // Initialzing Play button and adding it to the panel
        playButton = new JButton("PLAY");
        playButton.setPreferredSize(new Dimension(250, 50));
        playButton.addActionListener(this);
        playBtnPanel = new JPanel();
        playBtnPanel.add(playButton);
        playPanel = new JPanel(new GridLayout(3,1));
        playPanel.add(playBtnPanel);
        playPanel.add(new JPanel());
        
        // Adding Color Choosers, TextFields and Color Boxes to settingsLayout Panel. 
        settingsLayout.add(new JLabel("Player 1", JLabel.CENTER));
        settingsLayout.add(new JLabel("Player 2", JLabel.CENTER));
        settingsLayout.add(enterName1);
        settingsLayout.add(enterName2);
        settingsLayout.add(chooseColor1);
        settingsLayout.add(chooseColor2);
        settingsLayout.add(colorbox1);
        settingsLayout.add(colorbox2);

        // adding all player settings components to the main setting panel
        playerSettings = new JPanel();
        playerSettings.setLayout(new GridLayout(3,1));
        playerSettings.add(settingsTitlePanel);
        playerSettings.add(settingsLayout);
        playerSettings.add(playPanel);


        // ======================================================== GAME PANEL ========================================================
        
        // Initialize the main game panel
        gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());
        
        // Initialize new return button and add it to the return panel
        returnButton3 = new JButton("⌂");
        returnButton3.setPreferredSize(new Dimension(50, 50));
        returnButton3.addActionListener(this);
        restartButton = new JButton("Restart");
        restartButton.setPreferredSize(new Dimension(100, 50));
        restartButton.addActionListener(this);
        returnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        returnPanel.add(returnButton3);
        returnPanel.add(restartButton);

        // Initalize game title and align it
        gameTitle = new JLabel("CONNECT 4");
        gameTitle.setFont(font1);
        gameTitle.setHorizontalAlignment(JLabel.CENTER);
        
        // Initialize label to display current player. 
        playerTurn = new JLabel();
        playerTurn.setFont(font2);
        playerTurn.setHorizontalAlignment(JLabel.CENTER);
        playerTurn.setText("Choose a column!");
        
        // Initialize the main gameboard panel
        gameboard = new JPanel(new GridLayout(7,7));
        gameboard.setSize(700,600);
        
        //make interactive buttons for placing game piece
        for (int i = 0; i < buttons.length; i++) {
            JButton temp = new JButton("COLUMN " + (i+1)); 
            temp.addActionListener(this);
            temp.setBackground(Color.WHITE); // set button background
            temp.setOpaque(true); //see color on mac
            gameboard.add(temp); // add button to the gameboard
            buttons[i] = temp; // add the button to the array
        }
        
        // make buttons for the main gameboard where the pieces are displayed
        for (int r = 1; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                box = new JButton(); 
                box.setBackground(Color.WHITE); // set button background
                box.setOpaque(true); //see color on mac
                box.setEnabled(false); // disable the buttons
                gameboard.add(box); // add the buttons to the game board
                grid[r][c] = box; // add the buttons to the 2d button array
            }
        }
        
        // setting up a 2d array for gameboard background logic (backend)
        for (int r = 0; r < backend.length; r++) { 
            for(int c = 0; c < backend[r].length; c++) { 
                backend[r][c] = 0; 
            }
        }
        
        // Add game components to the main game panel
        gameTitlePanel = new JPanel(new BorderLayout());
        gameTitlePanel.add(returnPanel, BorderLayout.NORTH);
        gameTitlePanel.add(gameTitle, BorderLayout.CENTER);
        gameTitlePanel.add(playerTurn, BorderLayout.SOUTH);
        gamePanel.add(gameTitlePanel, BorderLayout.NORTH);
        gamePanel.add(gameboard, BorderLayout.CENTER);

        // ======================================================== SCOREBOARD PANEL ========================================================
        
        // Initialize the Title
        scoreboardTitle = new JLabel("Scoreboard");
        scoreboardTitle.setFont(font1);
        scoreboardTitle.setHorizontalAlignment(JLabel.CENTER);

        //return button
        returnButton4 = new JButton("⌂");
        returnButton4.setPreferredSize(new Dimension(50, 50));
        returnButton4.addActionListener(this);
        returnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        returnPanel.add(returnButton4);

        //establish scoreboard 
        scoreboard = new JPanel();
        scoreboard.setLayout(new GridLayout(12,3));

        //Adding components to scoreboard (Section Titles)
        JButton label1 = new JButton("Rank");
        labels[0] = label1;

        JButton label2 = new JButton("User");
        labels[0] = label1;

        JButton label3 = new JButton("Game(s) Won");
        labels[0] = label1;

        scoreboard.add(label1);
        scoreboard.add(label2);
        scoreboard.add(label3);
        scoreboard.add(new JPanel()); // Spacer
        scoreboard.add(new JPanel()); // Spacer
        scoreboard.add(new JPanel()); // Spacer

        // Adding all the buttons used to display names, wins, and rank
        for (int i = 0; i < score.length; i++){

            // Buttons to display rank
            JButton temp = new JButton("" + (i+1));
            temp.setBackground(Color.WHITE); // button background
            temp.setOpaque(true); //see color on mac
            scoreboard.add(temp); // add it to the panel
            score[i][0] = temp; // add the button to the column used for ranks
 
            // Buttons to display names
            temp = new JButton();
            temp.setBackground(Color.WHITE); // button background
            temp.setOpaque(true); //see color on mac
            scoreboard.add(temp); // add it to the panel
            score[i][1] = temp; // add the button to the column used for names

            // Buttons to display wins
            temp = new JButton();
            temp.setBackground(Color.WHITE); // button background
            temp.setOpaque(true); //see color on mac
            scoreboard.add(temp); // add it to the panel
            score[i][2] = temp; // add the button to the column used for wins
        }
        
     
        // adding scoreboard components to main scoreboard panel
        scoreboardTitlePanel = new JPanel(new BorderLayout());
        scoreboardTitlePanel.add(returnPanel, BorderLayout.NORTH);
        scoreboardTitlePanel.add(scoreboardTitle, BorderLayout.CENTER);
        scoreboardPanel = new JPanel(new BorderLayout());
        scoreboardPanel.add(scoreboardTitlePanel, BorderLayout.NORTH);
        scoreboardPanel.add(scoreboard, BorderLayout.CENTER);

        // ======================================================== FRAME SETTINGS ========================================================

        this.add(menuPanel); // adding initial panel to main
        TheOneAndOnlyMainPanel = menuPanel; // storing the current panel being used to switch it later
        setVisible(true); // set frame to visible
        readInName(file, names);
        readInScores(file, scores);
    }

   
    /*
    * Method Name: actionPerformed
    * Author: Yunseo Jeon
    * Creation Date: June 5 2024
    * Modified Date: June 5 2024
    * Description: Gets input from actions listeners
    * @Parameters: ActionEvent e
    * @Return Value: None its a procedure
    * Data Type: n/a
    * Dependencies: n/a
    * Throws/Exceptions: n/a
    */
    public void actionPerformed(ActionEvent e) {

        // always update p1Name, p2Name, p1Color and p2Color on any interaction. 
        p1Name = player1.getText().trim(); 
        p2Name = player2.getText().trim(); 
        String p1Color = (String) colorChoice1.getSelectedItem();
        String p2Color = (String) colorChoice2.getSelectedItem();

        // procedure for when return button is clicked
        if (e.getActionCommand().equals("⌂") ) {
            switchPanels(menuPanel); // Switch panels back to menuPanel
            p1Name = ""; // reset player 1 name
            p1Color = "CHOOSE"; // reset player 1 color
            color1.setBackground(Color.WHITE);  // reset player 1 color box
            player1.setText(""); // reset player 1 text box
            colorChoice1.setSelectedItem("CHOOSE"); // reset player 1 color choice
            p2Name = ""; // reset player 2 name
            p2Color = "CHOOSE"; // reset player 2 color
            player2.setText(""); // reset player 2 text box
            colorChoice2.setSelectedItem("CHOOSE"); // reset player 2 color choice
            restart(); // reset the gameboard
        }
        
        // ======================================================== ACTION LISTENERS FOR MAIN MENU ========================================================
        
        if (e.getActionCommand().equals("How-To")) {
            switchPanels(howToPanel);
        }

        if (e.getActionCommand().equals("Start")) {
            switchPanels(playerSettings);
        }

        if (e.getActionCommand().equals("Scoreboard") || switchScoreboard == true) {
            switchPanels(scoreboardPanel);
            names.clear(); // clear the names arraylist
            scores.clear(); // clear the scores arraylist
            
            // read in file items and add them to the array
            readInName(file, names);
            readInScores(file, scores);

            // sort the file
            reorderFile(file, scores, names);

            // set the button names for names and scores columns. 
            for (int r = 0; r < names.size(); r++) {
                score[r][1].setText(names.get(r));
                score[r][2].setText("" + scores.get(r));
            }
        }
        

        // ======================================================== ACTION LISTENERS FOR PLAYER SETTINGS ========================================================
        
        // set the color box background to whatever the color the user picks
        pickColor(p1Color, color1);
        pickColor(p2Color, color2);

        // reset the color boxes and display a message if both players pick the same color
        if ((p1Color == p2Color ) && (p1Color != "CHOOSE")){
            JOptionPane.showMessageDialog(this, "Please choose a different color from the other player!", "ALERT", JOptionPane.ERROR_MESSAGE); 
            color1.setBackground(Color.WHITE);
            colorChoice1.setSelectedItem("CHOOSE");
            color2.setBackground(Color.WHITE);
            colorChoice2.setSelectedItem("CHOOSE");
        }

        // procedure for when PLAY button is clicked
        if (e.getActionCommand().equals("PLAY")) {

            // Display error message if any players name textfields are blank
            if (p1Name.isBlank() || p2Name.isBlank()){
                JOptionPane.showMessageDialog(this, "Enter player name(s)", "ALERT", JOptionPane.ERROR_MESSAGE);
            }
            
            // Display error message if any players have not picked a color
            else if ((p1Color == "CHOOSE") || (p2Color == "CHOOSE")) {
                JOptionPane.showMessageDialog(this, "Please choose a color!", "ALERT", JOptionPane.ERROR_MESSAGE);
            }

            // display error message if both players have the same name
            else if (p1Name.equalsIgnoreCase(p2Name) && !(p1Name.isBlank())){
                JOptionPane.showMessageDialog(this, "Please choose different names from each other!", "ALERT", JOptionPane.ERROR_MESSAGE);
            }

            // display error message if the player names are over the character limit. 
            else if (p1Name.length() > 10 || p2Name.length() > 10 ){
                JOptionPane.showMessageDialog(this, "Please choose a name less than 10 characters!", "ALERT", JOptionPane.ERROR_MESSAGE);
            }

            // proceed to main gamePanel if everything checks out!
            else{
                player1Color = color1.getBackground(); 
                player2Color = color2.getBackground();
                switchPanels(gamePanel);
            }
        }


        // ======================================================== ACTION LISTENERS FOR MAIN GAME PANEL ========================================================

        if (e.getActionCommand().equals("Restart")){
            restart();
        }

        // place piece on the column chosen
        try {
            switch (e.getActionCommand()) {
             case "COLUMN 1":
                 columnChosen = 0;
                 placePiece();
                 break;
             case "COLUMN 2": 
                 columnChosen = 1;
                 placePiece();
                 break; 
             case "COLUMN 3": 
                 columnChosen = 2;
                 placePiece();
                 break; 
             case "COLUMN 4": 
                 columnChosen = 3;
                 placePiece();
                 break;  
             case "COLUMN 5": 
                 columnChosen = 4;
                 placePiece();
                 break; 
             case "COLUMN 6": 
                 columnChosen = 5;
                 placePiece();
                 break; 
             case "COLUMN 7": 
                 columnChosen = 6;
                 placePiece();
                 break; 
             default:
                 break;
            }
         } catch (Exception ee){}
    } // end Action listener method


    /*
    * Method Name: pickColor
    * Author: Yunseo Jeon
    * Creation Date: June 12 2024
    * Modified Date: June 12 2024
    * Description: Changes the background for color box depending on which color the player has picked
    * @Parameters: String Color, JPanel colorbox
    * @Return Value: None its a procedure
    * Data Type: n/a
    * Dependencies: n/a
    * Throws/Exceptions: n/a
    */
    public void pickColor(String color, JPanel colorbox){
        switch(color){
            case "CHOOSE":
                colorbox.setBackground(Color.WHITE);
                break;
            case "Red":
                colorbox.setBackground(Color.RED);
                break;
            case "Yellow":
                colorbox.setBackground(Color.YELLOW);
                break;
            case "Orange":
                colorbox.setBackground(Color.ORANGE);
                break;
            case "Green":
                colorbox.setBackground(Color.GREEN);
                break;
            case "Blue":
                colorbox.setBackground(Color.BLUE);
                break;
            default:
                colorbox.setBackground(Color.WHITE);
        }
        refresh();
    } // end pickColor method

    
    /*
    * Method Name: refresh
    * Author: Yunseo Jeon
    * Creation Date: June 10 2024
    * Modified Date: June 10 2024
    * Description: Refreshes the frame to load in any new components added. 
    * @Parameters: n/a
    * @Return Value: None its a procedure
    * Data Type: n/a
    * Dependencies: n/a
    * Throws/Exceptions: n/a
    */
    public void refresh(){
        this.getContentPane().revalidate(); // used when adding new components
        this.getContentPane().repaint();
    } // end refresh method


    /*
    * Method Name: switchPanels
    * Author: Yunseo Jeon
    * Creation Date: June 14 2024
    * Modified Date: June 14 2024
    * Description: remove the current panel and add in a new panel to the frame
    * @Parameters: JPanel newPanel
    * @Return Value: None its a procedure
    * Data Type: n/a
    * Dependencies: n/a
    * Throws/Exceptions: n/a
    */
    public void switchPanels(JPanel newPanel) { 
        this.getContentPane().remove(TheOneAndOnlyMainPanel); // remove the current panel
        this.getContentPane().add(newPanel); // add the new panel
        refresh(); // refresh the frame
        TheOneAndOnlyMainPanel = newPanel; // Updating the current panel being used. 
    } // end switchPanels method


    /*
    * Method Name: BottomDrop
    * Author: Yunseo Jeon
    * Creation Date: June 16 2024
    * Modified Date: June 16 2024
    * Description: finds the bottom lowest index in a 2d int array column and returns the row. 
    * @Parameters: int[][] g, int col
    * @Return Value: returns the lowest row
    * Data Type: Integer
    * Dependencies: n/a
    * Throws/Exceptions: n/a
    */
    public int BottomDrop(int[][] g, int col) {
        int row = -1; 
        for (int i = 0; i < g.length; i++) {
            if (g[i][col] == 0) { //keeps moving the column until row != 0
                row = i; 
            } else {
                break; // if the column is full break
            }
        }
        return row; // returns -1 if the column is full
    } // end BottomDrop method


    /*
    * Method Name: fourConnected
    * Author: Yunseo Jeon
    * Creation Date: June 16 2024
    * Modified Date: June 16 2024
    * Description: checks if the player has won by connecting four pieces in either horizontal, vertical or diagonal orientation.
    * @Parameters: int player
    * @Return Value: returns true if the player has one, returns false if the player hasn't won
    * Data Type: boolean
    * Dependencies: n/a
    * Throws/Exceptions: n/a
    */
    private boolean fourConnected(int player) {
        // horizontal
        for (int r = 0; r < backend.length; r++) {
            for (int c = 0; c < backend[0].length - 3; c++) {
                if (backend[r][c] == player && backend[r][c+1] == player && backend[r][c+2] == player && backend[r][c+3] == player){
                    return true;
                }
            }
        }

        // vertical
        for (int r = 0; r < backend.length - 3; r++) {
            for (int c = 0; c < backend[0].length; c++) {
                if (backend[r][c] == player && backend[r+1][c] == player && backend[r+2][c] == player && backend[r+3][c] == player){
                    return true;
                }
            }
        }

        // diagonal (down)
        for (int r = 0; r < backend.length - 3; r++) {
            for (int c = 0; c < backend[0].length - 3; c++) {
                if (backend[r][c] == player && backend[r+1][c+1] == player && backend[r+2][c+2] == player && backend[r+3][c+3] == player){
                    return true;
                }
            }
        }

        // diagonal (up)
        for (int r = 3; r < backend.length; r++) {
            for (int c = 0; c < backend[0].length - 3; c++) {
                if (backend[r][c] == player && backend[r-1][c+1] == player && backend[r-2][c+2] == player && backend[r-3][c+3] == player){
                    return true;
                }
            }
        }
        return false;
    } // end fourConnected method


    /*
    * Method Name: winner
    * Author: Yunseo Jeon
    * Creation Date: June 17 2024
    * Modified Date: June 17 2024
    * Description: if a player has won disables all the buttons and displays a message.
    * @Parameters: String name
    * @Return Value: none its a procedure
    * Data Type: n/a
    * Dependencies: n/a
    * Throws/Exceptions: n/a
    */
    public void winner(String name) {

        // Check if player has won
    	if (fourConnected(currentPlayer)){

            // Disable all the buttons
            for (int i = 0; i < buttons.length; i++){
                buttons[i].setEnabled(false);
            }
            
            // display a message to show that the player has won and give options. 
            choice = JOptionPane.showOptionDialog(this, name + " WON!", "Game End", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, crown, options, options[0]);
            playerTurn.setText("Game End");
            addToScoreboard(currentPlayer); // add the winner to the scoreboard. 

            // if player chose to go to scoreboard
            if (choice == 1) {
                switchPanels(scoreboardPanel); // switch to scoreboard panel
                names.clear(); // clear names arraylist
                scores.clear(); // clear scores arraylist
                
                // read in the file and put them in array lists
                readInName(file, names);
                readInScores(file, scores);

                // sort the file and output it
                reorderFile(file, scores, names);

                // add the names and scores by renaming the buttons. 
                for (int r = 0; r < names.size(); r++) {
                    score[r][1].setText(names.get(r));
                    score[r][2].setText("" + scores.get(r));
                }
            } 
        }
    } // end winner method


    /*
    * Method Name: isTie
    * Author: Yunseo Jeon
    * Creation Date: June 17 2024
    * Modified Date: June 17 2024
    * Description: checks if the game has resulted in a tie by checking if the backend array has any 0's left in it. 
    * @Parameters: int[][] array, int key
    * @Return Value: returns true if the game is a tie, returns false if the game isn't a tie. 
    * Data Type: n/a
    * Dependencies: n/a
    * Throws/Exceptions: n/a
    */
    public static boolean isTie(int[][] array, int key) {
		for (int r = 0; r < array.length; r++) {
            for (int c = 0; c < array[r].length; c++){
                if (array[r][c] == key) {
                    return false; // return false if the gameboard isn't filled
                }
            }
		}
		return true; 
	} // end isTie method


    /*
    * Method Name: tie
    * Author: Yunseo Jeon
    * Creation Date: June 17 2024
    * Modified Date: June 17 2024
    * Description: displays a message and disables all buttons if the game ends up in a tie. 
    * @Parameters: n/a
    * @Return Value: none it's a procedure
    * Data Type: n/a
    * Dependencies: n/a
    * Throws/Exceptions: n/a
    */
    public void tie(){
        if (isTie(backend, 0) && !fourConnected(currentPlayer)){
            JOptionPane.showMessageDialog(this, "Tied", "ALERT", JOptionPane.WARNING_MESSAGE); // display warning message
            for (int i = 0; i < buttons.length; i++){
                buttons[i].setEnabled(false); // disable all buttons
            }
            playerTurn.setText("Game End");
        }
    } // end tie method


    /*
    * Method Name: restart
    * Author: Yunseo Jeon
    * Creation Date: June 17 2024
    * Modified Date: June 17 2024
    * Description: resets the gameboard by resetting the backend and 2d button array. 
    * @Parameters: n/a
    * @Return Value: none it's a procedure
    * Data Type: n/a
    * Dependencies: n/a
    * Throws/Exceptions: n/a
    */
    public void restart(){

        // reset the array used for gameboard logic (backend array)
        for (int r = 0; r < backend.length; r++) { 
            for(int c = 0; c < backend[r].length; c++) { 
                backend[r][c] = 0; 
            }
        }

        // reset the button array used for game pieces. 
        for (int r = 1; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c].setBackground(Color.WHITE);
            }
        }

        // enable all the drop buttons
        for (int i = 0; i < buttons.length; i++){
            buttons[i].setEnabled(true);
        }

        playerTurn.setText("Choose a column!");
        refresh();
        currentPlayer = 1; // set current player back to Player 1
    } // end restart method


    /*
    * Method Name: placePiece
    * Author: Yunseo Jeon
    * Creation Date: June 17 2024
    * Modified Date: June 17 2024
    * Description: places the piece on the gameboard and updates the backend array. Is responsible for most of the game logic. 
    * @Parameters: n/a
    * @Return Value: none it's a procedure
    * Data Type: n/a
    * Dependencies: n/a
    * Throws/Exceptions: n/a
    */ 
    public void placePiece() {
        if(currentPlayer == 1) { 
            grid[BottomDrop(backend, columnChosen)+1][columnChosen].setBackground(player1Color); // Change the button background to display game piece for Player 1
            backend[BottomDrop(backend, columnChosen)][columnChosen] = 1; // update the backend array for Player 1
            winner(p1Name); // check if player 1 won
            tie(); // check if it's a tie
            currentPlayer = 2; // switch player
            playerTurn.setText(p2Name+ "\'s Turn");
        } else if (currentPlayer == 2) { 
            grid[BottomDrop(backend, columnChosen)+1][columnChosen].setBackground(player2Color); // Change the button background to display game piece for Player 2
            backend[BottomDrop(backend, columnChosen)][columnChosen] = 2; // update the backend array for Player 2
            tie(); // check if it's a tie
            winner(p2Name); // check if player 2 won
            currentPlayer = 1; // switch player
            playerTurn.setText(p1Name+ "\'s Turn");
        }
    } // end placePiece method
    

    /*
    * Method Name: CheckSize
    * Author: Kyle McKay
    * Creation Date: Nov 15 2023
    * Date: Nov 15 2023
    * Description: Peeks at the size of the array
    * @Parameters: A integer array
    * @Return Value: Returns the number of lines in a file
    * Data Type: integer ARRAY
    * Dependencies: n/a
    * Throws/Exceptions: File IO errors
    */
    public static int CheckSize(String filename) {
		int NumberOfItems = 0;
		try {
			BufferedReader FileInputPointer = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			while (FileInputPointer.ready() == true) {
				FileInputPointer.readLine(); // Advances the pointer
				NumberOfItems++;
			}
			FileInputPointer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error - this file does not exist");
			return -1; 
		} catch (IOException e) {
			System.out.println("Error" + e.toString());
			return -1;
		}

		return NumberOfItems;
	} // end checkSize method


    /*
    * Method Name: readInName
    * Author: Yunseo Jeon
    * Creation Date: June 18 2024
    * Modified Date: June 18 2024
    * Description: Reads in the names from the score file and adds the names to a String arraylist.
    * @Parameters: String filename, ArrayList<String> names
    * @Return Value: String arrayList with all the names. 
    * Data Type: ArrayList<String>
    * Dependencies: n/a
    * Throws/Exceptions: n/a
    */ 
    public static ArrayList<String> readInName(String filename, ArrayList<String> names) {
		String dataItem;
		try {
			BufferedReader FileInputPointer = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			while (FileInputPointer.ready() == true) {
				dataItem = FileInputPointer.readLine(); // filter out the score - do nothing - just advance the file pointer
				dataItem = FileInputPointer.readLine(); // name
				names.add(dataItem); // add the name to the arraylist
			}
			FileInputPointer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error - this file does not exist");
		} catch (IOException e) {
			System.out.println("Error" + e.toString());
		}
		return names;
	} // end readInName


    /*
    * Method Name: readInScores
    * Author: Yunseo Jeon
    * Creation Date: June 18 2024
    * Modified Date: June 18 2024
    * Description: Reads in the scores from the score file and adds the scores to a int arraylist.
    * @Parameters: String filename, ArrayList<Integer> scores
    * @Return Value: Integer arrayList with all the scores. 
    * Data Type: ArrayList<Integer>
    * Dependencies: n/a
    * Throws/Exceptions: n/a
    */ 
    public static ArrayList<Integer> readInScores(String filename, ArrayList<Integer> scores) {
        String Holder;
		try {
			BufferedReader FileInputPointer = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			while (FileInputPointer.ready() == true) {
				Holder = FileInputPointer.readLine().toString(); // score number
				scores.add(Integer.parseInt(Holder)); // add the score to the arraylist
				Holder = FileInputPointer.readLine().toString(); // Student name filter it out just advance the file pointer
			}
			FileInputPointer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error - this file does not exist");
		} catch (IOException e) {
			System.out.println("Error" + e.toString());
		}
		return scores;
	} // end readInScores method


    /*
    * Method Name: reorderFile
    * Author: Yunseo Jeon
    * Creation Date: June 18 2024
    * Modified Date: June 18 2024
    * Description: sort the scores and names array lists then outputs it to a file. 
    * @Parameters: String filename, ArrayList<Integer> scores, ArrayList<String> names
    * @Return Value: none it's a procedure
    * Data Type: n/a
    * Dependencies: n/a
    * Throws/Exceptions: n/a
    */  
    public static void reorderFile(String filename, ArrayList<Integer> scores, ArrayList<String> names){
        selectionSortDES(scores, names);
        writeOut(filename, scores, names);
    } // end reorderFile


    /*
    * Method Name: selectionSortDES
    * Author: Yunseo Jeon
    * Creation Date: June 18 2024
    * Modified Date: June 18 2024
    * Description: Sorts the scores and names array list in descending order using selection sort 
    * @Parameters: ArrayList<Integer> scores, ArrayList<String> names
    * @Return Value: none it's a procedure
    * Data Type: n/a
    * Dependencies: n/a
    * Throws/Exceptions: n/a
    */ 
    public static void selectionSortDES(ArrayList<Integer> scores, ArrayList<String> names) {
        for (int i = scores.size() - 1; i > 0; i--) {
            int maxLoc = 0; // Location of largest item seen so far.
            for (int j = 1; j <= i; j++) {
                if (scores.get(j) < scores.get(maxLoc)) {
                    maxLoc = j;
                }
            }
            int tempS = scores.get(maxLoc); // Swap largest item with intArray[i].
            String tempN = names.get(maxLoc); // Do same thing for names array
            scores.set(maxLoc, scores.get(i));
            names.set(maxLoc, names.get(i));
            scores.set(i, tempS);
            names.set(i, tempN);
        } // end of for loop
    } // end selectSort



    /*
    * Method Name: writeOut
    * Author: Kyle McKay
    * Modified by: Yunseo Jeon
    * Creation Date; Nov 15 2023
    * Modified Date: June 19 2024
    * Description: Creates a new file and outputs the scores and names to it
    * @Parameters: String filename, ArrayList<Integer> scores, ArrayList<String> names
    * @Return Value: None its a procedure
    * Data Type: n/a
    * Dependencies: n/a
    * Throws/Exceptions: File IO exceptions
    */
    public static void writeOut(String filename, ArrayList<Integer> scores, ArrayList<String> names) {
        try {
            PrintWriter outputfile = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
            for (int i = 0; i < names.size(); i++) {
                outputfile.println(scores.get(i)); // write score to the file
                outputfile.println(names.get(i)); // write name to the file
            }
            outputfile.close();
        } catch (Exception e) {
            System.out.println("My Application Error: " + e.toString());
        }
    } // end writeOut method


    /*
    * Method Name: addToScoreboard
    * Author: Yunseo Jeon
    * Creation Date: June 18 2024
    * Modified Date: June 18 2024
    * Description: adds the winner's score and name to the scoreboard.  
    * @Parameters: int player
    * @Return Value: none it's a procedure
    * Data Type: n/a
    * Dependencies: n/a
    * Throws/Exceptions: n/a
    */ 
    public void addToScoreboard(int player) {
        if (player == 1) {
            boolean p1Found = false;

            //if name is already on scoreboard (on file)
            for (int i = 0; i < names.size(); i++) {
                if (names.get(i).equalsIgnoreCase(p1Name)) {
                    scores.set(i, scores.get(i) + 1);
                    writeOut(file, scores, names);
                    p1Found = true;
                    break;
                }
            }

            //if name is not found on scoreboard (is not on file)
            if (!p1Found) {
                names.add(p1Name);
                scores.add(1);
                try (FileWriter writer = new FileWriter("scoreboard.txt", true)) {
                    writer.write("1" + "\n" + p1Name + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //do the same for if it is player 2
        } else if (player == 2) {
            boolean p2Found = false;
            for (int i = 0; i < names.size(); i++) {
                if (names.get(i).equalsIgnoreCase(p2Name)) {
                    scores.set(i, scores.get(i) + 1);
                    writeOut(file, scores, names);
                    p2Found = true;
                    break;
                }
            }
            if (!p2Found) {
                names.add(p2Name);
                scores.add(1);
                try (FileWriter writer = new FileWriter("scoreboard.txt", true)) {
                    writer.write("1" + "\n" + p2Name + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}   