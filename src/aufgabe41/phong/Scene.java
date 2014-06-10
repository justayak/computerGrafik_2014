package aufgabe41.phong;

import aufgabe41.*;

import java.awt.*;

/**
 * Created by Julian on 10.06.2014.
 */
public class Scene {

    private final Sphere[] ELEMENTS = new Sphere[]{
        new Sphere(new Vector3(105,155,10),40),
        new Sphere(new Vector3(205,155,10),40),
        new Sphere(new Vector3(305,155,10),40),
        new Sphere(new Vector3(405,155,10),40),
        new Sphere(new Vector3(505,155,10),40)
    };

    private final DiffuseLight[] lights = new DiffuseLight[]{
        new DiffuseLight(new Vector3(200,200,-100),new Vector3(0.8,0.8,.8))
    };

    private final AmbientLight ambient = new AmbientLight(new Vector3(0.2,0.2,0.2));

    private final int H,W;

    public Scene(int w, int h){
        this.H = h; this.W = w;
    }

    public void render(Graphics g){

        g.setColor(Color.BLACK);
        g.fillRect(0,0,this.W, this.H);

        Vector3 V = new Vector3(0,0,1);

        for(int x = 0; x < this.W; x++){
            for (int y = 0; y < this.H; y++){

                for(Sphere s : this.ELEMENTS){

                    if (s.test(x,y)){
                        Vector3[] NORMAL_POSITION = s.normal(x,y);
                        Vector3 N = NORMAL_POSITION[0];
                        Vector3 P = NORMAL_POSITION[1];
                        Vector3 I = Vector3.Null();
                        for (DiffuseLight d : this.lights){

                            I = I.add(d.intensity(P,N,V,s.K));



                        }

                        draw(g,x,y,I.x,I.y,I.z);

                    }

                }

            }
        }

    }

    public static void draw(Graphics g, int x, int y, double R, double G, double B){
        g.setColor(new Color((float)R,(float)G,(float)B));
        g.drawRect(x,y,1,1);
    }


}
