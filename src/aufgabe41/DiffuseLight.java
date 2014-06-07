package aufgabe41;

/**
 * Created by Julian on 07.06.2014.
 */
public class DiffuseLight implements Light {
    private static final double c0 = 10;
    private static final double c1 = 15.1;
    private static final double c2 = 1.2;

    public final Vector3 position;
    public final double LR;
    public final double LG;
    public final double LB;

    public DiffuseLight(Vector3 position, double LR, double LG, double LB){
        this.LR = LR;this.LG = LG; this.LB = LB;
        this.position = position;
    }

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
