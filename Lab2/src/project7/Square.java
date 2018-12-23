package project7;

import project6.GeometricObject;

public class Square extends GeometricObject implements Colorable {
	public static void main(String[] args) {
		GeometricObject[] o = new GeometricObject[5];
		o[0] = new Square("blue", true);
		o[1] = new Square("red", true);
		o[2] = new Square("purple", true);
		o[3] = new Square("black", false);
		o[4] = new Square("while", false);
		for (int i = 0; i < 5; i++) {
			((Square) o[i]).howToColor();
		}
	}

	public Square() {
		super();
	}

	public Square(String color, boolean filled) {
		super(color, filled);
	}

	@Override
	public void howToColor() {
		if (isFilled())
			System.out.println("how to color the Square: " + getColor());
		else
			System.out.println("not filled");

	}

}
