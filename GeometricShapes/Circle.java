/* 
 * Circle
 * Represents a circle
 * Author: Daniel Hubmann
 * Last Change: 07.12.2022
 */

public class Circle {

	// Instance variables
	private Point center = new Point();
	private int radius;

	// Static variables
	private static int numCircles = 0;

	// Setter for center point
	public void setCenter(Point center) {
		this.center = center;
	}

	// Getter for center point
	public Point getCenter() {
		return this.center;
	}

	// Setter for radius
	public void setRadius(int radius) {
		this.radius = radius;
	}

	// Getter for radius
	public int getRadius() {
		return this.radius;
	}

	// Static getter for number of circles created
	public static int getNumCircles() {
		return numCircles;
	}

	// Constructor
	public Circle() {
		numCircles++;
	}

	// Calculates area
	public double area() {
		return this.radius * this.radius * Math.PI;
	}

	// Prints dimensions
	public void dimensions() {
		System.out.println("  Center: " + "(" + getCenter().getX() + "," + getCenter().getY() + ")");
		System.out.println("  Radius: " + getRadius());
		System.out.printf("  Area:   %.2f\n", this.area());
	}

	// Draws circle
	public void draw() {
		String horizontal = "--";
		String vertical = "|";
		String space = " ";
		String center = "::";

		if (radius != 0) {
			System.out.println(space.repeat(3) + space.repeat(radius * 2) + horizontal);
			for (int i = 0; i < radius; i++) {
				System.out.println();
			}
			System.out.println(space.repeat(2) + vertical + space.repeat(radius * 2) + center + space.repeat(radius * 2)
					+ vertical);
			for (int i = 0; i < radius; i++) {
				System.out.println();
			}
			System.out.println(space.repeat(3) + space.repeat(radius * 2) + horizontal);
		}

	}

}
