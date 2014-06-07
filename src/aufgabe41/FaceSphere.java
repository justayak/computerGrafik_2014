package aufgabe41;

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
                new Vector3(position.x, position.y + halfRadius, position.z),
                new Vector3(position.x + halfRadius, position.y, position.z - halfRadius),
                new Vector3(position.x - halfRadius, position.y, position.z - halfRadius)
        ));


    }

}
