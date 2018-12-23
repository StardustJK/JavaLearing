package project6;

public class Triangle extends GeometricObject {

	private double side1 = 1.0, side2 = 1.0, side3 = 1.0;

	public static void main(String[] args) {
		var t = new Triangle(1, 1.5, 1);
		t.setColor("yellow");
		t.setFilled(true);
		System.out.println(t.toString());
		System.out.println("Area :" + t.getArea());
		System.out.println("Perimeter :" + t.getPerimeter());
		System.out.println("Color :" + t.getColor());
		System.out.println("filled or not :" + t.isFilled());

	}

	public Triangle() {

	}

	public Triangle(double side1, double side2, double side3) {
		this.setSide1(side1);
		this.setSide2(side2);
		this.setSide3(side3);
	}

	public double getSide1() {
		return side1;
	}

	public void setSide1(double side1) {
		this.side1 = side1;
	}

	public double getSide2() {
		return side2;
	}

	public void setSide2(double side2) {
		this.side2 = side2;
	}

	public double getSide3() {
		return side3;
	}

	public void setSide3(double side3) {
		this.side3 = side3;
	}

	public double getPerimeter() {
		return side1 + side2 + side3;
	}

	public double getArea() {
		double p = getPerimeter();
		return (Math.sqrt(p * (p - side1) * (p - side2) * (p = side3)));
	}

	@Override
	public String toString() {
		return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
	}
}
