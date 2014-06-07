package aufgabe41;

/**
 * Created by Julian on 07.06.2014.
 */
public class Light {

    public final int R;
    public final int G;
    public final int B;

    public final Vector3 position;

    public final boolean isAmbient;

    public Light(int R,int G,int B){
        this.R = R;this.G = G;this.B = B;
        this.position = Vector3.Null();
        this.isAmbient = true;
    }

    public Light(int R,int G,int B, Vector3 position){
        this.R = R;this.G = G;this.B = B;
        this.position = position;
        this.isAmbient = false;
    }

}
