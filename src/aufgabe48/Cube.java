package aufgabe48;

import aufgabe48.math.Mat4;
import aufgabe48.math.Vec4;

import java.awt.*;

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

    public Vec4 A(){
        return new Vec4(8.927,6.273,5.2,1);
    }


    public void render(Graphics g, Camera c){
        Pixel p1 = c.getPixel(c.toNDC(this.worldAf()));
        Pixel p2 = c.getPixel(c.toNDC(this.worldBf()));
        Pixel p3 = c.getPixel(c.toNDC(this.worldCf()));
        Pixel p4 = c.getPixel(c.toNDC(this.worldDf()));

        Pixel p5 = c.getPixel(c.toNDC(this.worldAb()));
        Pixel p6 = c.getPixel(c.toNDC(this.worldBb()));
        Pixel p7 = c.getPixel(c.toNDC(this.worldCb()));
        Pixel p8 = c.getPixel(c.toNDC(this.worldDb()));

        //System.out.println("{" + p1 + "," + p2 + "," + p3 + "," + p4 + "}");

        g.fillRect(p1.x,p1.y,1,1);
        g.fillRect(p2.x,p2.y,1,1);
        g.fillRect(p3.x,p3.y,1,1);
        g.fillRect(p4.x,p4.y,1,1);

        g.fillRect(p5.x,p5.y,1,1);
        g.fillRect(p6.x,p6.y,1,1);
        g.fillRect(p7.x,p7.y,1,1);
        g.fillRect(p8.x,p8.y,1,1);

        g.drawLine(p1.x,p1.y,p2.x,p2.y);
        g.drawLine(p2.x,p2.y,p3.x,p3.y);
        g.drawLine(p3.x,p3.y,p4.x,p4.y);
        g.drawLine(p4.x,p4.y,p1.x,p1.y);

        g.drawLine(p1.x,p1.y,p5.x,p5.y);
        g.drawLine(p2.x,p2.y,p6.x,p6.y);
        g.drawLine(p3.x,p3.y,p7.x,p7.y);
        g.drawLine(p4.x,p4.y,p8.x,p8.y);

        g.drawLine(p8.x,p8.y,p5.x,p5.y);
        g.drawLine(p5.x,p5.y,p6.x,p6.y);
        g.drawLine(p6.x,p6.y,p7.x,p7.y);
        g.drawLine(p7.x,p7.y,p8.x,p8.y);

    }



}
