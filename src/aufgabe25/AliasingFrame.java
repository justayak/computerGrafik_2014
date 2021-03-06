package aufgabe25;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Julian on 05.05.2014.
 */
public class AliasingFrame extends JPanel implements MouseListener {

    private final int r_BASE = 10;
    private int r = r_BASE;

    public AliasingFrame(){
        this.addMouseListener(this);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);

        Dimension d=getSize();
        for(int x = 0;x < d.getWidth();x++){
            for(int y = 0; y < d.getHeight(); y++){
                int rgb = (x*x + y*y) % (r*r);
                ColorManager.drawPixel(g,x,y,rgb);
            }
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // Verändere den 'r'-Wert, abhängig von der Mausposition
        r = r_BASE *  (e.getXOnScreen() / 9) == 0 ? 1 : (e.getXOnScreen() / 3);
        repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
