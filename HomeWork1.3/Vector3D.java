package net.bigmir;

public class Vector3D {
	private int x;
	private int y;
	private int z;
	public Vector3D(int x, int y, int z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}
	public Vector3D() {
		super();
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	public int getZ() {
		return z;
	}
	public void setZ(int z) {
		this.z = z;
	}
	public Vector3D sum(Vector3D vect1,Vector3D vect2) {
		Vector3D summa = new Vector3D();
		summa.setX(vect1.getX() + vect2.getX());
		summa.setY(vect1.getY() + vect2.getY());
		summa.setZ(vect1.getZ() + vect2.getZ());
		return summa;
	}
	public Vector3D multVect(Vector3D vect1,Vector3D vect2) {
		Vector3D vector = new Vector3D();
		vector.setX(vect1.getY()*vect2.getZ() - vect1.getZ()*vect2.getY());
		vector.setY(vect1.getZ()*vect2.getX() - vect1.getX()*vect2.getZ());
		vector.setZ(vect1.getX()*vect2.getY() - vect1.getY()*vect2.getX());
		return vector;
	}
	public double multScal(Vector3D vect1,Vector3D vect2) {
	double scalar;
	scalar = vect1.getX()*vect2.getX() + vect1.getY()*vect2.getY() + vect1.getZ()*vect2.getZ();
	return scalar;
	}
	@Override
	public String toString() {
		return "Vector3D [x=" + x + ", y=" + y + ", z=" + z + "]";
	}
	

}
