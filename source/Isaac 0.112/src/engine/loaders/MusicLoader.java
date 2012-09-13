package engine.loaders;

import java.util.HashMap;
import org.newdawn.slick.Music;

public class MusicLoader {

    private static HashMap<String, Music> musics = new HashMap<String, Music>();

    public static void load(String name, Music music) {
        musics.put(name, music);
    }

    public static Music getMusic(String name) {
        return musics.get(name);
    }
}
