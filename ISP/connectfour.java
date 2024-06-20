import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;


public class connectfour {
    public static void main(String[] args) {
        Frame game = new Frame();
        ImageIcon logo = new ImageIcon("Logo(1).png");
        game.setIconImage(logo.getImage());
        game.setSize(700, 900); // Set initial window size
        game.setResizable(false);
        game.setLocationRelativeTo(null);
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
        // menu panel --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
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


        // howto panel ----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
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

        returnButton1 = new JButton("⌂");
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
        

        //Start panel -------------------------------------------------------------------------------------------------------------------------------------------------------------------------
       
        //CHOOSE A COLOR & NAME FOR PLAYERS
        //vars
        colorChoice1 = new JComboBox<String>(choices1);
        colorChoice1.addActionListener(this);
        colorChoice2 = new JComboBox<String>(choices2);
        colorChoice2.addActionListener(this);
        
        settingsTitlePanel = new JPanel(new BorderLayout());
        returnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        returnButton2 = new JButton("⌂");
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
        color1.setBackground(Color.WHITE);
        
        colorbox1 = new JPanel(new GridLayout(1,2));
        colorbox1.add(new JPanel());
        colorbox1.add(color1);

        color2 = new JPanel();
        color2.setBackground(Color.WHITE);
        
        colorbox2 = new JPanel(new GridLayout(1,2));
        colorbox2.add(new JPanel());
        colorbox2.add(color2);

        playButton = new JButton("PLAY");
        playButton.setPreferredSize(new Dimension(250, 50));
        playButton.addActionListener(this);
        playBtnPanel = new JPanel();
        playBtnPanel.add(playButton);
        playPanel = new JPanel(new GridLayout(3,1));
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

        //add components
        playerSettings = new JPanel();
        playerSettings.setLayout(new GridLayout(3,1));
        playerSettings.add(settingsTitlePanel);
        playerSettings.add(settingsLayout);
        playerSettings.add(playPanel);


        //game panel ---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
        gamePanel = new JPanel();
        gamePanel.setLayout(new BorderLayout());
        
        
        returnButton3 = new JButton("⌂");
        returnButton3.setPreferredSize(new Dimension(50, 50));
        returnButton3.addActionListener(this);
        restartButton = new JButton("Restart");
        restartButton.setPreferredSize(new Dimension(100, 50));
        restartButton.addActionListener(this);

        returnPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        returnPanel.add(returnButton3);
        returnPanel.add(restartButton);

        gameTitle = new JLabel("CONNECT 4");
        gameTitle.setFont(font1);
        gameTitle.setHorizontalAlignment(JLabel.CENTER);
        
        playerTurn = new JLabel();
        playerTurn.setFont(font2);
        playerTurn.setHorizontalAlignment(JLabel.CENTER);
        playerTurn.setText("Choose a column!");
        
       
        gameboard = new JPanel(new GridLayout(7,7));
        gameboard.setSize(700,600);
        
        //make interactive buttons for placing game piece
        for (int i = 0; i < buttons.length; i++){
            JButton temp = new JButton("COLUMN " + (i+1));
            temp.addActionListener(this);
            temp.setBackground(Color.WHITE);
            temp.setOpaque(true); //see color on mac
            gameboard.add(temp);
            buttons[i] = temp;
        }
        
        // make gameboard
        for (int r = 1; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                box = new JButton();
                box.setBackground(Color.WHITE);
                box.setOpaque(true); //see color on mac
                box.setEnabled(false);
                gameboard.add(box);
                grid[r][c] = box;
            }
        }
        
        // int gameboard for background logic
        for (int r = 0; r < backend.length; r++) { 
            for(int c = 0; c < backend[r].length; c++) { 
                backend[r][c] = 0; 
            }
        }
        
        gameTitlePanel = new JPanel(new BorderLayout());
        gameTitlePanel.add(returnPanel, BorderLayout.NORTH);
        gameTitlePanel.add(gameTitle, BorderLayout.CENTER);
        gameTitlePanel.add(playerTurn, BorderLayout.SOUTH);
        gamePanel.add(gameTitlePanel, BorderLayout.NORTH);
        gamePanel.add(gameboard, BorderLayout.CENTER);

        //scoreboard panel ============================================================================================================================================================
        
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

        //Adding components to scoreboard
            JButton label1 = new JButton("Rank");
            label1.setEnabled(false);
            labels[0] = label1;

            JButton label2 = new JButton("User");
            label2.setEnabled(false);
            labels[0] = label1;
 
            JButton label3 = new JButton("Game(s) Won");
            label3.setEnabled(false);
            labels[0] = label1;


            scoreboard.add(label1);
            scoreboard.add(label2);
            scoreboard.add(label3);
            scoreboard.add(new JPanel());
            scoreboard.add(new JPanel());
            scoreboard.add(new JPanel());

