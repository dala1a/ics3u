import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConnectFourGUI extends JFrame {
    private char[][] grid = new char[6][7];
    private JButton[] buttons = new JButton[7];
    private JPanel gridPanel;
    private JLabel statusLabel;
    private char player = 'R';
    private boolean winner = false;

    public ConnectFourGUI() {
        setTitle("Connect Four");
        setSize(700, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Initialize grid
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                grid[row][col] = ' ';
            }
        }

        JPanel buttonPanel = new JPanel(new GridLayout(1, 7));
        for (int i = 0; i < 7; i++) {
            JButton button = new JButton(Integer.toString(i));
            button.addActionListener(new ColumnButtonListener(i));
            buttons[i] = button;
            buttonPanel.add(button);
        }
        add(buttonPanel, BorderLayout.NORTH);

        gridPanel = new JPanel(new GridLayout(6, 7));
        add(gridPanel, BorderLayout.CENTER);

        statusLabel = new JLabel("Player R's turn");
        add(statusLabel, BorderLayout.SOUTH);

        updateGrid();
    }

    private void updateGrid() {
        gridPanel.removeAll();
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                JPanel cell = new JPanel();
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                if (grid[row][col] == 'R') {
                    cell.setBackground(Color.RED);
                } else if (grid[row][col] == 'B') {
                    cell.setBackground(Color.BLACK);
                } else {
                    cell.setBackground(Color.WHITE);
                }
                gridPanel.add(cell);
            }
        }
        gridPanel.revalidate();
        gridPanel.repaint();
    }

    private boolean validatePlay(int column) {
        return column >= 0 && column < grid[0].length && grid[0][column] == ' ';
    }

    private boolean isWinner(char player) {
        // Check for 4 across
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length - 3; col++) {
                if (grid[row][col] == player &&
                    grid[row][col+1] == player &&
                    grid[row][col+2] == player &&
                    grid[row][col+3] == player) {
                    return true;
                }
            }
        }
        // Check for 4 up and down
        for (int row = 0; row < grid.length - 3; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == player &&
                    grid[row+1][col] == player &&
                    grid[row+2][col] == player &&
                    grid[row+3][col] == player) {
                    return true;
                }
            }
        }
        // Check upward diagonal
        for (int row = 3; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length - 3; col++) {
                if (grid[row][col] == player &&
                    grid[row-1][col+1] == player &&
                    grid[row-2][col+2] == player &&
                    grid[row-3][col+3] == player) {
                    return true;
                }
            }
        }
        // Check downward diagonal
        for (int row = 0; row < grid.length - 3; row++) {
            for (int col = 0; col < grid[0].length - 3; col++) {
                if (grid[row][col] == player &&
                    grid[row+1][col+1] == player &&
                    grid[row+2][col+2] == player &&
                    grid[row+3][col+3] == player) {
                    return true;
                }
            }
        }
        return false;
    }

    private class ColumnButtonListener implements ActionListener {
        private int column;

        public ColumnButtonListener(int column) {
            this.column = column;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!winner && validatePlay(column)) {
                for (int row = grid.length - 1; row >= 0; row--) {
                    if (grid[row][column] == ' ') {
                        grid[row][column] = player;
                        break;
                    }
                }

                winner = isWinner(player);
                updateGrid();

                if (winner) {
                    statusLabel.setText("Player " + player + " wins!");
                } else if (isGridFull()) {
                    statusLabel.setText("Tie game");
                } else {
                    player = (player == 'R') ? 'B' : 'R';
                    statusLabel.setText("Player " + player + "'s turn");
                }
            }
        }

        private boolean isGridFull() {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[0][col] == ' ') {
                    return false;
                }
            }
            return true;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ConnectFourGUI().setVisible(true);
            }
        });
    }
}
