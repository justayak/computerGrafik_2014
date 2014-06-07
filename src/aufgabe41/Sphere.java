package aufgabe41;

import java.awt.*;
import java.util.Arrays;

import static java.lang.Math.abs;
import static java.lang.Math.min;


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
    	Vector3 posToSource = ray.source.subtract(position);
    	double[] hits = Utils.pq(p(posToSource, ray), q(posToSource));
    	System.out.println(Arrays.toString(hits));
    	if(hits.length == 0){
    		return null;
    	} else if(hits.length == 1){
    		return ray.pointAt(hits[0]);
    	} else {
    		if(abs(hits[0]) < abs(hits[1])){
    			return ray.pointAt(hits[0]);
    		} else {
    			return ray.pointAt(hits[1]);
    		}
    	}
    	
    }
    
    private double p(Vector3 posToSource, Ray ray){
    	return 2*(posToSource.x*ray.direction.x + posToSource.y*ray.direction.y + posToSource.z*ray.direction.z);
    }
    
    private double q(Vector3 posToSource){
    	return posToSource.lengthSquared() - (radius*radius); 
    }


    public boolean test(int x, int y){
        Vector3 testVector = new Vector3(x,y,this.position.z);
        return testVector.distance(this.position) < this.radius;
    }

    public double KR = 1;
    public double KG = 0.9;
    public double KB = 0.1;

    public void render(Graphics g, AmbientLight ambient, Light[] lights){






    }

}
