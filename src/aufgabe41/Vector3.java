package aufgabe41;

/**
 * Created by Julian on 07.06.2014.
 */
public class Vector3 {
    public double x;
    public double y;
    public double z;

    public Vector3(double x, double y, double z){
        this.x = x;this.y = y;this.z = z;
    }

    public Vector3(double x, double y, double z, double w){
        this.x = x;this.y = y;this.z = z;
    }

    public Vector3 add(Vector3 v){
        return new Vector3(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    public Vector3 subtract(Vector3 v){
        return new Vector3(this.x - v.x, this.y - v.y, this.z - v.z);
    }

    public Vector3 cross(Vector3 v){
        return null;
    }

}
