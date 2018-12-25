package net.bigmir;

public class Main {

	public static void main(String[] args) {
		Vector3D vectorOne = new Vector3D(1, 6, -2);
		Vector3D vectorTwo = new Vector3D(8, 4, 3);
		Vector3D result = new Vector3D();
		System.out.println(vectorOne);
		System.out.println(vectorTwo);
		System.out.println();
		System.out.println("Sum of vectors: ");
		System.out.println(result.sum(vectorOne, vectorTwo));
		System.out.println();
		System.out.println("Vectors Multiply of vectors: ");
		System.out.println(result.multVect(vectorOne, vectorTwo));
		System.out.println();
		System.out.println("Scalar multiply of vectors: ");
		System.out.println(result.multScal(vectorOne, vectorTwo));
	}

}
