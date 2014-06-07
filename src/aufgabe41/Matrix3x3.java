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
	
	public Matrix3x3(double m11, double m12, double m13,
			double m21, double m22, double m23,
			double m31, double m32, double m33){
		
		this.m11 = m11;
		this.m21 = m21;
		this.m31 = m31;
		
		this.m12 = m12;
		this.m22 = m22;
		this.m32 = m32;
		
		this.m13 = m13;
		this.m23 = m23;
		this.m33 = m33;
	}
	
	public Vector3 multiply(Vector3 v){
		double x = (v.x * m11) + (v.y * m12) + (v.z * m13);
		double y = (v.x * m21) + (v.y * m22) + (v.z * m23);
		double z = (v.x * m31) + (v.y * m32) + (v.z * m33);
		return new Vector3(x,y,z);
		
	}
	
	
	
}
