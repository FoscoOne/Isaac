package engine.world.objects;

import engine.common.Material;
import org.newdawn.fizzy.Shape;
import org.newdawn.slick.Graphics;

public class InvisibleStaticObject extends StaticObject {

    public InvisibleStaticObject(float x, float y, Shape shape, Material material) {
        super(x, y, shape, material);
    }

    public InvisibleStaticObject(float x, float y, Shape shape, Material material, float degrees) {
        super(x, y, shape, material, degrees);
    }

    @Override
    public void render(Graphics g) {
        // not render
    }
}
