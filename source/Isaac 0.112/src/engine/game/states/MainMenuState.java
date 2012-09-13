package engine.game.states;

import engine.Game;
import engine.loaders.ImageLoader;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MainMenuState extends BasicGameState {

    private final int stateID;
    private Image background = null;

    public MainMenuState(int stateID) {
        this.stateID = stateID;
    }

    @Override
    public int getID() {
        return stateID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        background = ImageLoader.getImage("main_menu_background");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        grphcs.drawImage(background, 0, 0);
        grphcs.drawString("PRESS SPACE TO START DEMO", 300, 300);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        int mouseX = input.getMouseX();
        int mouseY = input.getMouseY();
        boolean newGame = false;
        boolean quitGame = false;
        if (input.isKeyPressed(Input.KEY_SPACE)) {
            sbg.addState(new DemoState(Game.DEMO_STATE));
            sbg.getState(Game.DEMO_STATE).init(gc, sbg);
            sbg.enterState(Game.DEMO_STATE);
        }
        if (newGame) {
            sbg.enterState(Game.GAMEPLAY_STATE);
        }
        if (quitGame) {
            gc.exit();
        }
    }
}
