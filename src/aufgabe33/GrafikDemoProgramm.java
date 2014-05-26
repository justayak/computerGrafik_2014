package aufgabe33;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TestPanel extends JPanel implements MouseListener {

    static final int SIZE = 16;

    int x1 = -100;
    int y1 = -100;

    int x2 = -100;
    int y2 = -100;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.GRAY);
        Dimension d=getSize();  // loesche die Anzeige

        g.fillRect(0,0,d.width,d.height);

        g.setColor(Color.DARK_GRAY);
        drawGrid(g,d);

        g.setColor(Color.white);

        /*
        g.fillRect(x1,y1,SIZE,SIZE);
        g.fillRect(x2,y2,SIZE,SIZE);
        */

        this.plot(x1,y1,g);
        this.plot(x2,y2,g);

        if (this.isP2Set()){
            int xstart = oneToBig(this.x1);
            int ystart = oneToBig(this.y1);
            int xend = oneToBig(this.x2);
            int yend = oneToBig(this.y2);
            int x, y, t, dx, dy, incx, incy, pdx, pdy, ddx, ddy, es, el, err;

            System.out.println(xstart + " |t " + ystart + " j " + this.x1);

            dx = xend - xstart;
            dy = yend - ystart;

            incx = sgn(dx);
            incy = sgn(dy);

            if (dx<0) dx = -dx;
            if (dy<0) dy = -dy;

            if(dx>dy){
                pdx = incx;
                pdy = 0;
                ddx = incx;
                ddy = incy;
                es = dx;
                el = dy;
            }else{
                pdx = 0;
                pdy = incy;
                ddx = incx;
                ddy = incy;
                es = dx;
                el = dy;
            }

            x = xstart;
            y = ystart;

            err = el/2;
            this.plot(x,y,g);

            for (t=0;t<el;++t){
                err -= es;
                if(err<0){
                    err += el;
                    x += ddx;
                    y += ddy;
                }else{
                    x += pdx;
                    y += pdy;
                }
                this.plot(x,y,g);
                System.out.println(x + " | " + y);
            }
        }
    }

    private int sgn(int x){
        return (x>0) ? 1 : (x<0) ? -1 : 0;
    }

    private void plot(int bigX, int bigY, Graphics g){
        g.fillRect(bigToOne(bigX),bigToOne(bigY),SIZE, SIZE);
    }

    private void drawGrid(Graphics g, Dimension d){
        for(int x = 0; x < d.getWidth(); x+=SIZE)g.fillRect(x,0,1,d.height);
        for(int y = 0; y < d.getHeight(); y+=SIZE)g.fillRect(0,y,d.width,1);
    }

    public TestPanel() {
        addMouseListener(this);
    }

//////////////////////
//  Eingabe (Maus)  //
//////////////////////


    public void mouseReleased(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    public void mouseClicked(MouseEvent e) {}
    public void mouseMoved(MouseEvent e) {}
    public void mouseDragged(MouseEvent e) {}
    // mousePressed(): Mausknopf wurde betaetigt
    // Hier: neue Punktkoordinaten aufnehmen
    public void mousePressed(MouseEvent e) {
        if (!this.isP1Set()){
            x1 = clamp(e.getX());
            y1 = clamp(e.getY());
        }else{
            x2 = clamp(e.getX());
            y2 = clamp(e.getY());
        }
        repaint();
    }

    private boolean isP1Set(){ return x1 > 0; }
    private boolean isP2Set(){ return x2 > 0; }


    /**
     * Wandelt BIG-Pixel in echte Pixel um
     * @param n [Integer} Big-Pixel
     * @return {Integer} Pixel
     */
    public static int bigToOne(int n){
        return n*SIZE;
    }

    public static int oneToBig(int n){
        return clamp(n);
    }

    public static int clamp(int n){
        int r = n%SIZE;
        if (r == 0)return n;
        if (r < SIZE/2) return n-r;
        return n+(SIZE-r);
    }

}

public class GrafikDemoProgramm {
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Grafik-Testprogramm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,600);
        JPanel panel = new TestPanel();

        frame.getContentPane().add(panel);
        //Display the window.
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                createAndShowGUI();
            }
        });
    }
}