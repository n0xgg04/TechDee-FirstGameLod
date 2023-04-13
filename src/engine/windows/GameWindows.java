package engine.windows;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class GameWindows extends Frame implements Runnable, KeyListener {
    private Game gameG;
    private BufferedImage bufferImg;
    private Graphics bufferG;
    private ScheduledExecutorService executorService;

    public GameWindows() {
        super();
        this.setTitle("Mao phắc");
        this.setSize(480, 800);
        this.setResizable(false);
        this.addKeyListener(this);
        this.setVisible(true);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent e) {
                dispose();
            }
        });
        this.bufferImg = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
        this.bufferG = bufferImg.getGraphics();
        this.gameG = new Game(bufferG);
    }

    @Override
    public void update(Graphics g) {

        paint(g);
    }

    @Override
    public void paint(Graphics g) {
        try {
            this.gameG.Start();
        }catch(Exception ie){

        }
        g.drawImage(bufferImg, 0, 0, null);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        if(!this.gameG.isStarted()) {
            this.gameG.setStarted();
            System.out.println("Game started");
        }

        switch (keyCode) {
            case KeyEvent.VK_UP:
                break;
            case KeyEvent.VK_DOWN:
                break;
            case KeyEvent.VK_LEFT:
                break;
            case KeyEvent.VK_RIGHT:

                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        char keyChar = e.getKeyChar();
       // System.out.println("Key typed: " + keyChar);
    }

    @Override
    public void run() {
        repaint();
        while (true) {
            updateGame();
            repaint();
        }
    }

    private void updateGame() {
        // Update the game logic here
    }

    public void start() {
        this.executorService = Executors.newSingleThreadScheduledExecutor();
        this.executorService.scheduleAtFixedRate(this, 0, 16, TimeUnit.MILLISECONDS);
    }

    public static void main(String[] args) {
        GameWindows game = new GameWindows();
        game.setVisible(true);
        game.start();
    }
}
