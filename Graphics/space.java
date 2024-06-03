import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class space extends JFrame {
    public space() {
        initUI();
    }

    private void initUI() {
        add(new GameBoard());
        setTitle("Space Invaders");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            space game = new space();
            game.setVisible(true);
        });
    }

    class GameBoard extends JPanel implements ActionListener {
        private Timer timer;
        private Player player;
        private List<Alien> aliens;
        private List<Bullet> bullets;

        public GameBoard() {
            initBoard();
        }

        private void initBoard() {
            addKeyListener(new TAdapter());
            setFocusable(true);
            setBackground(Color.BLACK);
            setPreferredSize(new Dimension(400, 300));

            player = new Player();
            aliens = new ArrayList<>();
            bullets = new ArrayList<>();

            for (int i = 0; i < 5; i++) {
                aliens.add(new Alien(50 + i * 50, 30));
            }

            timer = new Timer(10, this);
            timer.start();
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawObjects(g);
            Toolkit.getDefaultToolkit().sync();
        }

        private void drawObjects(Graphics g) {
            g.drawImage(player.getImage(), player.getX(), player.getY(), this);

            for (Alien alien : aliens) {
                g.drawImage(alien.getImage(), alien.getX(), alien.getY(), this);
            }

            for (Bullet bullet : bullets) {
                g.drawImage(bullet.getImage(), bullet.getX(), bullet.getY(), this);
            }
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            updatePlayer();
            updateBullets();
            updateAliens();
            checkCollisions();
            repaint();
        }

        private void updatePlayer() {
            player.move();
        }

        private void updateBullets() {
            List<Bullet> toRemove = new ArrayList<>();
            for (Bullet bullet : bullets) {
                if (bullet.isVisible()) {
                    bullet.move();
                } else {
                    toRemove.add(bullet);
                }
            }
            bullets.removeAll(toRemove);
        }

        private void updateAliens() {
            for (Alien alien : aliens) {
                alien.move();
            }
        }

        private void checkCollisions() {
            for (Bullet bullet : bullets) {
                for (Alien alien : aliens) {
                    if (bullet.getBounds().intersects(alien.getBounds())) {
                        bullet.setVisible(false);
                        aliens.remove(alien);
                        break;
                    }
                }
            }
        }

        private class TAdapter extends KeyAdapter {
            @Override
            public void keyReleased(KeyEvent e) {
                player.keyReleased(e);
            }

            @Override
            public void keyPressed(KeyEvent e) {
                player.keyPressed(e);

                int key = e.getKeyCode();
                if (key == KeyEvent.VK_SPACE) {
                    bullets.add(new Bullet(player.getX(), player.getY()));
                }
            }
        }

        class Player {
            private int x;
            private int y;
            private int dx;
            private int dy;
            private Image image;

            public Player() {
                initPlayer();
            }

            private void initPlayer() {
                ImageIcon ii = new ImageIcon("player.png");
                image = ii.getImage();
                x = 40;
                y = 60;
            }

            public void move() {
                x += dx;
                y += dy;
            }

            public int getX() {
                return x;
            }

            public int getY() {
                return y;
            }

            public Image getImage() {
                return image;
            }

            public void keyPressed(KeyEvent e) {
                int key = e.getKeyCode();

                if (key == KeyEvent.VK_LEFT) {
                    dx = -1;
                }

                if (key == KeyEvent.VK_RIGHT) {
                    dx = 1;
                }

                if (key == KeyEvent.VK_UP) {
                    dy = -1;
                }

                if (key == KeyEvent.VK_DOWN) {
                    dy = 1;
                }
            }

            public void keyReleased(KeyEvent e) {
                int key = e.getKeyCode();

                if (key == KeyEvent.VK_LEFT) {
                    dx = 0;
                }

                if (key == KeyEvent.VK_RIGHT) {
                    dx = 0;
                }

                if (key == KeyEvent.VK_UP) {
                    dy = 0;
                }

                if (key == KeyEvent.VK_DOWN) {
                    dy = 0;
                }
            }
        }

        class Alien {
            private int x;
            private int y;
            private Image image;

            public Alien(int x, int y) {
                initAlien(x, y);
            }

            private void initAlien(int x, int y) {
                this.x = x;
                this.y = y;
                ImageIcon ii = new ImageIcon("alien.png");
                image = ii.getImage();
            }

            public int getX() {
                return x;
            }

            public int getY() {
                return y;
            }

            public Image getImage() {
                return image;
            }

            public void move() {
                y += 1;
            }

            public Rectangle getBounds() {
                return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
            }
        }

        class Bullet {
            private int x;
            private int y;
            private Image image;
            private boolean visible;

            public Bullet(int x, int y) {
                initBullet(x, y);
            }

            private void initBullet(int x, int y) {
                ImageIcon ii = new ImageIcon("bullet.png");
                image = ii.getImage();
                visible = true;
                this.x = x;
                this.y = y;
            }

            public void move() {
                y -= 2;
                if (y < 0) {
                    visible = false;
                }
            }

            public int getX() {
                return x;
            }

            public int getY() {
                return y;
            }

            public Image getImage() {
                return image;
            }

            public boolean isVisible() {
                return visible;
            }

            public Rectangle getBounds() {
                return new Rectangle(x, y, image.getWidth(null), image.getHeight(null));
            }

            public void setVisible(boolean visible) {
                this.visible = visible;
            }
        }
    }
}