            for (int i = 0; i < score.length; i++){
                JButton temp = new JButton("" + (i+1));
                temp.setOpaque(true); //see color on mac
                scoreboard.add(temp);
                score[i][0] = temp;
    
                temp = new JButton();
                temp.setOpaque(true); //see color on mac
                scoreboard.add(temp);
                score[i][1] = temp;
    
                temp = new JButton();
                temp.setOpaque(true); //see color on mac
                scoreboard.add(temp);
                score[i][2] = temp;
            }
        
     
        //adding components to panel
        scoreboardTitlePanel = new JPanel(new BorderLayout());
        scoreboardTitlePanel.add(returnPanel, BorderLayout.NORTH);
        scoreboardTitlePanel.add(scoreboardTitle, BorderLayout.CENTER);
        scoreboardPanel = new JPanel(new BorderLayout());
        scoreboardPanel.add(scoreboardTitlePanel, BorderLayout.NORTH);
        scoreboardPanel.add(scoreboard, BorderLayout.CENTER);


        

        //establish  panels =======================================================
        this.add(menuPanel); 
        TheOneAndOnlyMainPanel = menuPanel; // Making a variable to store what the main panel currently is. 
        setVisible(true);
        readInName(file, names);
        readInScores(file, scores);
    }

   

    public void actionPerformed(ActionEvent e) {
        //Start
        p1Name = player1.getText().trim(); 
        p2Name = player2.getText().trim(); 
        String p1Color = (String)colorChoice1.getSelectedItem();
        String p2Color = (String)colorChoice2.getSelectedItem();

        //universal
        if (e.getActionCommand().equals("⌂") ) {
            switchPanels(menuPanel);
            p1Name = "";
            p1Color = "CHOOSE";
            color1.setBackground(Color.WHITE);
            player1.setText("");
            colorChoice1.setSelectedItem("CHOOSE");
            p2Name = "";
            p2Color = "CHOOSE";
            //color2.setBackground(Color.WHITE);
            player2.setText("");
            colorChoice2.setSelectedItem("CHOOSE");
            restart();
        }
        
        //main menu
        if (e.getActionCommand().equals("How-To")) {
            switchPanels(howToPanel);
        }

        if (e.getActionCommand().equals("Start")) {
            switchPanels(playerSettings);
        }

        if (e.getActionCommand().equals("Scoreboard") || switchScoreboard == true) {
            switchPanels(scoreboardPanel);
            names.clear();
            scores.clear();
            
            readInName(file, names);
            readInScores(file, scores);
            reorderFile(file, scores, names);

            for (int r = 0; r < names.size(); r++) {
                score[r][1].setText(names.get(r));
                score[r][2].setText("" + scores.get(r));
            }
        }
        // Start- player settings panel
        pickColor(p1Color, color1);
        pickColor(p2Color, color2);
        if ((p1Color == p2Color ) && (p1Color != "CHOOSE")){
            JOptionPane.showMessageDialog(this, "Please choose a different color from the other player!", "ALERT", JOptionPane.ERROR_MESSAGE); 
            color1.setBackground(Color.WHITE);
            colorChoice1.setSelectedItem("CHOOSE");
            color2.setBackground(Color.WHITE);
            colorChoice2.setSelectedItem("CHOOSE");
        }
        if (e.getActionCommand().equals("PLAY")) {
            if (p1Name.isBlank() || p2Name.isBlank()){
                JOptionPane.showMessageDialog(this, "Enter player name(s)", "ALERT", JOptionPane.ERROR_MESSAGE);
            }
            
            else if ((p1Color == "CHOOSE") || (p2Color == "CHOOSE")) {
                JOptionPane.showMessageDialog(this, "Please choose a color!", "ALERT", JOptionPane.ERROR_MESSAGE);
            }
            else if (p1Name.equalsIgnoreCase(p2Name) && !(p1Name.isBlank())){
                JOptionPane.showMessageDialog(this, "Please choose different names from each other!", "ALERT", JOptionPane.ERROR_MESSAGE);
            }
            else if (p1Name.length() > 10 || p2Name.length() > 10 ){
                JOptionPane.showMessageDialog(this, "Please choose a name less than 10 characters!", "ALERT", JOptionPane.ERROR_MESSAGE);
            }
            else{
                player1Color = color1.getBackground(); 
                player2Color = color2.getBackground();
                switchPanels(gamePanel);
            }
        }
        //Game panel
        if (e.getActionCommand().equals("Restart")){
            restart();
        }

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
    }
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
    }  

    public void refresh(){
        this.getContentPane().revalidate();
        this.getContentPane().repaint();
    }
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

    public int BottomDrop(int[][] g, int col) {
        int row = -1; 
        for (int i = 0; i < g.length; i++) {
            if (g[i][col] == 0) { //keeps moving the column until row != 0
                row = i;
            } else {
                break;
            }
        }
        return row;
    }

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
    }

    public void winner(String name) {
    	if (fourConnected(currentPlayer)){
            for (int i = 0; i < buttons.length; i++){
                buttons[i].setEnabled(false);
            }
           choice = JOptionPane.showOptionDialog(this, name + " WON!", "Game End", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, crown, options, options[0]);
           playerTurn.setText("Game End");
           addToScoreboard(currentPlayer);
           if (choice == 1) {
            switchPanels(scoreboardPanel);
            names.clear();
            scores.clear();
            
            readInName(file, names);
            readInScores(file, scores);
            reorderFile(file, scores, names);

            for (int r = 0; r < names.size(); r++) {
                score[r][1].setText(names.get(r));
                score[r][2].setText("" + scores.get(r));
            }
            } 
        }
    }
    public static boolean isTie(int[][] array, int key) {
		for (int r = 0; r < array.length; r++) {
            for (int c = 0; c < array[r].length; c++){
                if (array[r][c] == key) {
                    return false; 
                }
            }
		}
		return true; 
	}
    public void tie(){
        if (isTie(backend, 0) && !fourConnected(currentPlayer)){
            JOptionPane.showMessageDialog(this, "Tied", "ALERT", JOptionPane.WARNING_MESSAGE); 
            for (int i = 0; i < buttons.length; i++){
                buttons[i].setEnabled(false);
            }
            playerTurn.setText("Game End");
        }
    }
    public void restart(){
        for (int r = 0; r < backend.length; r++) { 
            for(int c = 0; c < backend[r].length; c++) { 
                backend[r][c] = 0; 
            }
        }

        for (int r = 1; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                grid[r][c].setBackground(Color.WHITE);
            }
        }

        for (int i = 0; i < buttons.length; i++){
            buttons[i].setEnabled(true);
        }
        playerTurn.setText("Choose a column!");
        refresh();
        currentPlayer = 1;
    }
    public void placePiece() {
        if(currentPlayer == 1) { 
            grid[BottomDrop(backend, columnChosen)+1][columnChosen].setBackground(player1Color);
            backend[BottomDrop(backend, columnChosen)][columnChosen] = 1;
            winner(p1Name);
            tie();
            currentPlayer = 2;
            playerTurn.setText(p2Name+ "\'s Turn");
        } else if (currentPlayer == 2) { 
            grid[BottomDrop(backend, columnChosen)+1][columnChosen].setBackground(player2Color);
            backend[BottomDrop(backend, columnChosen)][columnChosen] = 2;
            tie();
            winner(p2Name);
            currentPlayer = 1; 
            playerTurn.setText(p1Name+ "\'s Turn");
        }
    }
    
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
	}

    public static ArrayList<String> readInName(String filename, ArrayList<String> names) {
		String dataItem;
		try {
			BufferedReader FileInputPointer = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			while (FileInputPointer.ready() == true) {
				dataItem = FileInputPointer.readLine(); // filter out the score - do nothing - just advance the file pointer
				dataItem = FileInputPointer.readLine(); // name
				names.add(dataItem);
			}
			FileInputPointer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error - this file does not exist");
		} catch (IOException e) {
			System.out.println("Error" + e.toString());
		}
		return names;
	}

    public static ArrayList<Integer>  readInScores(String filename, ArrayList<Integer> scores) {
        String Holder;
		try {
			BufferedReader FileInputPointer = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
			while (FileInputPointer.ready() == true) {
				Holder = FileInputPointer.readLine().toString(); // score number
				scores.add(Integer.parseInt(Holder));
				Holder = FileInputPointer.readLine().toString(); // Student name filter it out just advance the file pointer
			}
			FileInputPointer.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error - this file does not exist");
		} catch (IOException e) {
			System.out.println("Error" + e.toString());
		}
		return scores;
	}

    public static void reorderFile(String filename, ArrayList<Integer> scores, ArrayList<String> names){
        selectionSortDES(scores, names);
        writeOut(filename, scores, names);
    }

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


    public static void writeOut(String filename, ArrayList<Integer> scores, ArrayList<String> names) {
        try {
            PrintWriter outputfile = new PrintWriter(new BufferedWriter(new FileWriter(filename)));
            for (int i = 0; i < names.size(); i++) {
                outputfile.println(scores.get(i));
                outputfile.println(names.get(i));
            }
            outputfile.close();
        } catch (Exception e) {
            System.out.println("My Application Error: " + e.toString());
        }
    }

    public void addToScoreboard(int player) {
        if (player == 1) {
            boolean p1Found = false;
            for (int i = 0; i < names.size(); i++) {
                if (names.get(i).equalsIgnoreCase(p1Name)) {
                    scores.set(i, scores.get(i) + 1);
                    writeOut(file, scores, names);
                    p1Found = true;
                    break;
                }
            }
            if (!p1Found) {
                names.add(p1Name);
                scores.add(1);
                try (FileWriter writer = new FileWriter("scoreboard.txt", true)) {
                    writer.write("1" + "\n" + p1Name + "\n");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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