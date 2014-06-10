package aufgabe41.phong;

import aufgabe41.Ray;
import aufgabe41.Utils;
import aufgabe41.Vector3;

import static java.lang.Math.abs;

/**
 * Created by Julian on 10.06.2014.
 */
public class Sphere {

    /**
     * Position in World Coords
     */
    public final Vector3 position;
    public final double radius;

    public Sphere(Vector3 P, double r){
        this.radius = r;
        this.position = P;
    }

    public final Vector3 K = new Vector3(0.5,0.5,0.9);

    public Vector3[] normal(int x, int y){
        if (this.test(x,y)){
            double Z = this.position.z - Math.ceil(this.radius);
            Vector3 T = new Vector3(x,y,Z);
            double distance = T.distance(this.position);
            while (distance > this.radius && Z < this.position.z){
                Z = Z + 1;
                T = new Vector3(x,y,Z);
                distance = T.distance(this.position);
            }
            //System.out.println("::: ==> " + T + " || " + T.subtract(this.position).normalize());
            return new Vector3[] {T.subtract(this.position).normalize(), T};
        }
        return new Vector3[] {Vector3.Null(), Vector3.Null()};
    }

    public boolean test(int x, int y){
        Vector3 C = new Vector3(x,y,this.position.z);
        return C.distance(this.position) <= this.radius;
    }

    public Vector3 intersection(Ray ray){
        if(ray.source.distance(position) < radius){
            return null;
        }
        Vector3 posToSource = ray.source.subtract(position);
        double[] hits = Utils.pq(p(posToSource, ray), q(posToSource));
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

    public boolean cuts(Vector3 P, Vector3 Q){
        //return Vector3.isBetween(this.position,P,Q);
        Vector3 step = P.subtract(Q).normalize();
        // Q --> P
        Vector3 current = Q;
        double distanceP = Q.distance(P);
        double distanceS = Q.distance(this.position);
        while (distanceP >= this.radius){
            if (distanceS <= this.radius){
                return true;
            }
            current = current.add(step);
            distanceS = current.distance(this.position);
            distanceP = current.distance(P);
        }
        return false;
    }

    public boolean intersect(Ray r){
        Vector3 eye = r.source;
        Vector3 dst = new Vector3(this.position.x - eye.x, this.position.y - eye.y, this.position.z - eye.z);
        double t = dst.multiply(r.direction);
        if(t <= 0) return false;
        double d = t * t - dst.multiply(dst) + this.radius * radius;
        if (d <= 0) return false;
        return true;
    }

    private double p(Vector3 posToSource, Ray ray){
        return 2*(posToSource.x*ray.direction.x + posToSource.y*ray.direction.y + posToSource.z*ray.direction.z);
    }

    private double q(Vector3 posToSource){
        return posToSource.lengthSquared() - (radius*radius);
    }


}
