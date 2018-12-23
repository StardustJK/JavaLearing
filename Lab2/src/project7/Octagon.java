package project7;

import project6.GeometricObject;

public class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable {

	private double side;

	public static void main(String[] args) {
		Octagon o = new Octagon(5);
		System.out.println(o.toString());
		Octagon x = null;
		try {
			x = (Octagon) o.clone();

		} catch (CloneNotSupportedException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		System.out.println(x.toString());
		if (o.compareTo(x) == 0) {
			System.out.println("������ͬһ������");

		} else
			System.out.println("���ǲ���ͬһ������");
	}

	public Octagon() {
	}

	public Octagon(double side) {
		this.side = side;
	}

	public double getArea() {
		return (2 + 4 / Math.sqrt(2)) * side * side;
	}

	public double getPerimeter() {
		return side * 8;
	}

	public double getSide() {
		return side;
	}

	public void setSide(double side) {
		this.side = side;
	}

	public String toString() {
		return "area is " + getArea() + "  perimeter is " + getPerimeter();
	}

	@Override
	public int compareTo(Octagon o) {
		if (this.equals(o))
			return 0;
		else
			return 1;
	}
}
