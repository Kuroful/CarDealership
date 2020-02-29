// Kevin Ma
// Student Number: 500900756
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;




public class CarDealershipSimulator 
{
  public static void main(String[] args) throws FileNotFoundException
  {
	  // Create a CarDealership object
	  CarDealership dealer = new CarDealership();
	  Car retCar = new Car();
	  AccountingSystem system = new AccountingSystem();
	  ArrayList<Car> newCars = new ArrayList<Car>();
	  Scanner scanner = null;
	  try 
	  {
		  File inputFile = new File("cars.txt");
		  scanner = new Scanner(inputFile);
	  }
	  catch (Exception e)
	  {
		  System.out.println ("File not found");
	  }
	  while (scanner.hasNextLine())
	  {
		  String infoLine = scanner.nextLine();
		  Scanner input = new Scanner(infoLine);
		  String mfr = input.next();
		  String color = input.next();
		  String power = input.next();
		  Vehicle.PowerSource source;
		  if (power.equals("ELECTRIC_MOTOR"))
		  {
			  source = Vehicle.PowerSource.ELECTRIC_MOTOR;
		  }
		  else 
		  {
			  source = Vehicle.PowerSource.GAS_ENGINE;
		  }
		  String model = input.next();
		  Car.Model modelType;
		  if (model.equals("SEDAN"))
		  {
			  modelType = Car.Model.SEDAN;
		  }
		  else if (model.equals("MINIVAN"))
		  {
			  modelType = Car.Model.MINIVAN;
		  }
		  else if (model.equals("SPORTS"))
		  {
			  modelType = Car.Model.SPORTS;
		  }
		  else 
		  {
			  modelType = Car.Model.SUV;
		  }
		  double safetyRating = input.nextDouble();
		  int maxRange = input.nextInt();
		  String isAWD = input.next();
		  boolean AWD;
		  if (isAWD == "AWD")
		  {
			  AWD = true;
		  }
		  else 
		  {
			  AWD = false;
		  }
		  double price = input.nextDouble();
		  if (power == "ELECTRIC_MOTOR")
		  {
			  int rechargeTime = input.nextInt();
			  newCars.add(new ElectricCar(mfr, color, source, 
					  modelType, safetyRating, maxRange, AWD, price, rechargeTime));
		  }
		  else
		  {
			  newCars.add(new Car (mfr, color,  source, 
					  modelType, safetyRating, maxRange, AWD, price));
		  }
	  }
	  // Then create an (initially empty) array list of type Car
      // Then create some new car objects of different types
	  // See the cars file for car object details
	  // Add the car objects to the array list
      // The ADD command should hand this array list to CarDealership object via the addCars() method	  
	  /*
	  ArrayList<Car> newCars = new ArrayList<Car>();
	  newCars.add(new Car ("Toyota", "Blue",  Vehicle.PowerSource.GAS_ENGINE, 
			  Car.Model.SEDAN, 9.5, 500, false, 25000));
	  newCars.add(new Car ("Honda", "red",  Vehicle.PowerSource.GAS_ENGINE,
			  Car.Model.SEDAN, 9.2,  450, false, 30000));
	  newCars.add(new Car ("Kia", "white",  Vehicle.PowerSource.GAS_ENGINE,
			  Car.Model.MINIVAN, 9.7, 550, false, 22000));
	  newCars.add(new Car ("BMW","black",  Vehicle.PowerSource.GAS_ENGINE,  
			  Car.Model.SEDAN, 9.6, 600, true, 55000));
	  newCars.add(new ElectricCar("Tesla","red",  Vehicle.PowerSource.ELECTRIC_MOTOR,  
			  Car.Model.SEDAN, 9.1, 425, true, 85000, 30));
	  newCars.add(new Car("Chevy", "red", Vehicle.PowerSource.GAS_ENGINE,
			  Car.Model.MINIVAN, 9.25, 475, false, 40000));
	  newCars.add(new ElectricCar("ChevyVolt","green", Vehicle.PowerSource.ELECTRIC_MOTOR,  
			  Car.Model.SEDAN, 8.9, 375, true, 37000,  45));
	  newCars.add(new Car("Bentley","black", Vehicle.PowerSource.GAS_ENGINE,
			  Car.Model.SEDAN, 9.8, 575, false, 150000));
	  newCars.add(new ElectricCar("NissanLeaf", "green", Vehicle.PowerSource.ELECTRIC_MOTOR,
			  Car.Model.SEDAN, 8.8, 325, true, 32000, 55)); 
			  */
	  // Create a scanner object
	  Scanner insc = new Scanner(System.in);
	  // while the scanner has another line
	  //    read the input line
	  //    create another scanner object (call it "commandLine" or something) using the input line instead of System.in
	  //    read the next word from the commandLine scanner 
      //	check if the word (i.e. string) is equal to one of the commands and if so, call the appropriate method via the CarDealership object  
	 while (insc.hasNextLine())
	 {
		 String comm = insc.nextLine();
		 Scanner commandLine = new Scanner(comm);
		 String command = commandLine.next();
		 // displays array list of cars
		 if (command.equals("L"))
		 {
			 dealer.displayInventory();
		 }
		 // buys a car from the dealership
		 else if (command.equals("BUY"))
		 {
			 int index = -1;
			 // tries to get the number for the car that the user wants to buy
			 try
			 {
				 index = commandLine.nextInt();
			 }
			 // if it is not a number return invalid command
			 catch (Exception e)
			 {
				 System.out.println("Invalid Command");
			 }
			 
			 retCar = dealer.buyCar(index); 
			 
		 }
		 // returns a car to the dealership
		 else if (command.equals("RET"))
		 {
			 dealer.returnCar(retCar);
		 }
		 // ends the program
		 else if (command.equals("Q"))
		 {
			 return; 
		 }
		 // Sorts the array list by price
		 else if (command.equals("SPR"))
		 {
			 dealer.sortByPrice();
		 }
		 // sorts array list by safety rating
		 else if (command.equals("SSR"))
		 {
			 dealer.sortBySafetyRating();
		 }
		 // sorts array list by maximum range
		 else if (command.equals("SMR"))
		 {
			 dealer.sortByMaxRange();
		 }
		 // filters array list by whether car is Electric or not
		 else if (command.equals("FEL"))
		 {
			 dealer.filterByElectric();
		 }
		 // filters array list by whether the car is AWD or not
		 else if (command.equals("FAW"))
		 {
			 dealer.filterByAWD();
		 }
		 // filters by car's price range in the array list
		 else if (command.equals("FPR"))
		 {
			 try 
			 {
				 double minPrice = commandLine.nextDouble();
				 double maxPrice = commandLine.nextDouble();		 
				 dealer.filterByPrice(minPrice, maxPrice);
			 }
			 catch(Exception e)
			 {
				 System.out.println("Invalid command");
			 }
		 }
		 // clears the filters
		 else if (command.equals("FCL"))
		 {
			 dealer.filtersClear();
		 }
		 // add new set of cars to array list 
		 else if (command.equals("ADD"))
		 {
			 dealer.addCars(newCars);
		 }
		 else if (command.equals("SALES"))
		 {
			 
		 }
		 // if command doesn't make sense return "invalid command"
		 else
		 {
			 System.out.println("Invalid Command");
		 }
	 
			 
	 }
  }
}