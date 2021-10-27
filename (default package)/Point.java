/*
Description: This program manipulates two points received on the Cartesian plane
*/
public class Point implements PointInterface{

	private int x;
	private int y;
		
		// sets the x and y value to 2, -7
	public Point() {
		x = 2;
		y = -7;
	}
	
		// Sets the points to the values that are passed in
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
		// If the points aren't empty set them to the object passed
	public Point(Point p){
		if(p == null) {throw new IllegalArgumentException("Points cannot be empty. ");}
		else {
			this.x = (p.x);
			this.y = (p.y);
			}
	}
		
		// Returns the coordinates as a string
	public String toString() {return "(" + x + ","  + y + ")";}
	
		// Returns true if the value of object received is equal the the point 
	public boolean equals(Object obj) {
		if (this.getClass().equals(obj.getClass())) {
			Point p = (Point) obj;
			return this.x == p.x && this.y == p.y;
		}else {
			return false;
		}
	}
		
		// Returns the distance between x and y
	public double distanceTo(Point otherPoint) {
		if (otherPoint == null) {
		throw new IllegalArgumentException("No data entered, please enter a value");}
		else {
			double otherDistance = Math.hypot(otherPoint.x, otherPoint.y);
			double distance = Math.hypot(this.x, this.y);
			return distance - otherDistance;
			}
	}

		// Tests if the coordinates are in a quadrant
	public boolean inQuadrant(int quadrant) {
		if (quadrant >= this.x && quadrant <= this.y || quadrant <= this.x && quadrant >= this.y) {
		return true;}
		else {throw new IllegalArgumentException("Point is less than 1 and greater than 4. ");}
	}

		// translates the coordinates to a different position 
	public void translate(int xMove, int yMove) {
		this.x = x + xMove;
		this.y = y + yMove;
	}
}
