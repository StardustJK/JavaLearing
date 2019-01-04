package project6;

import java.util.Scanner;

public class Triangle extends GeometricObject {

	private double side1 = 1.0, side2 = 1.0, side3 = 1.0;

	public static void main(String[] args) {
		//(1,1.5,1)的实例
		var t = new Triangle(1, 1.5, 1);
		t.setColor("yellow");
		t.setFilled(true);
		System.out.println(t.toString());
		//无参构造的实例
		var t2=new Triangle();
		System.out.println(t2.toString());
		//用户输入
		Scanner in=new Scanner(System.in);
		double[] side=new double[3];
		while(true) {
		for(int i=0;i<3;i++) {
			System.out.println("请输入第"+(i+1)+"条边");
			side[i]=in.nextDouble();
		}
		if((side[0]+side[1]<=side[2])||(side[1]+side[2]<=side[0])
				||(side[2]+side[0]<=side[1])) {
			System.out.println("这样的三角形不存在,请重新输入");
			continue;
		}
		else {
			var t3=new Triangle(side[0],side[1],side[2]);
			System.out.println("请输入颜色");
			String color=in.next();
			System.out.println("请输入is filled");
			boolean filled=in.nextBoolean();
			t3.setColor(color);
			t3.setFilled(filled);
			System.out.println(t3.toString());
			break;
			
		}
		}
		in.close();

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
	//获得周长
	public double getPerimeter() {
		return side1 + side2 + side3;
	}
	//获得面积
	public double getArea() {
		double p = getPerimeter();
		return (Math.sqrt(p * (p - side1) * (p - side2) * (p = side3)));
	}
	//打印三角形三边、周长、面积、颜色、创建时间等信息
	@Override
	public String toString() {
		return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3
				+"\nCreatedDate: "+getDateCreate()+"\nArea: "+getArea()
				+"\nPerimeter: "+getPerimeter()+"\nColor: "+getColor()
				+"\nFilled or not: "+isFilled();
	}
}
