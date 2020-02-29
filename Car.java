// Kevin Ma
// Student Number: 500900756
public class Car extends Vehicle implements Comparable <Car>
{
	// Car instance variables
	private int maxRange;
	private double safetyRating;
	private boolean AWD;
	private double price;
	// class of constants for model enum
	public static enum Model{
		SEDAN, SUV, MINIVAN, SPORTS;
	}
	public Model model;
	
	/**
	 	Constructor method for the car if there are no parameters where price is set to zero
	 */
	public Car()
	{
		price = 0;
	}
	
	/** 
		Constructor method for the car, initialize with given parameters of  model,
		color, powersource, manufacturer, safety rating, max range, AWD, and price
		@param mfr the manufacturer 
		@param color is the color of the car
		@param power is the powersource of the car
		@param model is the type of model of the car
		@param safetyRating the safety rating of the car
		@param maxRange is the maximum range of the car
		@param AWD determines if the car is AWD or not
		@param price is the price of the car
	*/
	public Car(String mfr, String color,PowerSource power,  
			Model model, double safetyRating, int maxRange, boolean AWD, double price) {
		super(mfr, color, 4, power);
		this.maxRange = maxRange;
		this.safetyRating = safetyRating;
		this.AWD = AWD;
		this.price = price;
		this.model = model;
		
		
	}
	// determines if the car is equal to each other
	public boolean equals(Object other){
		Car otherCar = (Car)other;
		// return true if its equal
		if (super.equals(other) && otherCar.getAWD() == this.AWD && model.equals(otherCar.getModel())){
			return true;
		}
		// false if it is not equal
		else
		{
			return false;
		}
	}
	// return whether car is AWD or not
	public boolean getAWD(){
		return AWD;
	}
	// return model of the car
	public Model getModel(){
		return model;
	}
	// return the price of the car
	public double getPrice(){
		return price;
	}
	// return safety rating of the car
	public double getSafetyRating(){
		return safetyRating;
	}
	// return maximum range of the car
	public int getMaxRange(){
		return maxRange;
	}
	// displays through string information about the car 
	public String display()
	{
		return super.display() + " " + model + " RNG: " + maxRange + " SF: " + 
				safetyRating + " AWD: " + AWD + " $ " + price;
	}
	// compare car to another car
	public int compareTo(Car other){
		if (this.price > other.getPrice()) return 1;
		if (this.price < other.getPrice()) return - 1;
		return 0;
	}
	

}
