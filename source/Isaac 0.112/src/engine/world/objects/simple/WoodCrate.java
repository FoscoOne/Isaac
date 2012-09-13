package engine.world.objects.simple;

import engine.common.Material;
import engine.enums.EObjectType;
import engine.loaders.ImageLoader;
import engine.world.objects.DataObject;
import engine.world.objects.DynamicObject;
import org.newdawn.fizzy.Rectangle;
import org.newdawn.slick.SlickException;

public class WoodCrate extends DynamicObject {
    
    public static final int WOOD_CRATE_100 = 100;
    public static final int WOOD_CRATE_50 = 50;
    public static final int WOOD_CRATE_25 = 25;
    
    public WoodCrate(float x, float y, int type) throws SlickException {
        super(x, y, new Rectangle(type, type), Material.WOOD);
        body.setUserData(new DataObject(EObjectType.ITEM, ImageLoader.getImage("wood_crate_" + type)));
    }
}
