package aufgabe41.phong;

import aufgabe41.LightModel;
import aufgabe41.Options;
import aufgabe41.Vector3;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * Created by Julian on 10.06.2014.
 */
public class Window extends JPanel {

    public static final int WIDTH = 800;
    public static final int HEIGHT = 800;
    
    Scene s = new Scene(WIDTH, HEIGHT);
    
    protected LightModel lm;
    
    protected Options options;
    

    public void setOptions(Options o){
    	this.options = o;
    	addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent arg0) {
			}
			@Override
			public void mousePressed(MouseEvent arg0) {
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
			@Override
			public void mouseEntered(MouseEvent arg0) {
			}
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				options.loadFromModel();
				options.setVisible(true);
			}
		});
    	
    }

    public void paintComponent(Graphics g){
        
        s.render(g);

    }
    
    public void setLightModel(LightModel lm){
    	this.lm = lm;
    	lm.informOnUpdate(this);
    }
    
    public void updated(){
    	s = new Scene(WIDTH, HEIGHT);
    	s.lights = new DiffuseLight[lm.lights.size()];
    	
    	int index = 0;
    	for(DiffuseLight df : lm.lights){
    		s.lights[index] = df;
    		index++;
    	}
    	repaint();
    }


    public static void main(String[] args){




        JFrame frame = new JFrame("phong2");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(Window.WIDTH, Window.HEIGHT);
        Window panel = new Window();
        frame.getContentPane().add(panel);
        frame.setVisible(true);
        
        LightModel lm = new LightModel();
        panel.setLightModel(lm);
        Options options = new Options(lm, frame);
        panel.setOptions(options);
    }

}
