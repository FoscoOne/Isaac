package engine.world.objects;

import engine.common.Material;
import engine.enums.EObjectType;
import engine.enums.ESide;
import engine.game.states.DemoState;
import engine.loaders.ImageLoader;
import org.newdawn.fizzy.Rectangle;
import org.newdawn.slick.Graphics;

public class TestPlayerObject extends DynamicObject {

    private boolean goLeft = false;
    private boolean goRight = false;
    private boolean isRunning = false;
    private boolean imageChanged = false;
    private ESide side = ESide.RIGHT;

    public TestPlayerObject(float x, float y) {
        super(x, y, new Rectangle(40, 80), Material.PLAYER);
        body.setUserData(new DataObject(EObjectType.PLAYER, ImageLoader.getImage("isaac")));
        body.setFixedRotation(true);
    }

    @Override
    public void update(int delta) {
        super.update(delta);
        DemoState.CAMERA.setOffset(body.getXVelocity() * 0.8, body.getYVelocity() * 0.8);
        if (goLeft) {
            //DemoState.CAMERA.setOffset(body.getXVelocity(), 0);
            if (body.getXVelocity() > -6) {
                body.applyForce(-1000, 0);
            } else if (isRunning && body.getXVelocity() > -10) {
                body.applyForce(-1400, 0);
            }
        } else if (goRight) {
            //DemoState.CAMERA.setOffset(body.getXVelocity(), 0);
            if (body.getXVelocity() < 6) {
                body.applyForce(1000, 0);
            } else if (isRunning && body.getXVelocity() < 10) {
                body.applyForce(1400, 0);
            }
        }
    }

    public void jump() {
        if (body.getYVelocity() < 0.1) {
            body.applyImpulse(0, -400);
        }
    }

    public void goLeft() {
        goLeft = true;
        side = ESide.LEFT;
        if (!imageChanged) {
            body.getUserData().setImage(body.getUserData().getImage().getFlippedCopy(true, false));
            imageChanged = true;
        }
    }

    public void goRight() {
        goRight = true;
        side = ESide.RIGHT;
        if (imageChanged) {
            body.getUserData().setImage(body.getUserData().getImage().getFlippedCopy(true, false));
            imageChanged = false;
        }
    }

    public void stopWalking() {
        if (goLeft) {
            goLeft = false;
        }
        if (goRight) {
            goRight = false;
        }
    }

    public void setIsRunning() {
        isRunning = true;
    }

    public void setNotRunning() {
        isRunning = false;
    }

    @Override
    public void render(Graphics g) {
        super.render(g);
    }

    public void push() {
        if (side == ESide.LEFT) {
            body.applyImpulse(-250, 0);
        } else if (side == ESide.RIGHT) {
            body.applyImpulse(250, 0);
        }
    }
}
