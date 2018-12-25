package net.bigmir;

public class Main {

	public static void main(String[] args) {
		Circle circleOne = new Circle(new Point(1, 0), new Point(3, 0));
		Square squareOne = new Square(new Point(1, 1), new Point(5, 5));
		Triangle triangleOne = new Triangle(new Point(0, 4), new Point(1, 1), new Point(0, 2));
		Board boardOne = new Board();
		System.out.println(circleOne);
		System.out.println("The perimetr of the circle is: " + circleOne.getPerimetr());
		System.out.println("The area of the circle is: " + circleOne.getArea());
		System.out.println();
		System.out.println(squareOne);
		System.out.println("The perimetr of the square is: " + squareOne.getPerimetr());
		System.out.println("The area of the square is: " + squareOne.getArea());
		System.out.println();
		System.out.println(triangleOne);
		System.out.println("The perimetr of the triangle is: " + triangleOne.getPerimetr());
		System.out.println("The area of the triangle is: " + triangleOne.getArea());
		System.out.println();
		boardOne.setShape(circleOne, 1);
		boardOne.setShape(triangleOne, 1);
		boardOne.setShape(squareOne, 2);
		boardOne.deleteShape(circleOne, 1);
		boardOne.setShape(triangleOne, 3);
		boardOne.setShape(triangleOne, 2);
		boardOne.setShape(circleOne, 4);
		System.out.println();
		System.out.println(boardOne.toString());
		System.out.println("The summary area of shapes is: " + boardOne.areaAll());
	

	}

}
