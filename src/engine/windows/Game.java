package engine.windows;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import engine.windows.Plane;

public class Game extends Frame{
    public Graphics g;
    public Plane plane;
    public int x = 100;
    public int y = 700;
    public boolean bgSetupComplete = false;
    private boolean started = false;

    public Game(Graphics g){
        this.g = g;
        System.out.println("Game created");
        //set color to black
        g.setColor(Color.BLACK);
        g.drawString("Press any key to start", 100, 100);
    }

    public boolean isStarted() {
        return this.started;
    }
    public void setStarted(){
        this.started = true;
    }

    public void setFrameG(Graphics g){
        this.g = g;
    }
    public void setBackGround(Graphics g,String path){
        BufferedImage BG = null;
        try {
            BG = ImageIO.read(new File(path));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        g.drawImage(BG, 0, 0, null);
        this.bgSetupComplete = true;
    }

    public void Start(){
        if(!this.started){
            //System.out.println("Hasn't started!! Wait user click to screen");
            //set color for string
            return;
        }
        if(!this.bgSetupComplete) {
            setBackGround(g, "Resources/Background.png");
            System.out.println("Background setted");
        }
        this.plane = new Plane("Resources/PLANE1.png", g, this.x, this.y);
        this.plane.makePlane();
    }
}