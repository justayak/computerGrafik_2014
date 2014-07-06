package aufgabe55;

import javax.media.opengl.GL2;

/**
 * Created by Julian on 06.07.2014.
 */
public class SimpleObject {

    float wcX,wcY,wcZ;
    float angle = 0;

    public SimpleObject(float x, float y, float z){
        this.wcX = x;
        this.wcY = y;
        this.wcZ = z;
    }

    public void draw(final GL2 gl){

        gl.glLoadIdentity();
        gl.glTranslatef(-1.5f, 0.0f, -6.0f);

        //angle += 0.7f;
        gl.glRotatef(angle, 0,0,0);

        gl.glBegin(GL2.GL_QUADS);                  // Start Drawing The Pyramid

        gl.glNormal3f( 0.0f, 1.0f, 0.0f);                  // Normal Pointing Up
        gl.glColor3f(0.0f,1.0f,0.0f);          // Set The Color To Green
        gl.glVertex3f( 1.0f, 1.0f,-1.0f);          // Top Right Of The Quad (Top)
        gl.glVertex3f(-1.0f, 1.0f,-1.0f);          // Top Left Of The Quad (Top)
        gl.glVertex3f(-1.0f, 1.0f, 1.0f);          // Bottom Left Of The Quad (Top)
        gl.glVertex3f( 1.0f, 1.0f, 1.0f);          // Bottom Right Of The Quad (Top)

        gl.glNormal3f( 0.0f,-1.0f, 0.0f);                  // Normal Pointing Down
        gl.glColor3f(1.0f,0.5f,0.0f);          // Set The Color To Orange
        gl.glVertex3f( 1.0f,-1.0f, 1.0f);          // Top Right Of The Quad (Bottom)
        gl.glVertex3f(-1.0f,-1.0f, 1.0f);          // Top Left Of The Quad (Bottom)
        gl.glVertex3f(-1.0f,-1.0f,-1.0f);          // Bottom Left Of The Quad (Bottom)
        gl.glVertex3f( 1.0f,-1.0f,-1.0f);          // Bottom Right Of The Quad (Bottom)

        gl.glNormal3f( 0.0f, 0.0f, 1.0f);                  // Normal Pointing Towards Viewer
        gl.glColor3f(1.0f,0.0f,0.0f);          // Set The Color To Red
        gl.glVertex3f( 1.0f, 1.0f, 1.0f);          // Top Right Of The Quad (Front)
        gl.glVertex3f(-1.0f, 1.0f, 1.0f);          // Top Left Of The Quad (Front)
        gl.glVertex3f(-1.0f,-1.0f, 1.0f);          // Bottom Left Of The Quad (Front)
        gl.glVertex3f( 1.0f,-1.0f, 1.0f);          // Bottom Right Of The Quad (Front)

        gl.glNormal3f( 0.0f, 0.0f,-1.0f);                  // Normal Pointing Away From Viewer
        gl.glColor3f(1.0f,1.0f,0.0f);          // Set The Color To Yellow
        gl.glVertex3f( 1.0f,-1.0f,-1.0f);          // Bottom Left Of The Quad (Back)
        gl.glVertex3f(-1.0f,-1.0f,-1.0f);          // Bottom Right Of The Quad (Back)
        gl.glVertex3f(-1.0f, 1.0f,-1.0f);          // Top Right Of The Quad (Back)
        gl.glVertex3f( 1.0f, 1.0f,-1.0f);          // Top Left Of The Quad (Back)

        gl.glNormal3f(-1.0f, 0.0f, 0.0f);                  // Normal Pointing Left
        gl.glColor3f(0.0f,0.0f,1.0f);          // Set The Color To Blue
        gl.glVertex3f(-1.0f, 1.0f, 1.0f);          // Top Right Of The Quad (Left)
        gl.glVertex3f(-1.0f, 1.0f,-1.0f);          // Top Left Of The Quad (Left)
        gl.glVertex3f(-1.0f,-1.0f,-1.0f);          // Bottom Left Of The Quad (Left)
        gl.glVertex3f(-1.0f,-1.0f, 1.0f);          // Bottom Right Of The Quad (Left)

        gl.glNormal3f( 1.0f, 0.0f, 0.0f);                  // Normal Pointing Right
        gl.glColor3f(1.0f,0.0f,1.0f);          // Set The Color To Violet
        gl.glVertex3f( 1.0f, 1.0f,-1.0f);          // Top Right Of The Quad (Right)
        gl.glVertex3f( 1.0f, 1.0f, 1.0f);          // Top Left Of The Quad (Right)
        gl.glVertex3f( 1.0f,-1.0f, 1.0f);          // Bottom Left Of The Quad (Right)
        gl.glVertex3f( 1.0f,-1.0f,-1.0f);          // Bottom Right Of The Quad (Right)

        gl.glEnd();                        // Done Drawing The Pyramid


        /*
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
        */
        gl.glFlush();


    }

}
