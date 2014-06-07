package aufgabe41;

/**
 * Created by Julian on 07.06.2014.
 */
public class FaceSphere {

    public final Face[] faces;

    public FaceSphere(Vector3 position, double radius){
        this.faces = new Face[20]; // Ikosaeder
        double phi = (1.0/radius) * (1 + Math.sqrt(5));
        double halfRadius = radius / 2;
        this.faces[0] = new Face(
                (new Vector3(0,1,phi)).add(position),
                (new Vector3(0,1,phi)).add(position),
                (new Vector3(0,1,phi)).add(position)
        );
    }

}
