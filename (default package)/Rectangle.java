
public class Rectangle {
	
	protected int width;
	protected int height;
	
	public Rectangle() {
		this.width = 5;
		this.height = 2;
	}
	
	public Rectangle(int width, int height) {
		if (width < 0 || height < 0)throw new IllegalArgumentException("a dimension cannot be negative");
		this.width = width;
		this.height = height;
	}
	
	public String toString() {
		return this.getClass().getName() + ": " + width + "x" + height;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getPerimeter() {
		return 2*width + 2*height;
	}
	
	public int getSumOfDimensions() {
		return this.width + this.height;
	}
}
