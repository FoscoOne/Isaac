package engine.world;

import engine.common.Material;
import engine.enums.EObjectType;
import engine.game.states.DemoState;
import engine.interfaces.IDataObject;
import engine.interfaces.ILevel;
import engine.interfaces.ILevelObject;
import engine.world.objects.DataObject;
import engine.world.objects.InvisibleStaticObject;
import engine.world.objects.StaticObject;
import engine.world.objects.TestPlayerObject;
import engine.world.objects.simple.Basketball;
import engine.world.objects.simple.MetalCrate;
import engine.world.objects.simple.Polysteren;
import engine.world.objects.simple.WoodCrate;
import java.util.ArrayList;
import java.util.Iterator;
import library.TextFileReader;
import org.newdawn.fizzy.Circle;
import org.newdawn.fizzy.CollisionEvent;
import org.newdawn.fizzy.Rectangle;
import org.newdawn.fizzy.World;
import org.newdawn.fizzy.WorldListener;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.KeyListener;
import org.newdawn.slick.MouseListener;
import org.newdawn.slick.SlickException;

public class Level implements ILevel, MouseListener, KeyListener {

    private static World world;
    private static ArrayList<ILevelObject> objects;
    private Input input;
    private TestPlayerObject player;
    private final int width;
    private final int height;

    public Level(float x, float y, float width, float height, float gravity, Input input) throws SlickException {
        this.width = (int) width;
        this.height = (int) height;
        world = new World();
        world.setBounds(x, y, width, height);
        world.setGravity(gravity);
        world.setIterations(30);
        world.setOutOfBoundsBehavior(World.OutOfBoundsBehavior.NONE);
        this.input = input;
        objects = new ArrayList<ILevelObject>();
        world.addListener(new WorldListener() {

            @Override
            public void collided(CollisionEvent ce) {
                if (ce.getBodyA().getUserData() instanceof DataObject
                        && ce.getBodyB().getUserData() instanceof DataObject) {
                    IDataObject A = (DataObject) ce.getBodyA().getUserData();
                    IDataObject B = (DataObject) ce.getBodyB().getUserData();
                    if (A.getType() == EObjectType.PLAYER
                            && B.getType() == EObjectType.ITEM) {
                        //System.out.println("kolize s predmetem");
                    }
                }
            }

            @Override
            public void separated(CollisionEvent ce) {
                //System.out.println("separated");
            }
        });
        init();
    }

