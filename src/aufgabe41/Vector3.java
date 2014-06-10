package aufgabe41;

/**
 * Created by Julian on 07.06.2014.
 */
public class Vector3 {
    public final double x;
    public final double y;
    public final double z;
    public final double weight;

    public Vector3(double x, double y, double z){
        this.x = x;this.y = y;this.z = z;
        this.weight = Math.sqrt((this.x * this.x) + (this.y*this.y) + (this.z*this.z));
    }

    public Vector3 add(Vector3 v){
        return new Vector3(this.x + v.x, this.y + v.y, this.z + v.z);
    }

    public Vector3 subtract(Vector3 v){
        return new Vector3(this.x - v.x, this.y - v.y, this.z - v.z);
    }

    public double multiply(Vector3 v){
        return (this.x * v.x) + (this.y + v.y) + (this.z * v.z);
    }

    public Vector3 cross(Vector3 v){
        final double x = (this.y*v.z) - (this.z*v.y);
        final double y = (this.z*v.x) - (this.x*v.z);
        final double z = (this.x-v.y) - (this.y*v.x);
        return new Vector3(x,y,z);
    }

    public boolean equals(Vector3 v){
        return (this.x == v.x && this.y == v.y && this.z == v.z);
    }

    public Vector3 normalize(){
        return new Vector3(this.x/this.weight, this.y/this.weight, this.z/this.weight);
    }

    public static Vector3 Null(){
        return new Vector3(0,0,0);
    }

    public static Vector3 X(){
        return new Vector3(1,0,0);
    }

    public static Vector3 Y(){
        return new Vector3(0,1,0);
    }

    public static Vector3 Z(){
        return new Vector3(0,0,1);
    }
    
    public double distance(Vector3 v){
        final double xSquare = (v.x - x) * (v.x - x);
        final double ySquare = (v.y - y) * (v.y - y);
    	final double zSquare = (v.z - z) * (v.z - z);
    	return Math.sqrt(xSquare + ySquare + zSquare); 
    }

    public Vector3 scaleAdd(final Vector3 V, final double scale){
        return new Vector3(
            scale * V.x,
            scale * V.y,
            scale * V.z
        );
    }

    public Vector3 reflect(Vector3 N){
        N = N.normalize();
        return this.scaleAdd(N,-2 * (this.multiply(N))).normalize();


    }

    public double cosTheta(Vector3 v){
        return (this.multiply(v) / (this.weight * v.weight));
    }
    
    public double lengthSquared(){
    	return (this.x * this.x) + (this.y * this.y) + (this.z * this.z);
    }
    
    public double length(){
    	return Math.sqrt(this.lengthSquared());
    }
    
    public Vector3 multiply(double scalar){
    	return new Vector3(this.x * scalar, this.y * scalar, this.z * scalar);
    }

    @Override
    public String toString(){
        return "{" + this.x + "|" + this.y + "|" + this.z + "}";
    }

}
