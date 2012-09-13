package engine.world.objects;

import engine.common.Render;
import engine.common.Material;
import engine.interfaces.IDataObject;
import engine.interfaces.ILevelObject;
import engine.world.Level;
import org.newdawn.fizzy.Body;
import org.newdawn.fizzy.Shape;
import org.newdawn.fizzy.StaticBody;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class StaticObject implements ILevelObject {

    protected Body<IDataObject> body;
    protected boolean isAlive = true;
    Material material;

    public StaticObject(float x, float y, Shape shape, Material material, float degrees) {
        shape.setDensity(material.density());
        shape.setFriction(material.friction());
        shape.setRestitution(material.restitution());
        body = new StaticBody<IDataObject>(shape, x, y);
        Level.getWorld().add(body);
        body.setRotation((float) Math.toRadians(degrees));
        this.material = material;
    }

    public StaticObject(float x, float y, Shape shape, Material material) {
        shape.setDensity(material.density());
        shape.setFriction(material.friction());
        shape.setRestitution(material.restitution());
        body = new StaticBody(shape, x, y);
        Level.getWorld().add(body);
        this.material = material;
    }

    @Override
    public void update(int delta) {
    }

    @Override
    public void render(Graphics g) {
        if (body.getUserData() != null) {
            if (body.getUserData().isAnimated()) {
                Render.drawBodyAnimation(g, body, body.getUserData().getAnimation());
            } else {
                if (body.getUserData().getImage() != null) {
                    Render.drawBodyImage(g, body, body.getUserData().getImage());
                } else {
                    Color c = g.getColor();
                    g.setColor(material.getColor());
                    Render.drawBody(g, body);
                    g.setColor(c);
                }
            }
        } else {
            Color c = g.getColor();
            g.setColor(material.getColor());
            Render.drawBody(g, body);
            g.setColor(c);
        }
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void notifyDeath() {
        if (isAlive) {
            this.isAlive = false;
        }
    }

    @Override
    public Body getBody() {
        return body;
    }
}
