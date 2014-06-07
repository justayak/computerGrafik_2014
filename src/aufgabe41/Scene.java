package aufgabe41;

import java.awt.*;

/**
 * Created by Julian on 07.06.2014.
 */
public class Scene {

    private final Vector3 camera = Vector3.Null();

    private final Sphere[] elements = new Sphere[]{
        new Sphere(new Vector3(10.0, 20.0, 30.0), 20)
    };

    private final LightOld[] lights = new LightOld[]{

    };

    private final LightOld ambient = new LightOld(255,0,0);

    private final int height;
    private final int width;

    public Scene(int width, int height){
        this.height = height; this.width = width;
    }

    public void render(Graphics g){





    }


    private void draw(Graphics g, int x, int y, int R, int G, int B){
        g.setColor(new Color(R,G,B));
        g.drawRect(x,y,1,1);
    }



}
