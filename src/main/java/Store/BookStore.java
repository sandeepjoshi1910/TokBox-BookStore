package Store;

import Purchase.PurchaseReceipt;
import Store.BookStoreService;

public class BookStore implements BookStoreService{
	
	private static BookStore bs = null;
	
	/* Initial price of the books in dollars */
	private int initPrice;
	
	/* Discount offered in dollars*/
	private int discount;
	
	/* Floor Price in dollars */
	private int floorPrice;
	
	/* Constructor to initialize the init_price, discount and floor_price of the BookStore */
	private BookStore() {
		initPrice = 0;
		discount = 0;
		floorPrice = 0;
	}
	
	/**
	 * Function to get the single instance of BookStore
	 * @return BookStore instance
	 */
	public static synchronized BookStore getInstance() {
		if (bs == null) {
			bs = new BookStore();
		}
		
		return bs;
	}
	
	/**
	 * Getter function to return the initial price of the books
	 * set by the bookstore
	 * @return initPrice
	 */
	public int getInitPrice() {
		return this.initPrice;
	}
	
	/**
	 * Getter function to return the discount offered by the bookstore
	 * @return discount
	 */	
	public int getDiscount() {
		return this.discount;
	}
	
	/**
	 * Getter function to return the floor price of the books
	 * set by the bookstore
	 * @return floorPrice
	 */
	public int getFloorPrice() {
		return this.floorPrice;
	}
	
	/**
	 * Setter function set the initial price of the books
	 * @param price
	 */
	public void setInitPrice(int price) {
		if (price < 0)
			throw new IllegalArgumentException("Invalid Input. Init Price cannot be negative!!");
		else
			this.initPrice = price;
	}
	
	/**
	 * Setter function to set the discount offered by the bookstore
	 * @param discount
	 */
	public void setDiscount(int discount) {
		if (discount < 0)
			throw new IllegalArgumentException("Invalid Input. Discount cannot be negative!!");
		else
			this.discount = discount;
	}
	
	/**
	 * Setter function to set the floor price of the books
	 * @param price
	 */
	public void setFloorPrice(int price) {
		if (price < 0)
			throw new IllegalArgumentException("Invalid Input. Floor Price cannot be negative!!");
		else
			this.floorPrice = price;
	}
	
	/**
	 * Function returns the number of books that can be bought with the given budget
	 * @param budget : The initial budget of the customer
	 * @return PurchaseReceipt: Receipt object with the number of books, 
	 * remaining amount attributes
	 */
	
	public PurchaseReceipt buyBooks(int budget) {
		
		PurchaseReceipt receipt = new PurchaseReceipt();
		receipt.remaining_amount = budget;
		
		/* Insufficient budget */
		if (budget < initPrice) {
			System.out.println("Not enough budget to buy books");
			return receipt;
		}
		
		/* Calculate the number of books that can be bought with the budget */
		receipt.remaining_amount -= initPrice;
		receipt.num_of_books++;
		float cur_price = initPrice - discount; 
		
		while(receipt.remaining_amount >= cur_price) {
			receipt.num_of_books++;
			receipt.remaining_amount -= cur_price;			
			if ((cur_price - discount) > floorPrice)
				cur_price -= discount;
			else
				cur_price = floorPrice;
				
		}
		
		return receipt;
		
	}

}
