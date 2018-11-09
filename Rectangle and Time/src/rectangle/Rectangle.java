package rectangle;

public class Rectangle {

	public static void main(String[] args) {
		// TODO 自动生成的方法存根
		Rectangle r1=new Rectangle(-4,40);
		Rectangle r2=new Rectangle(3.5,35.9);
		r1.setColor("red");
		r2.setColor("red");
		System.out.println(r1.toString());
		System.out.println(r2.toString());
		
	}
	private double width;
	private double height;
	private String color;
	public Rectangle() {
		width=1;
		height=1;
		color="black";
	}
	public Rectangle(double width_,double height_) {
			this();
		if(width_<=0||height_<=0) {
			System.out.println("请输入正数");
		}
		else {
		width=width_;
		height=height_;
		}
	}
	public double getWidth() {
		return width;
	}
	public void setWidth(double width) {
		this.width = width;
	}

	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public double getArea() {
		return width*height;
	}
	public double getPerimeter() {
		return 2*(width+height);
	}
	public String toString() {
		return  "width:"+width+"   height:"+height+"   color:"+color+
				"   area:"+getArea()+"   perimeter:"+getPerimeter();
	}
}
