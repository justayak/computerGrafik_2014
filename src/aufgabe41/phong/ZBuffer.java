package aufgabe41.phong;

import aufgabe41.Ray;
import aufgabe41.Vector3;

/**
 * Is eigentlich ein W-Buffer...
 * Created by Julian on 10.06.2014.
 */
public class ZBuffer {

    public final Vector3 P;
    private final Sphere[][] buffer;

    public ZBuffer(Vector3 p, Sphere[] elements, int width, int height) {
        this.P = p;
        this.buffer = new Sphere[width][height];
        this.init(elements,width,height);
    }

    public ZBuffer(Sphere[] elements, int width, int height) {
        this.P = Vector3.Null();
        this.buffer = new Sphere[width][height];
        this.init(elements,width,height);
    }

    private void init(Sphere[] elements, int width, int height) {
        double[][] depth = new double[width][height];
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                depth[x][y] = Double.MAX_VALUE;
            }
        }
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                for (Sphere s : elements) {
                    if (s.test(x, y)) {
                        if(s.position.z < depth[x][y]){
                            depth[x][y] = s.position.z;
                            this.buffer[x][y] = s;
                        }
                    }
                }
            }
        }
    }

    public boolean isVisibleAt(int x, int y, Sphere s) {
        return this.buffer[x][y] == (s);
    }


}
