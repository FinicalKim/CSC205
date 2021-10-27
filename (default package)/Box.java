/*
Description: This is a program that will extend Rectangle and add a depth dimension then return the description of the box such as the surface area, sum of dimensions , and dimensions.
*/
public class Box extends Rectangle{
		//protected global variable
	protected int depth;
		//default constructor calling the parent class and giving the dimensions values
	public Box() {
		super();
		this.depth = 6;
	}
		//constructor with three parameters setting the dimensions to what is passed in
	public Box(int width, int height, int depth){
		if (width < 0 || height < 0 || depth < 0)throw new IllegalArgumentException("a dimension cannot be negative");
		this.width = width;
		this.height = height;
		this.depth = depth;
	}
		//return the dimensions as a sting (width x height x depth)
	public String toSting() {
		return this.getClass().getName() + ": " + width + "x" + height + "x" + depth;
	}
		// this method should not be called
	public void getParameter() {
		throw new IllegalStateException("You shouldn't be here");
	}
		//returns the width dimension as an int value
	public int getWidth() {
		return this.width;
	}
		//returns the sum of the objects dimensions as an int
	public int getSumOfDimensions() {
		return this.width + this.height + this.depth;
	}
		//returns the surface area of the object as an int
	public int getSurfaceArea() {
		return 2*(depth*width+width*height+depth*height);
	}
	
}
