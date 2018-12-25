package net.bigmir;


public class Board {
	private Shape[] boardArray = new Shape[4];

	public void setShape(Shape shape, int order) {
		if (order > 0 && order < 5) {
			if (boardArray[order - 1] == null) {
				boardArray[order - 1] = shape;
				System.out.println("On the " + order + " place you have set a " + shape);
			} else {
				System.out.println("Sorry, but there is a shape here already");
			}
		} else {
			System.out.println("The board has only four parts");
		}
	}

	public void deleteShape(Shape someShape, int order) {
		if (order > 0 && order < 5) {
			if (boardArray[order - 1] != null) {
				boardArray[order - 1] = null;
				System.out.println("On the " + order + " place you deleted a " + someShape);
			}
		} else {
			System.out.println("The board has only four parts");
		}
	}

	public double areaAll() {
		double sum = 0;
		for (int i = 0; i < boardArray.length; i++) {
			if (boardArray[i] != null) {
				sum += boardArray[i].getArea();
			}

		}
		return sum;
	}

	@Override
	public String toString() {
		String line = "Current board";
		line +=System.lineSeparator();
		for(int i = 0;i<boardArray.length;i++) {
			if(boardArray[i]!=null) {
			line += "In the " + (int)(i+1) + " part of board is " + boardArray[i];
			}else {
				line += "The " + (int)(i+1) + " part of board is empty ";
			}
			line += System.lineSeparator();
		}
		return line;
	}
	
}
