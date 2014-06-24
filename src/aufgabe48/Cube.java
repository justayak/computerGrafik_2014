package aufgabe48;

import aufgabe48.math.Mat4;
import aufgabe48.math.Vec4;

/**
 * Created by Julian on 24.06.2014.
 */
public class Cube {

    public final Mat4 toWorld;
    private Vec4 Af;     //  A--B
    private Vec4 Bf;     //  |  |
    private Vec4 Cf;     //  D--C
    private Vec4 Df;     //
    private Vec4 Ab;
    private Vec4 Bb;
    private Vec4 Cb;
    private Vec4 Db;

    public Cube(double x, double y, double z, double scale){
        Mat4 translate = Mat4.translation(x,y,z);
        Mat4 sc = Mat4.scale(scale);
        this.toWorld = sc.multiply(translate);
        Af = new Vec4(-1,1,1,1);
        Bf = new Vec4(1,1,1,1);
        Cf = new Vec4(1,-1,1,1);
        Df = new Vec4(-1,-1,1,1);
        Ab = new Vec4(-1,1,-1,1);
        Bb = new Vec4(1,1,-1,1);
        Cb = new Vec4(1,-1,-1,1);
        Db = new Vec4(-1,-1,-1,1);
    }

    public Vec4 worldAf(){
        return this.toWorld.multiply(this.Af);
    }
    public Vec4 worldBf(){
        return this.toWorld.multiply(this.Bf);
    }
    public Vec4 worldCf(){
        return this.toWorld.multiply(this.Cf);
    }
    public Vec4 worldDf(){
        return this.toWorld.multiply(this.Df);
    }
    public Vec4 worldAb(){
        return this.toWorld.multiply(this.Ab);
    }
    public Vec4 worldBb(){
        return this.toWorld.multiply(this.Bb);
    }
    public Vec4 worldCb(){
        return this.toWorld.multiply(this.Cb);
    }
    public Vec4 worldDb(){
        return this.toWorld.multiply(this.Db);
    }

}
