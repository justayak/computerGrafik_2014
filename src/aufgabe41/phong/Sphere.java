package aufgabe41.phong;

import aufgabe41.Vector3;

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

    public final Vector3 K = new Vector3(0.9,0.1,0.1);

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

}
