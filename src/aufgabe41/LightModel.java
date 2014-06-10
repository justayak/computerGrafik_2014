package aufgabe41;

import static java.lang.Integer.parseInt;
import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.lang.Math.round;
import static java.lang.Double.parseDouble;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class LightModel {
	protected List<DiffuseLight> lights = Collections.singletonList(new DiffuseLight(Vector3.Null(), 1,1,1));
	

	public void update(FieldSet[] fieldsets){
		lights = new LinkedList<>();
		for(FieldSet fieldset : fieldsets){
			if(fieldset.activatedCheck.isSelected()){
				lights.add(new DiffuseLight(
						extractVector3(fieldset),
						extractColor(fieldset.redField),
						extractColor(fieldset.greenField),
						extractColor(fieldset.blueField)
						));
			}
		}
	}
	
	public void fill(FieldSet[] fieldsets){
		int index = 0;
		for(DiffuseLight df : lights){
			if(fieldsets.length > index){
				fieldsets[index].xField.setText(String.valueOf(df.position.x));
				fieldsets[index].yField.setText(String.valueOf(df.position.y));
				fieldsets[index].zField.setText(String.valueOf(df.position.z));
				
				fieldsets[index].redField.setText(String.valueOf(round(df.LR * 255)));
				fieldsets[index].blueField.setText(String.valueOf(round(df.LB * 255)));
				fieldsets[index].greenField.setText(String.valueOf(round(df.LG * 255)));
				
				fieldsets[index].activatedCheck.setSelected(true);
				fieldsets[index].enableAll(true);
			}
			index++;
		}
		
		while(index < fieldsets.length){
			fieldsets[index].xField.setText("0");
			fieldsets[index].yField.setText("0");
			fieldsets[index].zField.setText("0");
			
			fieldsets[index].redField.setText("0");
			fieldsets[index].greenField.setText("0");
			fieldsets[index].blueField.setText("0");
			
			fieldsets[index].enableAll(false);
			index++;
		}
			
	}

	private float extractColor(JTextField tf){
		String value = tf.getText();
		float x;
		try{
			int v = parseInt(value);
			x = (float) v / 255f;
			x = max(min(x, 1), 0);
		} catch(NumberFormatException ex){
			x = 1;
		}
		return x;
	}
	
	private Vector3 extractVector3(FieldSet fs){
		return new Vector3(
				extractCoordinate(fs.xField),
				extractCoordinate(fs.yField),
				extractCoordinate(fs.zField)
				);
		
		
	}
	
	private double extractCoordinate(JTextField tf){
		double a = 0;
		try{
			a = parseDouble(tf.getText().replace(",", "."));
		} catch(NumberFormatException ex){
			JOptionPane.showMessageDialog(null, tf.getText() + "???", "Kann Feld nicht lesen", JOptionPane.WARNING_MESSAGE);
		}
		return a;
	}

}
