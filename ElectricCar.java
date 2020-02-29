// Kevin Ma
// Student Number: 500900756
public class ElectricCar extends Car {
	// instance variables for electric car class
	private int rechargeTime;
	private String batteryType;
	/** 
	Constructor method for the electric car, initialize with given parameters of  model,
	color, powersource, manufacturer, safety rating, max range, AWD, price and recharge time
	@param mfr the manufacturer 
	@param color is the color of the car
	@param power is the powersource of the car
	@param model is the type of model of the car
	@param safetyRating the safety rating of the car
	@param maxRange is the maximum range of the car
	@param AWD determines if the car is AWD or not
	@param price is the price of the car
	@param rechargeTime is the recharging time of the car
	 */
	public ElectricCar(String mfr, String color,  PowerSource power,  Model model, double safetyRating,
			int maxRange, boolean AWD, double price, int rechargeTime) {
		super(mfr, color, power, model, safetyRating, maxRange, AWD, price);
		this.rechargeTime = rechargeTime;
		batteryType = "Lithium";
	}
	// Returns information of recharge time
	public int getRechargeTime(){
		return rechargeTime;
	}
	// returns type of battery
	public String getBatteryTime(){
		return batteryType;
	}
	// Displays information about the electric car
	public String display(){
		return super.display() + " RCH: " + rechargeTime + " Bat: " + batteryType;
	}
	

}
