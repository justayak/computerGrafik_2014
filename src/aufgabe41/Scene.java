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


        FaceSphere f = new FaceSphere(new Vector3(100,100,100), 101);

        for(Face face : f.faces){
            draw(g,(int)face.A.x, (int)face.A.y,255,0,0);
            draw(g,(int)face.B.x, (int)face.B.y,255,0,0);
            draw(g,(int)face.C.x, (int)face.C.y,255,0,0);
            System.out.println(face.A + " _ " + face.B + " _ " + face.C);
        }



    }


    private void draw(Graphics g, int x, int y, int R, int G, int B){
        g.setColor(new Color(R,G,B));
        g.drawRect(x,y,10,10);
    }



}