    private void init() throws SlickException {
        //addToLevel(new StaticObject(50, 400, new Rectangle(1600, 20), Material.STONE));
        //addToLevel(new StaticObject(100, 150, new Rectangle(350, 20), Material.ICE, 10));
        //addToLevel(new StaticObject(10, 10, new Rectangle(10, 570), Material.STONE, -5));

        //addToLevel(new WoodCrate(200, 200, WoodCrate.WOOD_CRATE_50));
        //addToLevel(new MetalCrate(300, 100, MetalCrate.METAL_CRATE_50));

        addToLevel(new InvisibleStaticObject(0, 0, new Rectangle(1000, 240), Material.STONE));
        addToLevel(new InvisibleStaticObject(0, 359, new Rectangle(356, 250), Material.STONE));
        addToLevel(new InvisibleStaticObject(693, 359, new Rectangle(356, 250), Material.STONE));
        player = new TestPlayerObject(50, 277);
        addToLevel(player);

        /*TextFileReader reader = new TextFileReader("data/inits/level_demo");
        Iterator<String> it = reader.getIterator();
        while (it.hasNext()) {
        String s = it.next();
        String[] param = s.split(",");
        double x = Double.valueOf(param[0]);
        double y = Double.valueOf(param[1]);
        String item = param[2];
        if (item.equals("polysteren")) {
        addToLevel(new Polysteren((int) x, (int) y, Polysteren.POLYSTEREN_30x30));
        } else if (item.equals("wood_crate")) {
        addToLevel(new WoodCrate((int) x, (int) y, WoodCrate.WOOD_CRATE_25));
        } else if (item.equals("metal_crate")) {
        addToLevel(new MetalCrate((int) x, (int) y, MetalCrate.METAL_CRATE_50));
        }
        }*/

        //world.setOutOfBoundsBehavior(World.OutOfBoundsBehavior.NONE);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    @Override
    public void update(int delta) {
        for (int i = 0; i < 5; i++) {
            world.update(1 / 70f);
        }
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).update(delta);
        }
    }

    @Override
    public void render(Graphics g) {
        for (int i = 0; i < objects.size(); i++) {
            objects.get(i).render(g);
        }
    }

    public static void addToLevel(ILevelObject o) {
        objects.add(o);
    }

    public static void clearLevel() {
        for (int i = 0; i < objects.size(); i++) {
            world.remove(objects.remove(i).getBody());
        }
    }

    public static World getWorld() {
        return world;
    }

    @Override
    public void mouseWheelMoved(int i) {
    }

    @Override
    public void mouseClicked(int i, int i1, int i2, int i3) {
        int x = i1;
        int y = i2;
        float new_x = DemoState.CAMERA.ScreenXToWorldX(x);
        float new_y = DemoState.CAMERA.ScreenYToWorldY(y);
        System.out.println(new_x + "," + new_y);
//        if (input.isKeyDown(Input.KEY_LSHIFT)) {
//            if (i == 0) {
//                addToLevel(new StaticObject(new_x, new_y, new Circle(15f), Material.GLASS));
//            } else if (i == 1) {
//                addToLevel(new StaticObject(new_x, new_y, new Rectangle(40, 15), Material.STONE));
//            } else if (i == 2) {
//                addToLevel(new StaticObject(new_x, new_y, new Rectangle(40, 40), Material.WOOD));
//            }
//        } else {
//
//            if (i == 0) {
//                try {
//                    addToLevel(new Basketball(new_x, new_y));
//                } catch (SlickException ex) {
//                }
//            } else if (i == 1) {
//                try {
//                    addToLevel(new Polysteren(new_x, new_y, Polysteren.POLYSTEREN_30x30));
//                } catch (SlickException ex) {
//                }
//            } else if (i == 2) {
//                try {
//                    addToLevel(new MetalCrate(new_x, new_y, MetalCrate.METAL_CRATE_50));
//                } catch (SlickException ex) {
//                }
//            }
//        }
    }

    @Override
    public void mousePressed(int i, int i1, int i2) {
    }

    @Override
    public void mouseReleased(int i, int i1, int i2) {
    }

    @Override
    public void mouseMoved(int i, int i1, int i2, int i3) {
    }

    @Override
    public void mouseDragged(int i, int i1, int i2, int i3) {
        //DemoState.CAMERA.setOffset(-(i2 - i), -(i3 - i1));
    }

    @Override
    public void setInput(Input input) {
    }

    @Override
    public boolean isAcceptingInput() {
        return true;
    }

    @Override
    public void inputEnded() {
    }

    @Override
    public void inputStarted() {
    }

    @Override
    public void keyPressed(int i, char c) {
        if (i == 203) {
            player.goLeft();
        }
        if (i == 205) {
            player.goRight();

        }
        if (i == 200) {
            player.jump();
        }
        if (i == 42 || i == 54) {
            player.setIsRunning();
        }
        if (input.isKeyDown(Input.KEY_SPACE)
                && (input.isKeyPressed(Input.KEY_LEFT)
                || input.isKeyPressed(Input.KEY_RIGHT))) {
            player.push();
        }
    }

    @Override
    public void keyReleased(int i, char c) {
        if (i == 203) {
            player.stopWalking();
        }
        if (i == 205) {
            player.stopWalking();
        }
        if (i == 42 || i == 54) {
            player.setNotRunning();
        }
    }
}
