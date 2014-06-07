package aufgabe41;

/**
 * Created by Julian on 07.06.2014.
 */
public class DiffuseLight implements Light {
    private static final double c0 = 0.1;
    private static final double c1 = 0.1;
    private static final double c2 = 0.1;

    public final Vector3 position;
    public final double LR;
    public final double LG;
    public final double LB;

    public DiffuseLight(Vector3 position, double LR, double LG, double LB){
        this.LR = LR;this.LG = LG; this.LB = LB;
        this.position = position;
    }

    @Override
    public double intensityR(Vector3 position, Vector3 normal, double K) {
        return this.intensity(this.LR, position, normal, K);
    }

    @Override
    public double intensityG(Vector3 position, Vector3 normal, double K) {
        return this.intensity(this.LG, position, normal, K);
    }

    @Override
    public double intensityB(Vector3 position, Vector3 normal, double K) {
        return this.intensity(this.LB, position, normal, K);
    }

    private double intensity(double L, Vector3 position, Vector3 normal, double K){
        final Vector3 lightToPosition = this.position.subtract(position);
        final double r = this.position.distance(position);
        System.out.println((1 / (c0+c1*r+c2*r*r)));
        return lightToPosition.cosTheta(normal) * (1 / r) * L * K;
    }
}
