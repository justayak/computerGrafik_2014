package aufgabe41;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

public class Options extends JDialog{
	
	LightModel model;
	
	JButton closeButton = new JButton("close");
	JButton okButton = new JButton("OK");
	
	FieldSet[] fieldSets = new FieldSet[]{
			new FieldSet(),
			new FieldSet(),
			new FieldSet(),
			new FieldSet(),
			new FieldSet()
	};
	
	JPanel buttonPanel = new JPanel(new GridLayout(1, 2));
	

	public Options(LightModel m, JFrame frame){
		super(frame);
		this.model = m;
		setModal(true);
		setTitle("Lichtquellen einstellen");
		setLayout(new BorderLayout());
		
		closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
		okButton.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				model.update(fieldSets);
				setVisible(false);
			}
		});
		
		buttonPanel.add(closeButton);
		buttonPanel.add(okButton);
		add(buttonPanel, BorderLayout.SOUTH);
		
		
		JTabbedPane tabbed = new JTabbedPane();
		for(int i = 0; i < 5; i++){
			tabbed.add("Licht " + (i + 1), fieldSets[i] );
		}
		add(tabbed, BorderLayout.CENTER);
		pack();
	}
	

	

	public void loadFromModel(){
		model.fill(fieldSets);
	}
	
	public static void main(String[] args){
		Options o = new Options(new LightModel(), null);
		o.loadFromModel();
		o.setVisible(true);
	}
}
