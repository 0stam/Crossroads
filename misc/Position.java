package misc;

public class Position {
	// Fields
	private double x;
	private double y;
	
	// Constructors
	public Position() {
		x = 0;
		y = 0;
	}
	
	public Position(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	// Getters
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	
	
	// Setters
	public void setX(double x) {
		this.x = x;
	}
	
	public void setY(double y) {
		this.y = y;
	}
	
	// Other methods
	public String toString() {
		return "(" + x + ", " + y + ")";
	}
}
