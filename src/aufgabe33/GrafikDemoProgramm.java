package aufgabe33;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class TestPanel extends JPanel implements MouseListener {
    int x = 10;
    int y = 10;

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.gray);
        Dimension d=getSize();  // loesche die Anzeige
        g.fillRect(0,0,d.width,d.height);
        g.setColor(Color.white);
        g.fillRect(x,y,4,4);
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

public class GrafikDemoProgramm {
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Grafik-Testprogramm");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600,400);
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