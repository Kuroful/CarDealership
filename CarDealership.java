// Kevin Ma
// Student Number: 500900756
import java.util.*;

public class CarDealership {
	// empty array list of the cars the dealer wants to offer
	private ArrayList <Car> cars;
	// Car Dealership instance variables
	private boolean electricFilter;
	private boolean awdFilter;
	private boolean priceFilter;
	private double minPrice = 0;
	private double maxPrice = 0;
	
	// determines if car is returned or not
	private boolean returnCar = false;
	/**
	  	Constructor for the car dealership where an empty array list cars is initialized
	 */
	public CarDealership(){
		cars = new ArrayList<Car>();
	}
	// adds cars to the array list
	public void addCars(ArrayList<Car> newCars)
	{
		for (int i = 0; i < newCars.size(); i++)
		{
			cars.add(newCars.get(i));
		}
	}
	// buys a car and removes that particular car from the car array list
	public Car buyCar(int VIN){
		// makes sure the car bought is legitimate
		for (int i =0 ; i < cars.size();i++)
		{
			if(cars.get(i).getVIN() == VIN)
			{
				// GregorianCalendar calendar = new GregorianCalendar();
				Car newCar = cars.get(VIN);
				cars.remove(VIN);
				returnCar = true;
				return newCar;
			}
		}
		// if the number that person wants to buy isn't on the list nothing happens 		
		return null;
		
	}
	// returns recently bought car to the dealer, 
	public void returnCar(Car car){
		// adds the car back to the array list
		if (returnCar == true)
		{
			cars.add(car);
			returnCar = false;
		}
	}
	// displays the current inventory of the cars
	public void displayInventory(){
		// goes through the car inventory
		for (int i = 0; i < cars.size(); i ++)
		{
			// current car
			Car currentCar = cars.get(i);
			// if electric filter is on and the car is electric, print it
			if (electricFilter == true && awdFilter == false && priceFilter == false)
			{
				// checks if car has electric motor
				if (currentCar.getPower() == Vehicle.PowerSource.ELECTRIC_MOTOR)
				{
					System.out.println(currentCar.display());
				}	
			}
			// if the electric filter is on and the AWD filter is on and car meets criteria, print it
			else if (electricFilter == true && awdFilter == true && priceFilter == false)
			{
				// checks if car has AWD and electric motor
				if (currentCar.getPower() == Vehicle.PowerSource.ELECTRIC_MOTOR 
						&&currentCar.getAWD() == true)
				{
					System.out.println(currentCar.display());
				}	
			}
			// if the electric filter, AWD filter and price filter is on, print it if car meets criteria
			else if (electricFilter == true && awdFilter == true && priceFilter == true)
			{
				// checks to see if car has AWD, electric motor and meets min and max price
				if (currentCar.getPower() == Vehicle.PowerSource.ELECTRIC_MOTOR 
						&&currentCar.getAWD() == true  && maxPrice >= currentCar.getPrice() && minPrice <= currentCar.getPrice())
				{
					System.out.println(currentCar.display());
				}	
			}
			// if the electric filter and price filter is on and the car meets requirements, print it
			else if (electricFilter == true && awdFilter == false && priceFilter == true)
			{
				// checks if car has electric motor and meets min and max price
				if (currentCar.getPower() == Vehicle.PowerSource.ELECTRIC_MOTOR 
						 && maxPrice >= currentCar.getPrice() && minPrice <= currentCar.getPrice())
				{
					System.out.println(currentCar.display());
				}	
			}
			// if AWD filter is on and car meets criteria print it
			else if (electricFilter == false && awdFilter == true && priceFilter == false)
			{
				// checks if car is AWD
				if (currentCar.getAWD() == true)
				{
					System.out.println(currentCar.display());
				}	
			}
			// if AWD filter is on and price filter is on and car meets criteria print it
			else if (electricFilter == false && awdFilter == true && priceFilter == true)
			{
				// checks if car is AWD and if it meets max and min price
				if (currentCar.getAWD() == true  && maxPrice >= currentCar.getPrice() && minPrice <= currentCar.getPrice())
				{
					System.out.println(currentCar.display());
				}	
			}
			// if price filter is on and car meets criteria print it 
			else if (electricFilter == false && awdFilter == false && priceFilter == true)
			{
				// checks if car meets min and max price
				if (maxPrice >= currentCar.getPrice() && minPrice <= currentCar.getPrice())
				{
					System.out.println(currentCar.display());
				}	
			}
			
			// if no filters are activated, print normally
			else if (electricFilter == false && priceFilter == false && awdFilter == false)
			{
				System.out.println(currentCar.display());
			}
		}
	}
	// filters the car array list by whether it is electric or not
	public void filterByElectric(){
		electricFilter = true;
	}
	// filters the car array list by whether it is AWD or not 
	public void filterByAWD(){
		awdFilter = true;
	}
	// filters the array list based on minimum and maximum price
	public void filterByPrice(double minPrice, double maxPrice){
		this.minPrice = minPrice;
		this.maxPrice = maxPrice;
		priceFilter = true;
	}
	// clears out all the filters 
	public void filtersClear(){
		electricFilter = false;
		awdFilter = false;
		priceFilter = false;
		minPrice = 0;
		maxPrice = 0;
	}
	// sorts car based on the price of the car in ascending order
	public void sortByPrice(){
		Collections.sort(cars);
	}
	// sorts car based on the safety rating of the car in ascending order
	public void sortBySafetyRating(){
		Collections.sort(cars, new sortSafetyRating());
	}
	// sorts car based on the max rnage of the car in ascending order
	public void sortByMaxRange(){
		Collections.sort(cars, new sortMaxRange());
	}
	// returns the size of the array list 
	public int getSize(){
		return cars.size();
	}

}
// sorts the cars in the array list based on the safety rating
class sortSafetyRating implements Comparator<Car>
{
	// compares the safety rating of the two cars
	public int compare(Car carOne, Car carTwo) 
	{
		if (carOne.getSafetyRating() > carTwo.getSafetyRating())return 1;
		if (carOne.getSafetyRating() < carTwo.getSafetyRating())return -1;
		return 0;
	}
	
	
}
// sorts the cars in the array list based on the maximum range
class sortMaxRange implements Comparator<Car>{
	// compares the safety of the two cars 
	public int compare(Car carOne, Car carTwo) 
	{
		if (carOne.getMaxRange() > carTwo.getMaxRange())return 1;
		if (carOne.getMaxRange() < carTwo.getMaxRange())return -1;
		return 0;
	}
	
}
