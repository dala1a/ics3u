import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class graph {
    public static void main(String[] args) {
        NameFrame frame = new NameFrame();
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class NameFrame extends JFrame implements ActionListener {
    private JLabel feedback;
    private JTextField guessField;
    private JLabel result;

    private int number;
    private int numberOfGuesses;

    public NameFrame() {
        number = randomNumber(1, 20);
        numberOfGuesses = 0;

        JPanel pane = (JPanel) getContentPane();
        pane.setLayout(new BorderLayout());

        feedback = new JLabel("");
        guessField = new JTextField();
        result = new JLabel("");
        result.setVisible(false);

        JPanel instructionsPane = new JPanel();
        instructionsPane.setLayout(new BorderLayout());
        instructionsPane.add(new JLabel("Welcome to the Guessing Game! Guess a number between 1 and 20."), BorderLayout.NORTH);

        JPanel guessPane = new JPanel();
        guessPane.setLayout(new GridLayout(1, 2));
        guessPane.add(new JLabel("Your Guess:"));
        guessPane.add(guessField);
        guessField.addActionListener(this);

        JPanel submitPane = new JPanel();
        submitPane.setLayout(new FlowLayout());
        JButton guessButton = new JButton("Guess");
        guessButton.addActionListener(this);
        submitPane.add(guessButton);

        pane.add(instructionsPane, BorderLayout.NORTH);
        pane.add(guessPane, BorderLayout.CENTER);
        pane.add(submitPane, BorderLayout.SOUTH);
        pane.add(feedback, BorderLayout.WEST);
        pane.add(result, BorderLayout.EAST);

        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Guess") || e.getSource() == guessField) {
            int guess = Integer.parseInt(guessField.getText().trim());
            int resultCode = guessingGame(guess, number);

            if (resultCode == 0) {
                feedback.setText("Correct!");
                result.setText("Congratulations! You guessed the number " + number + " correctly in " + numberOfGuesses + " guesses.");
                number = randomNumber(1, 20);
                numberOfGuesses = 0;
            } else if (resultCode == -1) {
                feedback.setText("Too low!");
            } else {
                feedback.setText("Too high!");
            }

            numberOfGuesses++;

            if (numberOfGuesses >= 5 && resultCode != 0) {
                result.setText("Sorry, you didn't guess the number in time. The correct number was: " + number);
                number = randomNumber(1, 20);
                numberOfGuesses = 0;
            }
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
