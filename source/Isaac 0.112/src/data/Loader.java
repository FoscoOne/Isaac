package data;

import java.io.File;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Loader {

    public static URL getURL(String ref) {
        return ClassLoader.getSystemResource(ref);
    }

    public static InputStream getInputStream(String ref) {
        return ClassLoader.getSystemResourceAsStream(ref);
    }

    public static URI getURI(String ref) {
        try {
            return ClassLoader.getSystemResource(ref).toURI();
        } catch (URISyntaxException ex) {
            return null;
        }
    }

    public static File getFile(String ref) {
        try {
            return new File(ClassLoader.getSystemResource(ref).toURI().getPath());
        } catch (URISyntaxException ex) {
            return null;
        }
    }
}
