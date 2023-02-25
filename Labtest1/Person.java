
public class Person {

	// Instance variables
	private String email;
	private int height;
	private int weight;

	// Static variables
	private static int numPersons = 0;

	// Setters & Getters
	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return this.email;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getHeight() {
		return this.height;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public int getWeight() {
		return this.weight;
	}

	// Constructor
	public Person() {
		numPersons++;
	}

	// Returns Body-Mass-Index 
	public double BMI() {
		double height_m = (double) this.height / 100;
		double bmi = weight / (height_m * height_m);
		return bmi;
	}

}
