package engine.interfaces;

import engine.enums.EObjectType;
import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;

public interface IDataObject {

    EObjectType getType();

    boolean isAnimated();

    void setAnimation(Animation animation);

    void setImage(Image image);

    Image getImage();

    Animation getAnimation();
}
