package aufgabe41;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FieldSet extends JPanel{
	
	JLabel activatedLabel = new JLabel("aktiv");
	JCheckBox activatedCheck = new JCheckBox();
	
	JLabel redLabel = new JLabel("Rot");
	JTextField redField = new JTextField(8);
	
	JLabel greenLabel = new JLabel("Gr\u00fcn");
	JTextField greenField = new JTextField(8);
	
	JLabel blueLabel = new JLabel("Blau");
	JTextField blueField = new JTextField(8);
	
	JLabel xLabel = new JLabel("x");
	JTextField xField = new JTextField(8);
	
	JLabel yLabel = new JLabel("y");
	JTextField yField = new JTextField(8);
	
	JLabel zLabel = new JLabel("z");
	JTextField zField = new JTextField(8);
	
	public FieldSet(){
		super(new GridLayout(7, 2));
		
		activatedCheck.setSelected(true);
		activatedCheck.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				boolean enabled = activatedCheck.isSelected();
				enableAll(enabled);
			}
		});
		add(activatedLabel);
		add(activatedCheck);
		
		add(redLabel);
		add(redField);
		
		add(greenLabel);
		add(greenField);
		
		add(blueLabel);
		add(blueField);
		
		add(xLabel);
		add(xField);
		
		add(yLabel);
		add(yField);
		
		add(zLabel);
		add(zField);
		
	}
	
	public void enableAll(boolean b){
		redField.setEnabled(b);
		greenField.setEnabled(b);
		blueField.setEnabled(b);
		xField.setEnabled(b);
		yField.setEnabled(b);
		zField.setEnabled(b);
	}
	
	

}
