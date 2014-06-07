package aufgabe41;

/**
 * Created by Julian on 07.06.2014.
 */
public class AmbientLight implements Light {
    @Override
    public double intensityR(Vector3 position, double K) {
        return 0;
    }

    @Override
    public double intensityG(Vector3 position, double K) {
        return 0;
    }

    @Override
    public double intensityB(Vector3 position, double K) {
        return 0;
    }
}
