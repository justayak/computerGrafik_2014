package aufgabe48;

import java.awt.*;

/**
 * Created by Julian on 24.06.2014.
 */
public class Schachbrett implements Texture {
    @Override
    public Color at(int u, int v) {
        if (u%2 == v%2) return Color.DARK_GRAY;
        return Color.MAGENTA;
    }

    @Override
    public int resolution() {
        return 4;
    }
}
