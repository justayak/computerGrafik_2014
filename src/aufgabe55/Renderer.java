package aufgabe55;

import javax.media.opengl.GL2;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLDrawableFactory;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.awt.GLCanvas;
import javax.media.opengl.fixedfunc.GLLightingFunc;
import javax.media.opengl.glu.GLU;
import javax.swing.*;

/**
 * Created by Julian on 06.07.2014.
 */
public class Renderer implements GLEventListener {

    private GLU glu = new GLU();
    private boolean done = false;
    private SimpleObject simpleObject = new SimpleObject(1,1,-1);

    @Override
    public void init(GLAutoDrawable gLDrawable) {
        System.out.println("init() called");
        GL2 gl = gLDrawable.getGL().getGL2();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        gl.glShadeModel(GL2.GL_FLAT);

        gl.glPolygonMode(GL2.GL_FRONT_AND_BACK, GL2.GL_FILL);

        gl.glEnable(GL2.GL_DEPTH_TEST);


        float[] lightPos =  {50005,30000,50000,1};
        gl.glEnable(GLLightingFunc.GL_LIGHTING);
        gl.glEnable(GLLightingFunc.GL_LIGHT0);
        float[] noAmbient ={ 0.1f, 0.1f, 0.1f, 1f }; // low ambient light
        float[] spec =    { 1f, 0.6f, 0f, 1f }; // low ambient light
        float[] diffuse ={ 1f, 1f, 1f, 1f };
        // properties of the light
        gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_AMBIENT, noAmbient, 0);
        gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_SPECULAR, spec, 0);
        gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_DIFFUSE, diffuse, 0);
        gl.glLightfv(GLLightingFunc.GL_LIGHT0, GLLightingFunc.GL_POSITION, lightPos, 0);

        /*final float h = (float) 800 / (float) 600;
        gl.glViewport(0, 0, 800, 600);
        gl.glMatrixMode(GL2.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluPerspective(45.0f, h, 1.0, 20.0);
        gl.glMatrixMode(GL2.GL_MODELVIEW);
        gl.glLoadIdentity();*/

    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {
        System.out.println("dispose() called");
    }

    private final long NANOS_PER_FRAME = 16666666; // ~60fps

    private void sleep(long nanos) {
        try {
            Thread.sleep(nanos / 1000000, (int) (nanos % 1000000));
        } catch (Exception e) {
        }
        ;
    }

    public void startUpdate(GLCanvas glcanvas) {
        long delta = 0;
        long time;
        while (!done) {
            time = System.nanoTime();
            glcanvas.repaint();
            delta = System.nanoTime() - time;
            sleep(NANOS_PER_FRAME - delta);

        }

    }

    float angle = 0f;

    @Override
    public void display(GLAutoDrawable gLDrawable) {
        final GL2 gl = gLDrawable.getGL().getGL2();

        gl.glClear(GL2.GL_COLOR_BUFFER_BIT | GL2.GL_DEPTH_BUFFER_BIT);



        simpleObject.draw(gl);



        /*gl.glLoadIdentity();
        gl.glTranslatef(-1.5f, 0.0f, -6.0f);


        angle += 0.7f;
        gl.glRotatef(angle, 1,1.0f,0);

        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glColor3f(1.0f,0.0f,0.0f);
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
        */
    }

    @Override
    public void reshape(GLAutoDrawable gLDrawable, int x, int y, int width, int height) {
        System.out.println("reshape() called: x = " + x + ", y = " + y + ", width = " + width + ", height = " + height);
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
