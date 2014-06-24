package aufgabe48;

import aufgabe48.math.Mat4;
import aufgabe48.math.Vec4;

/**
 * Created by Julian on 24.06.2014.
 */
public class Camera {

    public final Vec4 position;
    public final double apertureInDegree;
    public final double zNear, zFar;
    public final Vec4 u;
    public final Vec4 n;
    public final Vec4 v;
    public final Mat4 weltZuAuge;

    public Camera(Vec4 pos, double apertureInDegree, Vec4 lookat, double zNear, double zFar) {
        this.position = pos;
        this.zNear = zNear;
        this.zFar = zFar;
        this.apertureInDegree = apertureInDegree;
        this.n = (pos.subtract(lookat)).normalize();
        this.u = n.negate().cross(new Vec4(0, 0, 1, 1)).normalize();
        this.v = this.u.cross(n.negate()).normalize();

        System.out.println("u + " + this.u);
        System.out.println("v + " + this.v);
        System.out.println("n + " + this.n);


        Mat4 basisWechsel = new Mat4(
                this.u.x, this.u.y, this.u.z, 0,
                this.v.x, this.v.y, this.v.z, 0,
                this.n.x, this.n.y, this.n.z, 0,
                0, 0, 0, 1
        );

        System.out.println("p: " + pos);
        Mat4 translate = Mat4.translation(-pos.x, -pos.y, -pos.z);
        weltZuAuge = basisWechsel.multiply(translate);

        System.out.println("---");
        System.out.println(weltZuAuge);
        //this.weltZuAuge =
    }


}
