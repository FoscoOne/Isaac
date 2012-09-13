package engine.world.objects;

import engine.enums.EObjectType;
import engine.interfaces.IDataObject;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public class DataObject implements IDataObject {

    // Typ herniho objektu
    private final EObjectType type;
    // Animace objektu
    private Animation animation = null;;
    // Obrazek objektu
    private Image image = null;

    public DataObject(EObjectType type, Animation animation) {
        this.type = type;
        this.animation = animation;
    }

    public DataObject(EObjectType type, Image image) {
        this.type = type;
        this.image = image;
    }

    public DataObject(EObjectType type) {
        this.type = type;
    }

    @Override
    public EObjectType getType() {
        return type;
    }

    @Override
    public boolean isAnimated() {
        if (animation != null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void setAnimation(Animation animation) {
        this.animation = animation;
    }

    @Override
    public void setImage(Image image) {
        this.image = image;
    }

    @Override
    public Image getImage() {
        return image;
    }

    @Override
    public Animation getAnimation() {
        return animation;
    }
}
