package chessjava;

public class Point {

	// fields
	public int x;
	public int y;
	
	
	// constructors
	public Point() {
		this.x = 0;
		this.y = 0;
	}
	
	public Point(int x, int y) {
		if (x >= 0 && x <= 7 && y >= 0 && y <= 7) 
                {
			this.x = x;
			this.y = y;
		}
	}
	
	
	// methods
	public boolean isValidPoint() 
        {
		if (this.x >= 0 && this.x <= 7 && this.y >= 0 && this.y <= 7) 
                {
			return true;
		}
		return false;
	}
        
        public boolean isValidPoint(Point pt) 
        {
		if (pt.x >= 0 && pt.x <= 7 && pt.y >= 0 && pt.y <= 7) 
                {
			return true;
		}
		return false;
	}
	
	public Point north() {
		return new Point(this.x, this.y + 1);
	}
	
	public Point south() {
		return new Point(this.x, this.y - 1);
	}
	
	public Point east() {
		return new Point(this.x + 1, this.y);
	}
	
	public Point west() {
		return new Point(this.x - 1, this.y);
	}
	
	public Point ne() {
		return new Point(this.x + 1, this.y + 1);
	}
	
	public Point se() {
		return new Point(this.x + 1, this.y - 1);
	}
	
	public Point nw() {
		return new Point(this.x - 1, this.y + 1);
	}
	
	public Point sw() {
		return new Point(this.x - 1, this.y - 1);
	}
	
}
