package net.bigmir;

public class Circle extends Shape {
	private Point pointCenter;
	private Point pointRadius;
	private Point pointOne = new Point();

	public Circle(Point pointCenter, Point pointRadius) {
		super();
		this.pointCenter = pointCenter;
		this.pointRadius = pointRadius;
	}

	public Point getPointCenter() {
		return pointCenter;
	}

	public void setPointCenter(Point pointCenter) {
		this.pointCenter = pointCenter;
	}

	public Point getPointRadius() {
		return pointRadius;
	}

	public void setPointRadius(Point pointRadius) {
		this.pointRadius = pointRadius;
	}

	public double getPerimetr() {
		double perimetr = 2 * Math.PI * pointOne.getRadius(pointCenter, pointRadius);
		return perimetr;
	}

	public double getArea() {
		double area = Math.PI * Math.pow(pointOne.getRadius(pointCenter, pointRadius), 2);
		return area;
	}

	@Override
	public String toString() {
		return "Circle [pointCenter=" + pointCenter + ", pointRadius=" + pointRadius + " ]";
	}

}
