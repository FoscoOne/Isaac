package engine.world.objects.simple;

import engine.common.Material;
import engine.enums.EObjectType;
import engine.loaders.ImageLoader;
import engine.world.objects.DataObject;
import engine.world.objects.DynamicObject;
import org.newdawn.fizzy.Circle;
import org.newdawn.slick.SlickException;

public class Basketball extends DynamicObject {

    public Basketball(float x, float y) throws SlickException {
        super(x, y, new Circle(12.5f), Material.RUBBER);
        body.setUserData(new DataObject(EObjectType.ITEM, ImageLoader.getImage("basketball")));
    }
}
