package aufgabe41;

/**
 * Created by Julian on 07.06.2014.
 */
public class Matrix3x3 {
	
	public double m11, m12, m13, 
				  m21, m22, m23, 
				  m31, m32, m33;
				  
	
	public Matrix3x3(Vector3 column1, Vector3 column2, Vector3 column3){
		this.m11 = column1.x;
		this.m21 = column1.y;
		this.m31 = column1.z;
		
		this.m22 = column2.x;
		this.m22 = column2.y;
		this.m32 = column2.z;
		
		this.m13 = column3.x;
		this.m23 = column3.y;
		this.m33 = column3.z;
		
	}
}
