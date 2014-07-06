package aufgabe55;

//depends on jogl.jar and gluegen-rt.jar
import java.awt.*;
import java.awt.event.*;
import javax.media.opengl.*;
import javax.media.opengl.glu.GLU;

/**
 * Created by Julian on 06.07.2014.
 * Renderer aus der Vorlesung..
 */
public class VLRenderer implements GLEventListener {

    static GLU glu = new GLU();
    static javax.media.opengl.awt.GLCanvas canvas = new javax.media.opengl.awt.GLCanvas();

    @Override
    public void init(GLAutoDrawable glAutoDrawable) {
        final GL2 gl = glAutoDrawable.getGL().getGL2();
        gl.glClearColor(0.0f, 0.0f, 0.0f, 0.5f); //clear the background with black

        //shading
        gl.glShadeModel(GL2.GL_FLAT);
        //FLAT = 1 color per face, SMOOTH = one color per pixel (smooth shading)
        //depth buffer
        gl.glClearDepth(1.0f);
        gl.glEnable(GL.GL_DEPTH_TEST);
        gl.glDepthFunc(GL.GL_LEQUAL);

        //TODO: place additional initializations here...
    }

    @Override
    public void dispose(GLAutoDrawable glAutoDrawable) {

    }

    @Override
    public void display(GLAutoDrawable gLDrawable) {
        final GL2 gl = gLDrawable.getGL().getGL2();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT | GL.GL_DEPTH_BUFFER_BIT);
        //clear the screen (and depth buffer)
        gl.glLoadIdentity();	//reset the view

        //TODO: replace to following dummy lines
        // and place your drawing code here
        // ... transformations, objects, ...
        // only things with negative z coordinate are visible
        // with the provided viewpoint settings

        float x = 100, y = 5, z = -1;
        float angle = 1.2f, axis_x = 1, axis_y = 0, axis_z = 0;
        float r = 255,g=0,b=0;

        gl.glTranslatef( x, y, z);
        gl.glRotatef(angle, axis_x,axis_y,axis_z);

        gl.glBegin(GL2.GL_TRIANGLES);
        gl.glColor3f( r,g,b );
        gl.glVertex3f( x,y,z );
        //TODO...
        gl.glEnd();
    }

    @Override
    public void reshape(GLAutoDrawable gLDrawable, int x, int y, int width, int height) {
        final GL2 gl = gLDrawable.getGL().getGL2();
        //perspective
        if (height > 0) {
            final float h = (float)width / (float)height;
            gl.glMatrixMode(GL2.GL_PROJECTION);
            gl.glLoadIdentity();
            glu.gluPerspective(45.0f, h, 1.0, 20.0);
            //field of vision is 45 degrees, depth clipping between 1 and 20
            gl.glMatrixMode(GL2.GL_MODELVIEW);
            gl.glLoadIdentity();
        }
    }
}
