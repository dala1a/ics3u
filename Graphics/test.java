import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class test {
    private static int randomNumber;
    private static int numberOfGuesses;
    private static boolean guessedCorrectly;

    public static void main(String[] args) {
        randomNumber = randomNumber(1, 20);
        numberOfGuesses = 0;
        guessedCorrectly = false;

        JFrame frame = new JFrame("Guessing Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1));

        JLabel instructionLabel = new JLabel("Welcome to the Guessing Game! Guess a number between 1 and 20.");
        JLabel feedbackLabel = new JLabel("");
        JTextField guessField = new JTextField();
        JButton guessButton = new JButton("Guess");
        JLabel resultLabel = new JLabel("");

        panel.add(instructionLabel);
        panel.add(guessField);
        panel.add(guessButton);
        panel.add(feedbackLabel);
        panel.add(resultLabel);

        frame.add(panel);
        frame.setVisible(true);

        guessButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String guessText = guessField.getText();
                try {
                    int guess = Integer.parseInt(guessText);
                    int result = guessingGame(guess, randomNumber);

                    if (result == 0) {
                        feedbackLabel.setText("Correct!");
                        guessedCorrectly = true;
                    } else if (result == -1) {
                        feedbackLabel.setText("Too low!");
                    } else {
                        feedbackLabel.setText("Too high!");
                    }

                    numberOfGuesses++;
                    if (guessedCorrectly) {
                        resultLabel.setText("Congratulations! You guessed the number " + randomNumber + " correctly in " + numberOfGuesses + " guesses.");
                        resetGame();
                    } else if (numberOfGuesses >= 5) {
                        resultLabel.setText("Sorry, you didn't guess the number in time. The correct number was: " + randomNumber);
                        resetGame();
                    }
                } catch (NumberFormatException ex) {
                    feedbackLabel.setText("Please enter a valid number.");
                }
                guessField.setText("");
            }
        });
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

    private static void resetGame() {
        randomNumber = randomNumber(1, 20);
        numberOfGuesses = 0;
        guessedCorrectly = false;
    }
}
