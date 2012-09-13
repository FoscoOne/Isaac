package moduls;

public class Camera {

    // Sirka kamera
    private final int width;
    // Vyska kamery
    private final int height;
    // Pozice kamery X
    private int x = 0;
    // Pozice kamery Y
    private int y = 0;
    // Sirka sveta
    private final int worldWidth;
    // Vyska sveta
    private final int worldHeight;

    public Camera(int width, int height) {
        this.width = width;
        this.height = height;
        this.worldHeight = height;
        this.worldWidth = width;
    }

    public Camera(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.worldHeight = height;
        this.worldWidth = width;
    }

    public Camera(int width, int height, int x, int y, int worldWidth, int worldHeight) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
        this.worldHeight = worldHeight;
        this.worldWidth = worldWidth;
    }

    public void setView(int x, int y) {
        if (x >= 0 && (x + width) <= worldWidth) {
            this.x = x;
        }
        if (y >= 0 && (y + height) <= worldHeight) {
            this.y = y;
        }
    }

    public void setOffset(double offsetX, double offsetY) {
        setView(x + (int) offsetX, y + (int) offsetY);
    }

    public float WorldXToScreenX(float x) {
        return (x - this.x);
    }

    public float WorldYToScreenY(float y) {
        return (y - this.y);
    }

    public float ScreenXToWorldX(float x) {
        return (x + this.x);
    }

    public float ScreenYToWorldY(float y) {
        return (y + this.y);
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }
}
