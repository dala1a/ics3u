import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class graphics {
    public static void main(String[] args) {
        NameFrame frame = new NameFrame();
        frame.setSize(1200, 150); 
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class NameFrame extends JFrame implements ActionListener{
    private JLabel feedback;        // "Too high", "Too low", "correct"
    private JTextField guessField;  // Type in guess
    private int guessNumber;        // Guess number
    private int numberOfGuesses;    // # of guesses guessed
    private JButton guessButton;    // guess button
    private JButton reset;          // reset game


    public NameFrame(){
        guessNumber = randomNumber(1,20);
        numberOfGuesses = 0;

        JPanel pane = (JPanel) getContentPane();
        pane.setLayout(new BorderLayout());

        feedback = new JLabel("");
        feedback.setVisible(false); //set false
        guessField = new JTextField();
        guessButton = new JButton("Guess");
        reset = new JButton("Redo");

        //instruction label
        pane.add(new JLabel("Welcome to the Guessing Game! Guess a number between 1 and 20"), BorderLayout.NORTH);

        //Guessing pane (Guess label, textfield, guess button, feedback)
        JPanel guessPane = new JPanel();
        guessPane.setLayout(new GridLayout(2, 2));
        guessPane.add(new JLabel("Your Guess:"));
        guessField.addActionListener(this);
        guessPane.add(guessField);
        guessPane.add(feedback);
        guessButton.addActionListener(this);
        guessPane.add(guessButton);
        pane.add(guessPane, BorderLayout.CENTER);

        //redo button
        reset.addActionListener(this);
        pane.add(reset, BorderLayout.SOUTH);
        pack();
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e) {
        numberOfGuesses++;
        //what to do if guess button is pressed
        if (e.getActionCommand().equals("Guess")){
            int guess = Integer.parseInt(guessField.getText().trim());
            int result = guessingGame(guess, guessNumber);

            if (result == 0) {
                feedback.setText("Congratulations! You guessed the number " + guessNumber + " correctly in " + numberOfGuesses + " guesses.");
                feedback.setVisible(true); 
                guessButton.setEnabled(false);
                guessField.setEditable(false);
               

            } 
            else if (result == -1) {
                feedback.setText("Too low!");
                feedback.setVisible(true); 
                
            } 
            else {
                feedback.setText("Too high!");
                feedback.setVisible(true); 
            }

            if (numberOfGuesses >= 5 && result != 0) {
                feedback.setText("Sorry, you didn't guess the number in time. The correct number was: " + guessNumber);
                guessNumber = randomNumber(1, 20);
                guessButton.setEnabled(false);
                guessField.setEditable(false);
                }

            }
        if (e.getActionCommand().equals("Redo")){
            guessField.setText("");
            numberOfGuesses = 0;
            randomNumber(1, 20);
            feedback.setVisible(false);
            guessButton.setEnabled(true);
            guessField.setEditable(true);
        }

    }   

    public static int randomNumber(int lower, int upper) {
        return (int) ((Math.random() * (upper - lower + 1)) + lower);
    }

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