// Kevin Ma
// Student Number: 500900756
import java.util.*;
public class Vehicle {
	// instance variables for vehicle class
	private int VIN;
	private String mfr;
	private String color;
	private int numWheels;
	// class of constants for PowerSource enum
	public static enum PowerSource{
		ELECTRIC_MOTOR, GAS_ENGINE;		
	}
	public PowerSource power;
	/**
	 * Constructor for the vehicle class if there are no parameters where manufacturer is an empty string
	 */
	public Vehicle()
	{
		this.mfr = " ";
	}
	/**
	 *  constructor for the vehicle
	 * @param mfr represents the manufacturer of the vehicle
	 * @param color represents the color of the vehicle
	 * @param numWheels represents the number of wheels of the vehicle
	 * @param power represents the power source of the vehicle 
	 */
	public Vehicle(String mfr, String color,  int numWheels, PowerSource power){
		this.mfr = mfr;
		this.color = color;
		this.power = power;
		this.numWheels = numWheels;
		Random random = new Random();
		VIN = random.nextInt(900) + 100; 
	}
	// returns information about the power source
	public PowerSource getPower(){
		return power;
	}
	// returns the number of wheels on the vehicle
	public int getNumWheels(){
		return numWheels;
	}
	// return the color of the car
	public String getColor(){
		return color;
	}
	// return the manufacturer of the car
	public String getMfr()
	{
		return mfr;
	}
	public int getVIN()
	{
		return VIN;
	}
	// determines if a vehicle is equal to another or not
	public boolean equals(Object other)
	{
		Vehicle otherV = (Vehicle)other;
		String otherMfr = otherV.getMfr();
		PowerSource otherPower = otherV.getPower();
		int otherNumWheels = otherV.getNumWheels();
		// returns true if vehicle is equal
		if (otherMfr == mfr && power == otherPower && numWheels == otherNumWheels){
			return true;
		}
		// returns false if not 
		else
		{
			return false;
		}
	}
	// displays information about the vehicle
	public String display(){
		return "VIN: " + VIN + "Manufacturer: " + mfr + " Color: " + color;
	}
}
