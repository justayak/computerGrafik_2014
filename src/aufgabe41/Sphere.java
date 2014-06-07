package aufgabe41;


/**
 * Created by Julian on 07.06.2014.
 */
public class Sphere {

    public final Vector3 position;
    public final int radius;

    public Sphere(Vector3 position, int radius){
        this.position = position;this.radius = radius;
    }
    
    public Vector3 intersection(Ray ray){
    	if(ray.source.distance(position) < radius){
    		return null;
    	}
    	return null;
    }


}
