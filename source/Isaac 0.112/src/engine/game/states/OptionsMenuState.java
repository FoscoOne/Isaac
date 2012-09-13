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

public class OptionsMenuState extends BasicGameState {

    private final int stateID;
    private Image background = null;

    public OptionsMenuState(int stateID) {
        this.stateID = stateID;
    }

    @Override
    public int getID() {
        return stateID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        background = ImageLoader.getImage("options_menu_background");
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        grphcs.drawImage(background, 0, 0);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();
        int mouseX = input.getMouseX();
        int mouseY = input.getMouseY();
        boolean exitGame = false;
        boolean resumeGame = false;
        if (resumeGame) {
            sbg.enterState(Game.GAMEPLAY_STATE);
        }
        if (exitGame) {
            sbg.enterState(Game.MAIN_MENU_STATE);
        }
    }
}
