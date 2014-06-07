package aufgabe41;

/**
 * Created by Julian on 07.06.2014.
 */
public class Matrix3x3 {
	
	public double v0[] = new double[3];
	public double v1[] = new double[3];
	public double v2[] = new double[3];
	
	protected Matrix3x3(){
		
	}
				  
	
	public Matrix3x3(Vector3 column1, Vector3 column2, Vector3 column3){
		this.v0[0] = column1.x;
		this.v0[1] = column1.y;
		this.v0[2] = column1.z;
		
		this.v1[0] = column2.x;
		this.v1[1] = column2.y;
		this.v1[2] = column2.z;
		
		this.v2[0] = column3.x;
		this.v2[1] = column3.y;
		this.v2[2] = column3.z;
		
	}
	
	public Matrix3x3(double m11, double m12, double m13,
			double m21, double m22, double m23,
			double m31, double m32, double m33){
		
		this.v0[0] = m11;
		this.v0[1] = m21;
		this.v0[2] = m31;
		
		this.v1[0] = m12;
		this.v1[1] = m22;
		this.v1[2] = m32;
		
		this.v2[0] = m13;
		this.v2[1] = m23;
		this.v2[2] = m33;
	}
	
	public Vector3 multiply(Vector3 v){
		double x = (v.x * v0[0]) + (v.y * v1[0]) + (v.z * v2[0]);
		double y = (v.x * v0[1]) + (v.y * v1[1]) + (v.z * v2[1]);
		double z = (v.x * v0[2]) + (v.y * v1[2]) + (v.z * v2[2]);
		return new Vector3(x,y,z);
		
	}
	
	/**
	 * this matrix is on the left side,
	 * the matrix in the param is on the right side.
	 * @param matrix right side matrix
	 * @return
	 */
	public Matrix3x3 multiply(Matrix3x3 matrix) {
		Matrix3x3 result = new Matrix3x3();
		for(int i = 0; i < 3; i ++){
			for(int j = 0; i < 3; j++){
				calculateElement(i, j, result, matrix);
			}
		}
		
		return result;
	}
	
	private void calculateElement(int i, int j, Matrix3x3 result, Matrix3x3 matrix){
		double sum = 0;
		for(int k = 0; k < 3; k++){
			sum += get(i,k) * matrix.get(k, j);
		}
		
		result.set(i, j, sum);
	}
	
	public double get(int i, int j){
		switch(i){
		case 0:
			return v0[j];
		case 1:
			return v1[j];
		case 2: 
			return v2[j];
		}
		throw new IndexOutOfBoundsException("index must be between 0 and 2 but was(" + i + "," + j + ")");
	}
	
	
	public void set(int i, int j, double x){
		switch(i){
		case 0:
			v0[j] = x;
			return;
		case 1:
			v1[j] = x;
			return;
		case 2:
			v2[j] = x;
			return;
		}
		throw new IndexOutOfBoundsException("index must be between 0 and 2 but was (" + i + "," + j + ")");
		
	}
	
	
	
	
}
