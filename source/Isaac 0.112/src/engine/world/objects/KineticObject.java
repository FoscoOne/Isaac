package engine.world.objects;

import engine.common.Material;
import engine.common.Render;
import engine.interfaces.IDataObject;
import engine.interfaces.ILevelObject;
import engine.world.Level;
import org.newdawn.fizzy.Body;
import org.newdawn.fizzy.KinematicBody;
import org.newdawn.fizzy.Shape;
import org.newdawn.slick.Color;
import org.newdawn.slick.Graphics;

public class KineticObject implements ILevelObject {

    protected Body<IDataObject> body;
    protected boolean isAlive = true;
    private Material material;

    public KineticObject(float x, float y, Shape shape, Material material) {
        shape.setDensity(material.density());
        shape.setFriction(material.friction());
        shape.setRestitution(material.friction());
        this.material = material;
        body = new KinematicBody<IDataObject>(shape, x, y);
        Level.getWorld().add(body);
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
