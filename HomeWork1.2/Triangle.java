package net.bigmir;

public class Triangle {
	private double a;
	private double b;
	private double c;

	public Triangle(double a, double b, double c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public double getA() {
		return a;
	}

	public void setA(double a) {
		this.a = a;
	}

	public double getB() {
		return b;
	}

	public void setB(double b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public double area() {
		double triangleArea;
		double p = (a + b + c) / 2;
		triangleArea = Math.sqrt(p * (p - a) * (p - b) * (p - c));
		return triangleArea;
	}

	public void checkTriangle() {
		if (a + b > c && a + c > b && b + c > a) {
			System.out.println("This triangle exists");
		} else {
			System.out.println("Triangle like this doesn't exist");
		}
	}

	public void print() {
		checkTriangle();
		System.out.println("The area of Triangle is: " + area());

	}

}
