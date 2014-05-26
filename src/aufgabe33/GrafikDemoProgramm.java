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

        this.plot(oneToBig(x1),oneToBig(y1),g);
        this.plot(oneToBig(x2),oneToBig(y2),g);

        if (this.isP2Set()){
            int xstart = oneToBig(this.x1);
            int ystart = oneToBig(this.y1);
            int xend = oneToBig(this.x2);
            int yend = oneToBig(this.y2);
            bresenham(xstart,ystart,xend,yend,g);
        }
    }

    void bresenham(int xStart,int yStart, int xEnd, int yEnd, Graphics g){
        int dx = Math.abs(xEnd - xStart);
        int sx = xStart<xEnd ? 1 : -1;
        int dy = Math.abs(yEnd - yStart);
        int sy = yStart<yEnd ? 1 : -1;
        int err = (dx>dy ? dx : -dy)/2;
        int e2;

        while(true){
            this.plot(xStart,yStart,g);
            if (xStart==xEnd && yStart==yEnd) break;
            e2 = err;
            if (e2 >-dx) {
                err -= dy;
                xStart += sx;
            }
            if (e2 < dy) {
                err += dx;
                yStart += sy;
            }
        }
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

    private boolean isP1Set(){ return x1 >= 0; }
    private boolean isP2Set(){ return x2 >= 0; }


    /**
     * Wandelt BIG-Pixel in echte Pixel um
     * @param n [Integer} Big-Pixel
     * @return {Integer} Pixel
     */
    public static int bigToOne(int n){
        return n*SIZE;
    }

    public static int oneToBig(int n){
        int r = n%SIZE;
        if (r == 0) return n/SIZE;
        if (r < SIZE/2) return n/SIZE + 1;
        else return n/SIZE;
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