package demo;

import engine.Game;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.SlickException;

public class Demo {

    public static void main(String[] args) throws SlickException {
        AppGameContainer app = new AppGameContainer(new Game());
        app.setDisplayMode(800, 600, false);
        app.setSmoothDeltas(true);
        app.setTargetFrameRate(40);
        app.start();
    }
}
