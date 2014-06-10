package aufgabe41;

import static java.lang.Integer.parseInt;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class LightModel {
	protected SourceOfLight[] lights = new SourceOfLight[5];
	
	protected boolean[] activated = {true, true, true, true, true};
	
	
	public int getHTMLRed(int index){
		return Math.round(lights[index].getRed() * 255);
	}
	
	public int getHTMLGreen(int index){
		return Math.round(lights[index].getGreen() * 255);
	}
	
	public int getHTMLBlue(int index){
		return Math.round(lights[index].getBlue() * 255);
	}
	
	public void setHTMLRed(int index, String value){
		lights[index].setRed(extract(value));
	}
	
	public void setHTMLGreen(int index, String value){
		lights[index].setGreen(extract(value));
	}
	
	public void setHTMLBlue(int index, String value){
		lights[index].setBlue(extract(value));
	}
	
	private float extract(String value){
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

}
