package engine.windows;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Plane {
    public String path;
    Graphics g;
    public int x;
    public int y;

    public Plane(String path, Graphics g, int x, int y) {
        this.path = path;
        this.g = g;
        this.x = x;
        this.y = y;
    }

    public void drawPlane() {
        if (g != null) {
            BufferedImage plane = null;
            try {
                plane = ImageIO.read(new File(path));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            g.drawImage(plane, x, y, null);
        }
    }

    public void makePlane() {
        this.drawPlane();
    }

    public void Move(int x, int y) {
        this.x = x;
        this.y = y;
        repaint();
    }

    private void repaint() {
        if (g != null) {
            g.setColor(Color.WHITE);
            g.fillRect(x, y, 100, 100);
            drawPlane();
        }
    }
}
