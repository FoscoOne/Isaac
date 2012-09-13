package engine.game.states;

import data.Loader;
import engine.Game;
import engine.loaders.ImageLoader;
import engine.loaders.MusicLoader;
import engine.loaders.SoundLoader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.Sound;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class LoadingState extends BasicGameState {

    private final int stateID;
    private boolean done = false;
    private Image background = null;
    private int step = 0;
    private int steps = 0;
    private ArrayList<String> files = new ArrayList<String>();

    public LoadingState(int stateID) {
        this.stateID = stateID;
    }

    @Override
    public int getID() {
        return stateID;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
        this.background = new Image("data/images/gamestates/loading/loading_background.jpg");

        System.out.println("Searching directories");

        if (isJAR()) {
            loadResourceInnerJAR();
        } else {
            loadResourceOuterJAR();
        }

        System.out.println("Files to load: " + steps);
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        grphcs.drawImage(background, 0, 0);
        grphcs.setColor(Color.white);

        grphcs.fillRect(10, 580, (int) (780 * ((double) step / (double) steps)), 10);

        if (!done) {
            grphcs.drawString(Math.round((float) step / (float) steps * 100) + "%", 10, 560);
        }

        if (done) {
            background = new Image("data/images/gamestates/loading/loading_background_done.jpg");
            grphcs.drawString("Press space to continue", 300, 560);
        }
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
        Input input = gc.getInput();

        if (done) {
            if (input.isKeyPressed(Input.KEY_SPACE)) {
                sbg.enterState(Game.MAIN_MENU_STATE);
            }
        } else {
            if (files.isEmpty()) {
                sbg.addState(new MainMenuState(Game.MAIN_MENU_STATE));
                sbg.addState(new OptionsMenuState(Game.OPTIONS_MENU_STATE));
                sbg.addState(new HelpMenuState(Game.HELP_MENU_STATE));
                sbg.addState(new GameplayState(Game.GAMEPLAY_STATE));
                sbg.addState(new GamePlayInitializationState(Game.GAMEPLAY_INITIALIZATION_STATE));
                sbg.getState(Game.MAIN_MENU_STATE).init(gc, sbg);
                sbg.getState(Game.OPTIONS_MENU_STATE).init(gc, sbg);
                sbg.getState(Game.HELP_MENU_STATE).init(gc, sbg);
                done = true;
                System.out.println("Loading complete");
            } else {
                if (files.get(0).contains("images")) {
                    String path = files.get(0);
                    String key = path.substring((path.lastIndexOf("/") > path.lastIndexOf("\\") ? path.lastIndexOf("/") : path.lastIndexOf("\\")) + 1, path.lastIndexOf("."));
                    ImageLoader.load(key, new Image(files.remove(0)));
                } else if (files.get(0).contains("sounds")) {
                    String path = files.get(0);
                    String key = path.substring((path.lastIndexOf("/") > path.lastIndexOf("\\") ? path.lastIndexOf("/") : path.lastIndexOf("\\")) + 1, path.lastIndexOf("."));
                    SoundLoader.load(key, new Sound(files.remove(0)));
                } else if (files.get(0).contains("music")) {
                    String path = files.get(0);
                    String key = path.substring((path.lastIndexOf("/") > path.lastIndexOf("\\") ? path.lastIndexOf("/") : path.lastIndexOf("\\")) + 1, path.lastIndexOf("."));
                    MusicLoader.load(key, new Music(files.remove(0)));
                }
                step++;
            }
        }
    }

    private boolean isJAR() {
        try {
            JarFile jf = new JarFile("Isaac.jar");
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    private void loadResourceOuterJAR() {
        ArrayList<File> dirs = new ArrayList<File>();

        try {
            dirs.add(new File(Loader.getFile("data/images").getPath()));
        } catch (NullPointerException ex) {
            System.out.println("ERROR: Directory 'images' not found");
        }

        while (!dirs.isEmpty()) {
            File adresar = dirs.remove(0);
            if (adresar.exists()) {
                File[] soubory = adresar.listFiles();
                for (File s : soubory) {

                    if (s.getName().contains(".")) {
                        files.add(s.getPath());
                        steps++;
                    } else {
                        dirs.add(s);
                    }
                }
            } else {
                System.out.println("Directory " + adresar.getName() + " doesn't exist");
                adresar.mkdir();
            }
        }

        try {
            dirs.add(new File(Loader.getFile("date/sounds").getPath()));
        } catch (NullPointerException ex) {
            System.out.println("ERROR: Directory 'sounds' not found");
        }

        while (!dirs.isEmpty()) {
            File adresar = dirs.remove(0);
            if (adresar.exists()) {
                File[] soubory = adresar.listFiles();
                for (File s : soubory) {

                    if (s.getName().contains(".")) {
                        files.add(s.getPath());
                        steps++;
                    } else {
                        dirs.add(s);
                    }
                }
            } else {
                System.out.println("Directory " + adresar.getName() + " doesn't exist");
                adresar.mkdir();
            }
        }

        try {
            dirs.add(new File(Loader.getFile("date/music").getPath()));
        } catch (NullPointerException ex) {
            System.out.println("ERROR: Directory 'music' not found");
        }

        while (!dirs.isEmpty()) {
            File adresar = dirs.remove(0);
            if (adresar.exists()) {
                File[] soubory = adresar.listFiles();
                for (File s : soubory) {

                    if (s.getName().contains(".")) {
                        files.add(s.getPath());
                        steps++;
                    } else {
                        dirs.add(s);
                    }
                }
            } else {
                System.out.println("Directory " + adresar.getName() + " doesn't exist");
                adresar.mkdir();
            }
        }
    }

    private void loadResourceInnerJAR() {
        JarFile jarFile;
        try {
            jarFile = new JarFile("Isaac.jar");
            Enumeration e = jarFile.entries();

            while (e.hasMoreElements()) {
                JarEntry entry = (JarEntry) e.nextElement();

                String filename = entry.getName();

                if (filename.contains("/images/") && filename.contains(".")) {
                    files.add(filename);
                    steps++;
                } else if (filename.contains("/sounds/") && filename.contains(".")) {
                    files.add(filename);
                    steps++;
                } else if (filename.contains("/music/") && filename.contains(".")) {
                    files.add(filename);
                    steps++;
                }
            }
        } catch (IOException ex) {
            System.out.println("ERROR: No files!");
        }

    }
}
