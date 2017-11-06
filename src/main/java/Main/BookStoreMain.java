import Store.BookStore;
import Customer.*;
import Purchase.PurchaseReceipt;

public class BookStoreMain {
	
	public static void main(String[] args) {
		if (args.length < 4) {
			System.out.println("Please pass 4 arguments: init_price, discount, "
					+ "floor_price, budget in that order");
			System.exit(1);
		}
		
		int init_price = Integer.parseInt(args[0]);
		int discount = Integer.parseInt(args[1]);
		int floor_price = Integer.parseInt(args[2]);
		int budget = Integer.parseInt(args[3]);
		
		BookStore bs = BookStore.getInstance();
		bs.setInitPrice(init_price);
		bs.setDiscount(discount);
		bs.setFloorPrice(floor_price);
		
		Customer c1 = new Customer();
		c1.setBudget(budget);
		
		PurchaseReceipt pr = c1.buyBooks(bs);
		System.out.println("Number of books bought: " + pr.num_of_books);
		System.out.printf("Remaining amount = %d$\n", pr.remaining_amount);
		
	}

}
