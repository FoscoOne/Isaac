package engine.world.objects.simple;

import engine.common.Material;
import engine.enums.EObjectType;
import engine.loaders.ImageLoader;
import engine.world.objects.DataObject;
import engine.world.objects.DynamicObject;
import org.newdawn.fizzy.Rectangle;
import org.newdawn.slick.SlickException;

public class Polysteren extends DynamicObject {
    
    public static final int POLYSTEREN_10x10 = 10;
    public static final int POLYSTEREN_30x30 = 30;
    
    public Polysteren(float x, float y, int type) throws SlickException {
        super(x, y, new Rectangle(type, type), Material.POLYSTYRENE);
        body.setUserData(new DataObject(EObjectType.ITEM, ImageLoader.getImage("polysteren_" + type + "x" + type)));
    }
}
