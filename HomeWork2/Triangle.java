package net.bigmir;

public class Triangle extends Shape{
	private Point pointA;
	private Point pointB;
	private Point pointC;
	private Point pointThree = new Point();

	public Triangle(Point pointA, Point pointB, Point pointC) {
		super();
		this.pointA = pointA;
		this.pointB = pointB;
		this.pointC = pointC;
	}

	public Triangle() {
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

	public Point getPointC() {
		return pointC;
	}

	public void setPointC(Point pointC) {
		this.pointC = pointC;
	}

	public double getPerimetr() {
		double perimetr = pointThree.getRadius(pointA, pointB) + pointThree.getRadius(pointB, pointC)
				+ pointThree.getRadius(pointA, pointC);
		return perimetr;
	}

	public double getArea() {
		double sideOne = pointThree.getRadius(pointA, pointB);
		double sideTwo = pointThree.getRadius(pointB, pointC);
		double sideThree = pointThree.getRadius(pointA, pointC);
		double p = getPerimetr()/2;
		double area = Math.sqrt(p*(p-sideOne)*(p-sideTwo)*(p-sideThree));
		return area;
	}

	@Override
	public String toString() {
		return "Triangle [pointA=" + pointA + ", pointB=" + pointB + ", pointC=" + pointC + "]";
	}
	
}
