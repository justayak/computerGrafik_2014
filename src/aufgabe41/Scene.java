package aufgabe41;

import java.awt.*;

/**
 * Created by Julian on 07.06.2014.
 */
public class Scene {

    private final Vector3 camera = Vector3.Null();

    private final Sphere[] elements = new Sphere[]{
        new Sphere(new Vector3(86.0, 60.0, 30.0), 20)
    };

    private final DiffuseLight[] lights = new DiffuseLight[]{
        new DiffuseLight(new Vector3(200,800,400), 0.8, 0.8,0.7)
    };

    private final AmbientLight ambient = new AmbientLight(0.2,0.2,0.2);

    private final int height;
    private final int width;

    public Scene(int width, int height){
        this.height = height; this.width = width;
    }

    public void render(Graphics g){
        g.setColor(Color.BLACK);
        g.fillRect(0,0,this.width,this.height);


        for(int x = 0; x < this.width; x++){
            for (int y = 0; y < this.height; y++){

                for(Sphere s : this.elements){
                    if (s.test(x,y)){
                        double R = ambient.intensityR(Vector3.Null(),Vector3.Null(),s.KR);
                        double G = ambient.intensityR(Vector3.Null(),Vector3.Null(),s.KG);
                        double B = ambient.intensityR(Vector3.Null(),Vector3.Null(),s.KB);

                        for (Light light : this.lights){

                            Ray r = new Ray(x,y);
                            Vector3 pos = s.intersection(r);
                            Vector3 n = s.position.subtract(pos).normalize();

                            R = R + light.intensityB(pos,n,s.KR);
                            G = G + light.intensityG(pos,n,s.KG);
                            B = B + light.intensityB(pos,n,s.KB);


                        }

                        draw(g,x,y,Math.min(R,1),Math.min(G,1),Math.min(B,1));

                    }
                }

            }
        }




    }


    public static void draw(Graphics g, int x, int y, int R, int G, int B){
        g.setColor(new Color(R,G,B));
        g.drawRect(x,y,1,1);
    }

    public static void draw(Graphics g, int x, int y, double R, double G, double B){
        g.setColor(new Color((float)R,(float)G,(float)B));
        g.drawRect(x,y,1,1);
    }



}
