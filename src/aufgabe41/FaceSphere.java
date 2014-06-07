package aufgabe41;

import java.awt.*;
import java.util.LinkedList;

/**
 * Created by Julian on 07.06.2014.
 */
public class FaceSphere {

    public final LinkedList<Face> faces;

    public FaceSphere(Vector3 position, double radius){
        this.faces = new LinkedList<Face>(); // Ikosaeder
        double halfRadius = radius / 2;

        this.faces.add(new Face(
                new Vector3(position.x, position.y - halfRadius, position.z),
                new Vector3(position.x + halfRadius, position.y, position.z - halfRadius),
                new Vector3(position.x - halfRadius, position.y, position.z - halfRadius)
        ));



    }


    public void render(Graphics g){
        for(Face face : this.faces){
            Scene.draw(g,(int)face.A.x, (int)face.A.y, 255,0,0);
            Scene.draw(g,(int)face.B.x, (int)face.B.y, 0,255,0);
            Scene.draw(g,(int)face.C.x, (int)face.C.y, 0,0,255);
        }
    }

}
