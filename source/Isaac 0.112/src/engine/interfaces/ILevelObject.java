package engine.interfaces;

import org.newdawn.fizzy.Body;
import org.newdawn.slick.Graphics;

public interface ILevelObject {

    void update(int delta);

    void render(Graphics g);

    boolean isAlive();

    void notifyDeath();

    Body getBody();
}
