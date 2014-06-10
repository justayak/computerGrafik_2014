package aufgabe41.phong;

import aufgabe41.Utils;
import aufgabe41.Vector3;

/**
 * Created by Julian on 10.06.2014.
 */
public class DiffuseLight implements Light {
	
	double C_0 = 0.001;
	double C_1 = 0.00002;
	double C_2 = 0.00004;

    private final Vector3 p, c;

    public ZBuffer ZBuffer;

    public DiffuseLight(Vector3 pos, Vector3 c) {
        this.p = pos;
        this.c = c;
    }

    @Override
    public Vector3 color() {
        return this.c;
    }

    /**
     * @param P position of the Element
     * @param N Normal of the Element
     * @param V Direction of the Viewer
     * @param K Material coefficient
     * @return Intensity (RGB)
     */
    public Vector3 intensity(Vector3 P, Vector3 N, Vector3 V, Vector3 K) {
    	N = N.normalize();
    	V = V.normalize();
        Vector3 L = this.p.subtract(P);
        double f = f(this.position().distance(P));
        Vector3 diff = diffuse(f, L, N, K);
        Vector3 spec = specular();
        double RED = Utils.clamp(diff.x + spec.x);
        double GREEN = Utils.clamp(diff.y + spec.y);
        double BLUE = Utils.clamp(diff.z + spec.z);
        return new Vector3(RED, GREEN, BLUE);
    }
    
    private Vector3 diffuse(double f, Vector3 L, Vector3 N, Vector3 K){
    	double cosTheta = L.cosTheta(N);
    	f = f * cosTheta;
    	return new Vector3(f * this.color().x * K.x, f * this.color().y * K.y, f * this.color().z * K.z);
    }
    
    private Vector3 specular(){
    	return Vector3.Null();
    }
    
    private double f(double r){
    	return 1/(C_0 + C_1 * r + C_2 * r * r);
    }

    @Override
    public Vector3 position() {
        return this.p;
    }

}
