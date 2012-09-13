package moduls;

import java.awt.image.BufferedImage;
import java.util.HashMap;

public class ImageLoader {

    private static HashMap<String, BufferedImage> images = new HashMap<String, BufferedImage>();

    public static void load(String name, BufferedImage image) {
        images.put(name, image);
    }

    public static BufferedImage getImage(String name) {
        return images.get(name);
    }
    
    public static void clear() {
        images.clear();
    }
}
