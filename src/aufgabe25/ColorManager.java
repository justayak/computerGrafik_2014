package aufgabe25;

import java.awt.*;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Julian on 05.05.2014.
 */
public class ColorManager {

    private static Map<Integer,Color> colorLookup = new HashMap<Integer, Color>();

    public static void drawPixel(Graphics gr, int x, int y, int r, int g, int b){
        gr.setColor(getColorFromRGB(r,g,b));
        gr.fillRect(x,y,1,1);
    }

    public static void drawPixel(Graphics gr, int x, int y, int rgb){
        gr.setColor(getColorFromRGBValue(rgb));
        gr.fillRect(x,y,1,1);
    }

    public static Color getColorFromRGB(int r, int g, int b){
        int lookupKey = (r*65536)+(g*256)+b; // rot-bits::16-23 | grün-bits::8-15 || blau-bits::0-7
        return getColorFromRGBValue(lookupKey);
    }

    public static Color getColorFromRGBValue(int value){
        if (colorLookup.containsKey(value)){
            return colorLookup.get(value);
        }else{
            Color color = new Color(value);
            return color;
        }
    }

}
