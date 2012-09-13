package engine.loaders;

import java.util.HashMap;
import org.newdawn.slick.Image;

public class ImageLoader {

    private static HashMap<String, Image> images = new HashMap<String, Image>();

    public static void load(String name, Image image) {
        images.put(name, image);
    }

    public static Image getImage(String name) {
        return images.get(name);
    }
}
