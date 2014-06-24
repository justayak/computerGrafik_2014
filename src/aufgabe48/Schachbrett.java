package aufgabe48;

import java.awt.*;

/**
 * Created by Julian on 24.06.2014.
 */
public class Schachbrett implements Texture {
    @Override
    public Color at(double u, double v) {
        if(u>=0&&u<0.25 || u>=0.5&&u<0.75){
            if(v>=0&&v<0.25 || v>=0.5&&v<0.75){
                return Color.RED;
            }else{
                return Color.BLUE;
            }
        }else{
            if(v>=0&&v<0.25 || v>=0.5&&v<0.75){
                return Color.BLUE;
            }else{
                return Color.RED;
            }
        }


    }
}
