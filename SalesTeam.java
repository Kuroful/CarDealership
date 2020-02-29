import java.util.*;
public class SalesTeam {
	private LinkedList<String> list;
	private ListIterator iter = list.listIterator();
	public SalesTeam(){
		list = new LinkedList<String>();
		list.add("Bill");
		list.add("Goat");
		list.add("Mason");
		list.add("Dave");
		list.add("Alireza");
	}
	
	public String salesPerson(){
		Random random = new Random();
		int choice = random.nextInt(4);
		return list.get(choice);
	}
	public int getNumberOfSalesPerson(){
		return list.size() + 1;
	}

}
