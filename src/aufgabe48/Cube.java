package aufgabe48;

import aufgabe48.math.Mat4;
import aufgabe48.math.Vec4;

import javax.xml.soap.Text;
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

    private Texture texture = null;

    public void setTexture(Texture t){
        this.texture = t;
    }

    public void render(Graphics g, Camera c){
        Vec4 v1 = c.toNDC(this.worldAf());
        Vec4 v2 = c.toNDC(this.worldBf());
        Vec4 v3 = c.toNDC(this.worldCf());
        Vec4 v4 = c.toNDC(this.worldDf());
        Pixel p1 = c.getPixel(v1);
        Pixel p2 = c.getPixel(v2);
        Pixel p3 = c.getPixel(v3);
        Pixel p4 = c.getPixel(v4);

        Vec4 v5 = c.toNDC(this.worldAb());
        Vec4 v6 = c.toNDC(this.worldBb());
        Vec4 v7 = c.toNDC(this.worldCb());
        Vec4 v8 = c.toNDC(this.worldDb());
        Pixel p5 = c.getPixel(v5);
        Pixel p6 = c.getPixel(v6);
        Pixel p7 = c.getPixel(v7);
        Pixel p8 = c.getPixel(v8);

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

        g.setColor(Color.RED);
        g.fillRect(p1.x,p1.y, 7,7);
        g.fillRect(p4.x,p4.y, 7,7);
        g.fillRect(p8.x,p8.y, 7,7);
        g.setColor(Color.BLUE);
        g.fillRect(p5.x,p5.y, 7,7);

        g.setColor(Color.WHITE);

        if (this.texture != null) {

            // Faces:
            // #1 P1 - P4 - P8 - P5  (front Seite)
            System.out.println("p1" + p1 + " ,5" + p5);

            Vec4 topLeft = v5;
            Vec4 topRight = v8;
            Vec4 bottomLeft = v1;
            Vec4 bottomRight = v4;

            Mat4 reduce = Mat4.scale(0.01);
            Vec4 leftTopDown = reduce.multiply(bottomLeft.subtract(topLeft));
            Vec4 rightTopDown = reduce.multiply(bottomRight.subtract(topRight));
            Vec4 leftToRightTop = reduce.multiply(topRight.subtract(topLeft));
            Vec4 leftToRightBottom = reduce.multiply(bottomRight.subtract(bottomLeft));

            Vec4 leftVertical = topLeft;
            Vec4 rightVertical = topRight;
            Vec4 topHorizontal = topLeft;
            Vec4 bottomHorizontal = bottomLeft;
            double distanceHorizontal = leftVertical.distance(rightVertical);
            double distanceVertical = topHorizontal.distance(bottomHorizontal);
            double rightDistance = distanceHorizontal;



            // #2 P1 - P2 - P5 - P6  (rechte Seite)


        }



    }



}
