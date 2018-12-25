package net.bigmir;

public class Point {
	private double x;
	private double y;

	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;
	}

	public Point() {
		super();
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double getRadius(Point pointCenter, Point pointRadius) {
		double radius = Math.sqrt(Math.pow(pointRadius.getX() - pointCenter.getX(), 2)
				+ Math.pow(pointRadius.getY() - pointCenter.getY(), 2));
		return radius;
	}

	@Override
	public String toString() {
		return "Point [x=" + x + ", y=" + y + "]";
	}

}
