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

        g.setColor(Color.WHITE);

        if (this.texture != null) {

            // Faces:
            Face f1 = new Face(v1,v2,v4,v3);
            Face f2 = new Face(v6,v5,v7,v8);
            Face f3 = new Face(v2,v6,v3,v7);
            Face f4 = new Face(v5,v1,v8,v4);
            Face f5 = new Face(v5,v6,v1,v2);
            Face f6 = new Face(v7,v8,v3,v4);

            this.checkVisibility(f1,f2,f3,f4,f5,f6);

            if (f1.isVisible) this.render(f1,g,c);
            if (f2.isVisible) this.render(f2,g,c);
            if (f3.isVisible) this.render(f3,g,c);
            if (f4.isVisible) this.render(f4,g,c);
            if (f5.isVisible) this.render(f5,g,c);
            if (f6.isVisible) this.render(f6,g,c);
            //this.render(v6,v7,v5,v8,g,c);
            //this.render(v8,v7,v4,v3,g,c);


        }else{
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

    public void checkVisibility(Face f1, Face f2, Face f3, Face f4, Face f5, Face f6){
        checkPair(f1,f2);
        checkPair(f3,f4);
        checkPair(f5,f6);

    }

    private void checkPair(Face a, Face b){
        double diff = Math.abs(a.center.z-b.center.z);
        if (a.center.z != b.center.z && diff >0.03){ // Double-Genauigkeit...
            if(a.center.z < b.center.z) a.isVisible = true;
            else b.isVisible = true;
        }else {
            System.out.println("y " + (a.TL.x < a.TR.x) );
            if(a.TL.x > a.TR.x) a.isVisible = true;
            else b.isVisible = true;

        }
    }

    public void render(Face f, Graphics g, Camera c){
        Vec4 topLeft = f.TL,topRight=f.TR,bottomLeft = f.BL,bottomRight = f.BR;

        Mat4 reduce = Mat4.scale(1.0/texture.resolution());

        Vec4 leftTopDown = reduce.multiply(bottomLeft.subtract(topLeft));
        Vec4 rightTopDown = reduce.multiply(bottomRight.subtract(topRight));
        Vec4 leftToRightTop = reduce.multiply(topRight.subtract(topLeft));
        Vec4 leftToRightBottom = reduce.multiply(bottomRight.subtract(bottomLeft));

        Vec4 xt = topLeft;          //  xt -->xtR
        Vec4 xtR = topRight;        //  |      |
        Vec4 xb = bottomLeft;       //  |      |
        Vec4 xbR = bottomRight;     //  xb -->xbR

        Vec4 yl = topLeft;          //  yl -- yr
        Vec4 ybL = bottomLeft;      //  |      |
        Vec4 yr = topRight;         //  v      v
        Vec4 ybR = bottomRight;     //  yb -- xbR

        for(int y = 0; y < texture.resolution(); y++){
            for(int x = 0; x < texture.resolution(); x++){

                xt = topLeft.add3(leftToRightTop.multiply3(x));
                xb = bottomLeft.add3(leftToRightBottom.multiply3(x));
                yl = topLeft.add3(leftTopDown.multiply3(y));

                Vec4 topDown = reduce.multiply(xb.subtract(xt));

                g.setColor(texture.at(x,y));

                // draw it!
                Vec4 xtNext = topLeft.add3(leftToRightTop.multiply3(x+1));
                Vec4 xbNext = bottomLeft.add3(leftToRightBottom.multiply3(x+1));
                Vec4 topDownNext = reduce.multiply(xbNext.subtract(xtNext));

                Vec4 TL = xt.add3(topDown.multiply3(y));
                Vec4 BL = xt.add3(topDown.multiply3(y+1));
                Vec4 TR = xtNext.add3(topDownNext.multiply3(y));
                Vec4 BR = xtNext.add3(topDownNext.multiply3(y+1));

                c.drawRect(g,TL,TR,BL,BR);

            }
        }

        g.setColor(Color.WHITE);
    }


}
