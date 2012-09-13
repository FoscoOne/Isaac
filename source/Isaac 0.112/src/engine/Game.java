package engine;

import engine.game.states.LoadingState;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Game extends StateBasedGame {

    public static final int LOADING_STATE = 0;
    public static final int MAIN_MENU_STATE = 1;
    public static final int GAMEPLAY_STATE = 2;
    public static final int OPTIONS_MENU_STATE = 3;
    public static final int HELP_MENU_STATE = 4;
    public static final int GAME_OVER_STATE = 5;
    public static final int GAMEPLAY_INITIALIZATION_STATE = 6;
    public static final int DEMO_STATE = 7;

    public Game() {
        super("Isaac");
        this.addState(new LoadingState(LOADING_STATE));
        this.enterState(LOADING_STATE);
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
   
    }
}
