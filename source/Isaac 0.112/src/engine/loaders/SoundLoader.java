package engine.loaders;

import java.util.HashMap;
import org.newdawn.slick.Sound;

public class SoundLoader {

    private static HashMap<String, Sound> sounds = new HashMap<String, Sound>();

    public static void load(String name, Sound sound) {
        sounds.put(name, sound);
    }

    public static Sound getSound(String name) {
        return sounds.get(name);
    }
}
