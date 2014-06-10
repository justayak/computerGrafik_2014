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
    
    public Vector3 intersection(Ray ray, boolean acceptNegative){
    	if(ray.source.distance(position) < radius){
    		return null;
    	}
    	Vector3 posToSource = ray.source.subtract(position);
    	double[] hits = Utils.pq(p(posToSource, ray), q(posToSource));
    	if(!acceptNegative){
    		hits = filterNegative(hits);
    	}
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
    
    public Vector3 intersection(Ray ray){
    	return intersection(ray, false);
    }
    
    private double[] filterNegative(double[] array){
    	if(array.length == 0){
    		return array;
    	} else if(array.length == 1){
    		if(array[0] < 0){
    			return new double[0];
    		} else{
    			return array;
    		}
    	} else {
    		if(array[0] < 0 && array[1] < 0){
    			return new double[0];
    		} else if (array[0] < 0){
    			return new double[]{array[1]};
    		} else if (array[1] < 0){
    			return new double[]{array[0]};
    		} else {
    			return array;
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
    public double KG = 0.1;
    public double KB = 0.1;

    public void render(Graphics g, AmbientLight ambient, Light[] lights){






    }

}
