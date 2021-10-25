
/*CSC 205: 12247 / Asynchronous (no meets)
Minilab: # 5 Point
Author: Kim Finical & ID# 36283133
Description: 
*/
public class Segment implements SegmentInterface{

	public Point firstPoint;
	public Point endPoint;
	
		// sets the first segment to (1, 1) and the second segment to (7, 7)
	public Segment(){
		this.firstPoint = new Point(1, 1);
		this.endPoint = new Point(7, 7);
	}
	
		// sets the first and second segment to what is passed in
	public Segment(Point k,Point i){
		if (k == null || i == null) {
			throw new IllegalArgumentException("Value is empty");}
		else if(k.equals(i)) {
			throw new IllegalArgumentException("Values are equal to eachother error");}
		else {
		this.firstPoint = k;
		this.endPoint = i;}
	}
	
		// sets the first segment to (0, 0) and the second segment to what is passed in
	public Segment(Point j) {
		if (j == null) {
			throw new IllegalArgumentException("value is empty ");
		}
		if (j.equals(new Point(0, 0))) {
			throw new IllegalArgumentException("first point cannot equal the second point ");
		}
		this.firstPoint = new Point(0, 0);
		this.endPoint = j;
	}
		// deepcopy constructor
	public Segment(Segment copy) {
		if (copy == null) {
			throw new IllegalArgumentException("Value is empty");
		}
		
		this.firstPoint = new Point (copy.firstPoint);
		this.endPoint = new Point (copy.endPoint);
	}
	
	//toString - returns its representation as a String in the form "Segment" then endpoint1 then endpoint2
		public String toString() { return "Segment " + this.firstPoint + this.endPoint;}
			
		//length - returns the length
	public double length() { return firstPoint.distanceTo(endPoint);}
	
		//translate - shifts the whole segment by xmove (in x direction) and ymove (in y direction)
	public void translate(int xmove, int ymove) {
		this.firstPoint.translate(xmove, ymove);
		this.endPoint.translate(xmove, ymove);
	}
		//isAnEndpoint - returns true if the received Point is an endpoint of this Segment
	public boolean isAnEndpoint(Point point) {
		if (firstPoint.equals(point)) {
			return true;
		}
		if (endPoint.equals(point)) {
			return true;
		}
		return false;
	}
	
	//equals - returns true if this Segment is equal to the one that is passed in (endpoints can be in either order)
		public boolean equals(Object obj) {
				if (this.getClass().equals(obj.getClass())) {
					Segment s = (Segment) obj;
					return (this.firstPoint.equals(s.firstPoint) && this.endPoint.equals(s.endPoint)) || 
							(this.firstPoint.equals(s.endPoint) && this.endPoint.equals(s.firstPoint));
				}else {
					return false;
				}
			
	}
}
