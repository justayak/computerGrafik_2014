package aufgabe25;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * // Source: http://www.inf.fu-berlin.de/lehre/SS14/Computergrafik/GrafikDemoProgramm.java
 * Created by Julian on 01.05.2014.
 */
class TestPanel extends JPanel implements MouseListener {
    int x = 10;
    int y = 10;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.gray);
        Dimension d=getSize();  // loesche die Anzeige
        g.fillRect(0,0,d.width,d.height);
        g.setColor(Color.white);
        g.fillRect(x,y,14,4);
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
        x = e.getX();
        y = e.getY();
        repaint();
    }

}
