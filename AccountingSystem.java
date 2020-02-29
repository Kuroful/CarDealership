import java.util.*;
public class AccountingSystem {

	private ArrayList<Transaction> transactions;
	
	public AccountingSystem(){
		transactions = new ArrayList<Transaction>();
	}
	
	public String add(Calendar date, Car car, String salesPerson, String type, double salePrice){
		Random random = new Random();
		int id = random.nextInt(99) + 1;
		Transaction transaction = new Transaction (date, car, salesPerson, type, salePrice, id);
		transactions.add(transaction);
		return transaction.display();
	}
	public Transaction getTransaction(int id)
	{
		for (int i = 0; i < transactions.size(); i ++)
		{
			if(transactions.get(i).getID() == id)
			{
				return transactions.get(i);
			}
		}
		return null;
	}
}
