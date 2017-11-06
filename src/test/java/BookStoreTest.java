
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import Customer.Customer;
import Purchase.PurchaseReceipt;
import Store.BookStore;

public class BookStoreTest {
	
	private static BookStore bs;
	
	@Before
	public void setup() {
		bs = BookStore.getInstance();
		assertNotNull(bs);
		
		bs.setInitPrice(50);
		bs.setDiscount(4);
		bs.setFloorPrice(25);
	}
	
	/* Test to check there is only a single instance of BookStore */
	@Test
	public void test_BookStore_create_another_instance() {
		BookStore bs1 = BookStore.getInstance();
		assertEquals("Both instance objects should be same.", bs, bs1);
	}
	
	/* Test IllegalArgumentException thrown if initPrice < 0 */
	@Test(expected = IllegalArgumentException.class)
	public void test_BookStore_setInitPrice_error() {
		bs.setInitPrice(-100);
	}
	
	/* Test IllegalArgumentException thrown if discount < 0 */
	@Test(expected = IllegalArgumentException.class)
	public void test_BookStore_setDiscount_error() {
		bs.setDiscount(-5);
	}
	
	/* Test IllegalArgumentException thrown if floorPrice < 0 */
	@Test(expected = IllegalArgumentException.class)
	public void test_BookStore_setFloorPrice_error() {
		bs.setFloorPrice(-25);
	}
	
	/* Test init price set to proper value */
	@Test
	public void test_BookStore_getInitPrice() {
		assertEquals("Init Price should be equal to the value set before", 50, bs.getInitPrice());
	}
	
	/* Test discount set to proper value */
	@Test
	public void test_BookStore_getDiscount() {
		assertEquals("Discount should be equal to the value set before", 4, bs.getDiscount());
	}
	
	/* Test floor price set to proper value */
	@Test
	public void test_BookStore_getFloorPrice() {
		assertEquals("Discount should be equal to the value set before", 25, bs.getFloorPrice());
	}
	
	/* Test IllegalArgumentException thrown when budget < 0*/
	@Test(expected = IllegalArgumentException.class)
	public void test_BookStore_Customer_error() {
		Customer c1 = new Customer();
		c1.setBudget(-300);
	}
	
	/* Test setBudget success */
	@Test
	public void test_Customer() {
		Customer c1 = new Customer();
		c1.setBudget(300);
		assertEquals("Budget should be 300", 300, c1.getBudget());
	}
	
	/* Test BookStore:buyBooks() */
	@Test
	public void test_BookStore_buyBooks() {
		Customer c1 = new Customer();
		
		/* Test should return correct number of books and remaining amount */
		c1.setBudget(300);
		PurchaseReceipt r1 = c1.buyBooks(bs);
	    assertEquals("Num of books bought should be: 8", 8, r1.num_of_books);
	    assertEquals("Remaining amount should be: 9", 9, r1.remaining_amount);
	    
	    
	    /* Test should return 0 books when budget < init_price */
	    c1.setBudget(40);
	    PurchaseReceipt r2 = c1.buyBooks(bs);
	    assertEquals("Num of books bought should be: 0", 0, r2.num_of_books);
	    assertEquals("Remaining amount should be: 40", 40, r2.remaining_amount);

	    /* Can buy only one book with given budget */
	    c1.setBudget(60);
	    PurchaseReceipt r5 = c1.buyBooks(bs);
	    assertEquals("Num of books bought should be: 1", 1, r5.num_of_books);
	    assertEquals("Remaining amount should be: 0", 10, r5.remaining_amount); 
	}

}
