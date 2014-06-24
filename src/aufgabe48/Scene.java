package aufgabe48;

import aufgabe48.math.Vec4;

import java.awt.*;

/**
 * Created by Julian on 24.06.2014.
 */
public class Scene {

    public final int width;
    public final int height;
    public final Camera camera;

    public Scene(int w, int h){
        this.width = w; this.height=h;

        // --- Camera festlegen
        double aperture = 30;
        Vec4 cameraPosition = new Vec4(4,5,3,1);
        Vec4 looksAt = new Vec4(7,5,4,1);
        this.camera = new Camera(cameraPosition,aperture, looksAt,3,20);
        // --- Camera festlegen ende

        Cube c = new Cube(1,1,1,10);

    }


    public void render(Graphics g){

    }

}
