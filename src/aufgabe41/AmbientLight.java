package aufgabe41;


/**
 * Created by Julian on 07.06.2014.
 */
public class AmbientLight implements Light {

    public final double IR;
    public final double IG;
    public final double IB;

    public AmbientLight(double IR, double IG, double IB){
        this.IR = IR;this.IG = IG; this.IB = IB;
    }

    @Override
    public double intensityR(Vector3 position, Vector3 normal, double K) {
        return IR * K;
    }

    @Override
    public double intensityG(Vector3 position, Vector3 normal, double K) {
        return IG * K;
    }

    @Override
    public double intensityB(Vector3 position, Vector3 normal, double K) {
        return IB * K;
    }
}
