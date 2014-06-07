package aufgabe41;

import java.util.LinkedList;

/**
 * Created by Julian on 07.06.2014.
 */
public class FaceSphere {

    public final LinkedList<Face> faces;

    public FaceSphere(Vector3 position, double radius){
        this.faces = new LinkedList<Face>(); // Ikosaeder
        //double phi = (1.0/radius) * (1 + Math.sqrt(5));
        double halfRadius = radius / 2;

    }

}
