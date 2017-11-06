package Store;

import Purchase.PurchaseReceipt;

public interface BookStoreService {
	/**
	 * Interface method that allows customers to buy books from the Bookstore.
	 * Should be implemented by the BookStore
	 * @param budget
	 * @return
	 */
	public PurchaseReceipt buyBooks(int budget);
}
