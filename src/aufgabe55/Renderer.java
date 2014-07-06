package aufgabe55;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLDrawableFactory;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.glu.GLU;
import javax.swing.*;

/**
 * Created by Julian on 06.07.2014.
 */
public class Renderer implements GLEventListener {

    private GLU glu = new GLU();
    private GLAutoDrawable glDrawable;
    private boolean done = false;

    @Override
    public void init(GLAutoDrawable gLDrawable) {
        System.out.println("init() called");
        //this.glDrawable = gLDrawable;
        GL2 gl = gLDrawable.getGL().getGL2();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL2.GL_FLAT);
    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {
        System.out.println("dispose() called");
    }

    private float a = -1.5f;
    private final long NANOS_PER_FRAME = 1000000000; // 1 Sekunde

    private void sleep(long nanos){
        try { Thread.sleep(nanos/1000000, (int) (nanos%1000000)); }
        catch (Exception e) {};
    }

    public void startUpdate(GLCanvas glcanvas){
        long delta=0;
        long time=System.nanoTime();
        while (!done ){
            time = System.nanoTime();

            if (this.glDrawable != null){
                a += 0.1f;
                System.out.println("change " + a);

                glcanvas.repaint();
                //this.display(this.glDrawable);
            }

            sleep(NANOS_PER_FRAME-delta);


        }

    }

    @Override
    public void display(GLAutoDrawable gLDrawable) {
        this.glDrawable = gLDrawable;
        final GL2 gl = gLDrawable.getGL().getGL2();
        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);
        gl.glLoadIdentity();
        System.out.println(a);
        gl.glTranslatef(a, 0.0f, -6.0f);
        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glVertex3f(0.0f, 1.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, 0.0f);
        gl.glEnd();
        gl.glTranslatef(3.0f, 0.0f, 0.0f);
        gl.glBegin(GL2.GL_QUADS);
        gl.glVertex3f(-1.0f, 1.0f, 0.0f);
        gl.glVertex3f(1.0f, 1.0f, 0.0f);
        gl.glVertex3f(1.0f, -1.0f, 0.0f);
        gl.glVertex3f(-1.0f, -1.0f, 0.0f);
        gl.glEnd();
        gl.glFlush();
    }

    @Override
    public void reshape(GLAutoDrawable gLDrawable, int x, int y, int width, int height) {
        System.out.println("reshape() called: x = "+x+", y = "+y+", width = "+width+", height = "+height);
        final GL2 gl = gLDrawable.getGL().getGL2();

        if (height <= 0) // avoid a divide by zero error!
        {
            height = 1;
        }

        final float h = (float) width / (float) height;

        gl.glViewport(0, 0, width, height);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();
    }
}
