package engine.game.states;

import engine.common.Camera;
import engine.loaders.ImageLoader;
import engine.world.Level;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class DemoState extends BasicGameState {

    private final int stateID;
    private Level level;
    public static Camera CAMERA;
    private static Image levelBackground = null;

    public DemoState(int stateID) {
        this.stateID = stateID;
    }

    @Override
    public int getID() {
        return stateID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        System.out.println("Demo inicialized");

        level = new Level(0, 0, 1000, 600, 10, gc.getInput());
        CAMERA = new Camera(800, 600, 0, 0, level.getWidth(), level.getHeight());
        gc.getInput().addMouseListener(level);
        gc.getInput().addKeyListener(level);
        levelBackground = ImageLoader.getImage("demo_level");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        grphcs.setAntiAlias(true);
        grphcs.pushTransform();
        grphcs.translate(-CAMERA.getX(), -CAMERA.getY());
        grphcs.drawImage(levelBackground, 0, 0);
        level.render(grphcs);
        grphcs.popTransform();
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        level.update(i);
    }
}
