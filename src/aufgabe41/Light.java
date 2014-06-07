package aufgabe41;

/**
 * Created by Julian on 07.06.2014.
 */
public interface Light {

    double intensityR(Vector3 position, double K);
    double intensityG(Vector3 position, double K);
    double intensityB(Vector3 position, double K);

}
