import java.util.*;
import java.text.SimpleDateFormat;
public class Transaction {
	// instance variables
	private String type;
	private int id;
	private SalesTeam team;
	private String salesPerson;
	private double salePrice;
	private Car car;
	private Calendar calendar;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy MMM dd HH:mm:ss");
	public Transaction(Calendar date, Car car, String salesPerson, String type, double salePrice, int id){
		calendar = date;
		this.type = type;
		this.car = car;
		this.salePrice = salePrice; 
		this.salesPerson = salesPerson;
		this.id = id;
	}
	
	public String display(){
		return "ID " + id + " " + sdf.format(calendar) + " " + type + " SalesPerson: " + salesPerson;
	}
	public int getID(){
		return id;
	}
	

}
