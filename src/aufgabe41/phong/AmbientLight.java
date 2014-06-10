package aufgabe41.phong;


import aufgabe41.Vector3;

/**
 * Created by Julian on 10.06.2014.
 */
public class AmbientLight implements Light {

    private final Vector3 position;
    private final Vector3 color;

    public AmbientLight(Vector3 position, Vector3 color){
        this.position = position;
        this.color = color;
    }

    @Override
    public Vector3 color() {
        return this.color;
    }

    @Override
    public Vector3 position() {
        return this.position;
    }

    public Vector3 intensity(Vector3 K){
        return new Vector3(
                Math.min(1, this.color.x * K.x),
                Math.min(1, this.color.y * K.y),
                Math.min(1, this.color.z * K.z)
        );
    }

}
