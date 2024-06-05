/*
 * Name: Yunseo Jeon
 * Creation Date: June 2, 2024
 * Description: Guessing game but in graphics. 
 */
 import java.awt.*;
 import javax.swing.*;
 import java.awt.event.*;
 
 public class guess {
     public static void main(String[] args) {
         Frame frame = new Frame();
         frame.setSize(1200, 150);   // Set Window Size
         frame.addWindowListener(new WindowAdapter() {
             public void windowClosing(WindowEvent e) {
                 System.exit(0);
             }
         });
     }
 }
 
 
 // Class for the main window
 class Frame extends JFrame implements ActionListener {
     private static int index = 0;
     private static int[] inventory = new int[4];
     private JLabel feedback; // "Too high", "Too low", "correct"
     private JTextField guessField; // Type in guess
     private int guessNumber; // Guess number
     private int numberOfGuesses; // # of guesses guessed
     private JButton guessButton; // guess button
     private JButton reset; // reset game
 
     // Constructor
     public Frame() {
         guessNumber = randomNumber(1, 20);
         numberOfGuesses = 0;
 
         JPanel pane = (JPanel) getContentPane();
         pane.setLayout(new BorderLayout());
 
         feedback = new JLabel("");
         feedback.setVisible(false); // set false
         guessField = new JTextField();
         guessButton = new JButton("Guess");
         reset = new JButton("Redo");
 
         // instruction label
         pane.add(new JLabel("Welcome to the Guessing Game! Guess a number between 1 and 20"), BorderLayout.NORTH);
 
         // Guessing pane (Guess label, textfield, guess button, feedback)
         JPanel guessPane = new JPanel();
         guessPane.setLayout(new GridLayout(2, 2));
         guessPane.add(new JLabel("Your Guess:"));
         guessField.addActionListener(this);
         guessPane.add(guessField);
         guessPane.add(feedback);
         guessButton.addActionListener(this);
         guessPane.add(guessButton);
         pane.add(guessPane, BorderLayout.CENTER);
 
         // redo button
         reset.addActionListener(this);
         pane.add(reset, BorderLayout.SOUTH);
         pack();
         setVisible(true);
     }
 
     public void actionPerformed(ActionEvent e) {
         // what to do if guess button is pressed
         if (e.getActionCommand().equals("Guess")) {
             int guess = Integer.parseInt(guessField.getText().trim());  // The number guessed
             int result = guessingGame(guess, guessNumber);              // Checking if they guessed correct or not
             boolean alreadyGuessed = findIfInList(inventory, guess);    // Checking if the user already guessed it. 
 
             // If the user has not already guessed the number
             if (alreadyGuessed == false){
                 inventory[index] = guess;   // add guessed number to the array
                 numberOfGuesses++; 
                 // If the user guessed correctly 
                 if (result == 0) {
                     feedback.setText("Congratulations! You guessed the number " + guessNumber + " correctly in "
                             + numberOfGuesses + " guesses.");
                     feedback.setVisible(true);
                     // Disable buttons
                     guessButton.setEnabled(false);
                     guessField.setEditable(false);  
                 // If the user guessed too low
                 } else if (result == -1) {
                     feedback.setText("Too low!");
                     feedback.setVisible(true);
                 // If the user guessed too high
                 } else {
                     feedback.setText("Too high!");
                     feedback.setVisible(true);
                 }
 
                 // If the user is out of guesses
                 if (numberOfGuesses >= 5 && result != 0) {
                     feedback.setText(
                             "Sorry, you didn't guess the number in time. The correct number was: " + guessNumber);
                     guessNumber = randomNumber(1, 20);  // reset guess number
                     // Disable buttons
                     guessButton.setEnabled(false);
                     guessField.setEditable(false);
                 }
                 index++;
                 if (index > inventory.length-1){
                     index = inventory.length-1;
                 }
             }
             else {
                 JOptionPane.showMessageDialog(this, "You already guessed this number! ", "ALERT", JOptionPane.ERROR_MESSAGE); // Display Alert
             }
         }
 
         // Redo
         if (e.getActionCommand().equals("Redo")) {
             guessField.setText("");
             numberOfGuesses = 0;    // reset numberOfGuessed
             randomNumber(1, 20);    // reset guess number
             reset(inventory);                   // reset the array
             feedback.setVisible(false);
             // enable buttons
             guessButton.setEnabled(true);
             guessField.setEditable(true);
         }
 
     }
 
     /*
      * Method Name: findIfInList 
      * Author: Yunseo Jeon
      * Creation Date; June 3, 2024
      * Description: Check if a number already exists in an array
      * @Parameters: int[] data - The array being searched, int num - The element being looked for.
      * @Return Value: boolean 
      * Data Type: boolean
      * Throws/Exceptions: n/a
      */
     public static boolean findIfInList(int[] data, int num) {
         for (int i = 0; i < data.length; i++) {
             if (data[i] == num) {
                 return true;
             }
         }
         return false;
     }
 
     /*
      * Method Name: reset 
      * Author: Yunseo Jeon
      * Creation Date; June 3, 2024
      * Description: resets the array and index number
      * @Parameters: int[] data - The array being reset
      * @Return Value: None its a procedure 
      * Data Type: n/a
      * Throws/Exceptions: n/a
      */
     public static void reset(int[] data) {
         for (int i = 0; i < data.length; i++) {
            data[i] = 0;
         }
         //reset index
         index = 0;
     }
 
     /*
      * Method Name: randomNumber 
      * Author: Yunseo Jeon
      * Creation Date; June 3, 2024
      * Description: generates a random number between the lower and upper limit
      * @Parameters: int lower - the lower limit, int upper - the upper limit. 
      * @Return Value: int - returns a random number generated 
      * Data Type: int
      * Throws/Exceptions: n/a
      */
     public static int randomNumber(int lower, int upper) {
         return (int) ((Math.random() * (upper - lower + 1)) + lower);
     }
 
     /*
      * Method Name: guessingGame 
      * Author: Yunseo Jeon
      * Creation Date; June 3, 2024
      * Description: Checks if the user guessed the number or if it's too high or too low
      * @Parameters: int guess - the guessed number by the user, randomNumber - The correct guess.  
      * @Return Value: int - returns 0 if its correct, returns -1 if its too low, returns 1 if its too high.
      * Data Type: int
      * Throws/Exceptions: n/a
      */
     public static int guessingGame(int guess, int randomNumber) {
         if (guess == randomNumber) {
             return 0;
         } else if (guess < randomNumber) {
             return -1;
         } else {
             return 1;
         }
     }
 }