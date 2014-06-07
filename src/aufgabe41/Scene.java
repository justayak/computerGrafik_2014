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

    private final DiffuseLight[] lights = new DiffuseLight[]{
        new DiffuseLight(new Vector3(200,800,400), 0.8, 0.8,0.7)
    };

    private final AmbientLight ambient = new AmbientLight(0.3,0.3,0.3);

    private final int height;
    private final int width;

    public Scene(int width, int height){
        this.height = height; this.width = width;
    }

    public void render(Graphics g){
        g.setColor(Color.BLACK);
        g.drawRect(0,0,this.width,this.height);

        for (int x = 0; x < this.width; x++){
            for (int y = 0; y < this.height; y++){



            }
        }


    }


    public static void draw(Graphics g, int x, int y, int R, int G, int B){
        g.setColor(new Color(R,G,B));
        g.drawRect(x,y,2,2);
    }



}
