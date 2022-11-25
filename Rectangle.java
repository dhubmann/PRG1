
public class Rectangle {

	// private instance variables
	private Point point1 = new Point();
	private Point point2 = new Point();
	public int width, height, area;

	// static variables
	private static int numRec = 0;

	// FIRST POINT
	// Setter for first point
	public void setFirstPoint(Point point1) {
		this.point1 = point1;
	}

	// Getter for first point
	public Point getFirstPoint() {
		return this.point1;
	}

	// SECOND POINT
	// Setter for second point
	public void setSecondPoint(Point point2) {
		this.point2 = point2;
	}

	// Getter for second point
	public Point getSecondPoint() {
		return this.point2;
	}

	// Getter for number of rectangles created
	public int getNumRec() {
		return numRec;
	}

	// Constructor
	public Rectangle() {
		numRec++;
	};

	// To-Do: methods for calculating width (x), height (y), area (w*h)
	// Calculates the rectangle's width
	public int width() {
		int max = Math.max(point1.getX(), point2.getX());
		int min = Math.min(point1.getX(), point2.getX());
		int width = max - min;
		return width;
	}

	// Calculates the rectangle's height
	public int height() {
		int max = Math.max(point1.getY(), point2.getY());
		int min = Math.min(point1.getY(), point2.getY());
		int height = max - min;
		return height;
	}

	// Calculates the rectangle's area
	public int area() {
		int width = width();
		int height = height();
		return width * height;
	}

	// To-Do: methods for drawing rectangle

	// create new rectangle (menu function) ?!?!?!?!?!?

}
