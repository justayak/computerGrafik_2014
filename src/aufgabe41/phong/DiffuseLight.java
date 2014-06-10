package aufgabe41.phong;

import aufgabe41.Utils;
import aufgabe41.Vector3;

/**
 * Created by Julian on 10.06.2014.
 */
public class DiffuseLight implements Light {

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
        Vector3 L = this.p.subtract(P);
        N.normalize();
        V.normalize();
        Vector3 R = L.reflect(N);
        double diffuseLight = N.multiply(L);
        double specularLight = V.multiply(R);
        double cosTheta = N.cosTheta(L);
        double a = 0.001;
        double b = 0.00002;
        double c = 0.00004;
        double r = this.position().distance(P);
        double f = cosTheta * (1 / (a + b * r + c * r * r));
        double RED = Utils.clamp(f * this.color().x * K.x, 0, 1);
        double GREEN = Utils.clamp(f * this.color().y * K.y, 0, 1);
        double BLUE = Utils.clamp(f * this.color().z * K.z, 0, 1);
        return new Vector3(RED, GREEN, BLUE);
    }

    @Override
    public Vector3 position() {
        return this.p;
    }

}
