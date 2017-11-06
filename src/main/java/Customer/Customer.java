package Customer;

import Purchase.PurchaseReceipt;
import Store.BookStore;

public class Customer {
	
	/* Initial price of the books in dollars */
	private int budget;
	
	/**
	 * Getter function to return budget of the customer
	 * @return
	 */
	public int getBudget() {
		return this.budget;
	}
	
	/**
	 * Setter function to set budget of the customer
	 * @param budget
	 */
	public void setBudget(int budget) {
		/* Input validation */
		if (budget < 0)
			throw new IllegalArgumentException("Budget cannot be negative!!");
		else
			this.budget = budget;
	}
	
	/**
	 * Function calls buyBooks method in the implementation class 
	 * to find number of books that can be bought with given budget.
	 * @param budget: Budget available to the customer to buy books.
	 * @return PurchaseReceipt: Receipt for the books bought
	 */
	
	public PurchaseReceipt buyBooks(BookStore bs) {
		PurchaseReceipt pr;
		
		pr = bs.buyBooks(budget);		
		return pr;		
	}
}
