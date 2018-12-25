package net.bigmir;

public class Square extends Shape {
	private Point pointA;
	private Point pointB;
	private Point pointTwo = new Point();

	public Square(Point pointA, Point pointB) {
		super();
		this.pointA = pointA;
		this.pointB = pointB;
	}

	public Square() {
		super();
	}

	public Point getPointA() {
		return pointA;
	}

	public void setPointA(Point pointA) {
		this.pointA = pointA;
	}

	public Point getPointB() {
		return pointB;
	}

	public void setPointB(Point pointB) {
		this.pointB = pointB;
	}

	public double getPerimetr() {
		double perimetr = 4 * pointTwo.getRadius(pointA, pointB);
		return perimetr;
	}

	public double getArea() {
		double area = Math.pow(pointTwo.getRadius(pointA, pointB), 2);
		return area;
	}

	@Override
	public String toString() {
		return "Square [pointA=" + pointA + ", pointB=" + pointB + "]";
	}

}
