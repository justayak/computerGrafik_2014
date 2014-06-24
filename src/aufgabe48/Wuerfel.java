package aufgabe48;

import java.awt.*;

/**
 * Created by Julian on 25.06.2014.
 */
public class Wuerfel implements Texture {
    @Override
    public Color at(int u, int v) {
        if (u == 1 || u == 3 || u == 5){
            if(v ==2 || v == 4){
                return Color.DARK_GRAY;
            }
        }
        return Color.LIGHT_GRAY;

    }

    @Override
    public int resolution() {
        return 7;
    }
}
