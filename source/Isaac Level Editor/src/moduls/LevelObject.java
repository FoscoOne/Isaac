package moduls;

import forms.Tools;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import javax.imageio.ImageIO;

public class LevelObject implements Serializable {

    private int x;
    private int y;
    private int width;
    private int height;
    private double arc;
    private String name;
    private String imagePath = null;
    private boolean locked = false;

    public LevelObject(int x, int y, int width, int height, String name) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.arc = 0;
        this.name = name;
    }

    public LevelObject(int x, int y, File imageFile, String name) {
        this.x = x;
        this.y = y;
        BufferedImage bi = null;
        if (imageFile != null) {
            this.imagePath = imageFile.getPath();
            try {
                bi = ImageIO.read(imageFile);
                ImageLoader.load(name, bi);
            } catch (IOException ex) {
            }
        }
        if (bi != null) {
            this.width = bi.getWidth();
            this.height = bi.getHeight();
        } else {
            this.width = 0;
            this.height = 0;
        }
        this.arc = 0;
        this.name = name;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public double getArc() {
        return arc;
    }

    public void setArc(double arc) {
        this.arc = arc;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public void draw(Graphics2D g) {
        if (ImageLoader.getImage(name) == null) {
            if (name.equals("Rectangle")) {
                g.drawRect(x, y, width, height);
            } else if (name.equals("Circle")) {
                g.drawOval(x, y, width, height);
            }
        } else {
            g.drawImage(ImageLoader.getImage(name), x, y, null);
        }
        if (Tools.isDebugModeOn()) {
            g.drawString("[" + x + "," + y + "], " + width + " x " + height, x + 5, y + 15);
        }
    }

    public void setOffset(int offsetx, int offsety) {
        if (!locked) {
            this.x += offsetx;
            this.y += offsety;
        }
    }

    public void setLocked() {
        locked = true;
    }

    public void setUnlocked() {
        locked = false;
    }

    public boolean isLocked() {
        return locked;
    }
}
