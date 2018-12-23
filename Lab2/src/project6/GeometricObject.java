package project6;

import java.util.Date;

public abstract class GeometricObject {
	private String color;
	private boolean filled;
	private Date dateCreated;

	public GeometricObject() {
	}

	public GeometricObject(String color, boolean filled) {
		this.setColor(color);
		this.setFilled(filled);
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public boolean isFilled() {
		return filled;
	}

	public void setFilled(boolean filled) {
		this.filled = filled;
	}

	public Date getDateCreate() {
		return dateCreated;
	}

	public String toString() {
		return this.toString();
	}

}
