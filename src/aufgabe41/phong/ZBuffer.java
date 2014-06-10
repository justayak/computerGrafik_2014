package aufgabe41.phong;

import aufgabe41.Vector3;

/**
 * Is eigentlich ein W-Buffer...
 * Created by Julian on 10.06.2014.
 */
public class ZBuffer {

    public final Vector3 P;
    private final Sphere[] ELEMENTS;

    public ZBuffer(Vector3 p, Sphere[] elements){
        this.P = p;this.ELEMENTS = elements;
    }

    public ZBuffer(Sphere[] elements){
        this.P = Vector3.Null();this.ELEMENTS = elements;
    }

    /**
     *
     * @param O [ORIGIN]
     * @return
     */
    public boolean touch(Vector3 O){

        Vector3 tr = this.P.subtract(O).normalize(); // Direction

        for(Sphere s : ELEMENTS){

        }



        return false;
    }


    public boolean isVisibleAt(int x, int y, Sphere s){
        return true;
    }




}
