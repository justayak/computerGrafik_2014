package aufgabe48;

import java.awt.*;

/**
 * Created by Julian on 24.06.2014.
 */
public interface Texture {
    Color at(double u, double v); // u,v \in {0...1}
}
