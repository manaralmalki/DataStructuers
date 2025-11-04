package projectDs;

import java.time.LocalDate
import java.util.Date;
import java.util.Scanner;




private static LinkedList<Customer> customers_list;

private static LinkedList<Order> orders_list;

private static LinkedList<Product> products_list;

private static LinkedList<Review> reviews_list;

private static Reviews all_Reviews;

private static Customers all_Customers;

private static Orders all_Orders;

private static Products all_products;




public class E_commerce {
	

	private static LinkedList<Customer> customers_list;

	private static LinkedList<Order> orders_list;

	private static LinkedList<Product> products_list;

	private static LinkedList<Review> reviews_list;

	
	private static Reviews all_Reviews;

	private static Customers all_Customers;

	private static Orders all_Orders;

	private static Products all_products;


}

public E_commerce() {
	
	customers_list=new LinkedList<Customer>();

	orders_list-new LinkedList<Order>();

	products_list-new LinkedList<Product>();

	reviews_list-new LinkedList<Review>();
	
	
	
	all_products= new Products (products_list);
	all_Reviews = new Reviews (reviews_list,products_list,customers_list);
	all_Customers =new Customers (customers_list);
	all_Orders=new Orders (customers_list, orders_list);
}

public static void Load_data() {
	all_products.load_products("C:\\Users\\win\\Documents\\NetBeansProjects\\212project2025\\prodcuts.csv");
	all_Customers.loadCustomers("C:\\Users\\win\\Documents\\NetBeansProjects\\212project2025\\customers.csv"); 
	all_Reviews.load_revews("C:\\Users\\win\Documents\\NetBeansProjects\\212project2025\\reviews.csv);
	all_Orders.loadOrders("C:\\Users\\win\\Documents\\NetBeans Projects\\212project2025\\Orders.csv");

}



public static void add_Customer (Customer c) { 
	if (all_Customers != null)
		all_Customers.addCustomer(c);
	
	else

		System.out.println("A Error: Customer list not initialized!");}
}

public static void add_Product (Product p) {

if (all_products != null)
	all_products.add_Product (p);

	else
		System.out.println(" Error: Product list not initialized!");
}


public static void add_Order (Order o) {

if (all_orders != nul)
	all_Orders.add_Order(o);
else System.out.println("Error: Orders list not initialized!");
	}
public static void add_Review (Review r) {
	all_Reviews.add_Review(r);
}


public static void displayAllOrders_between2dates(LocalDate d1, LocalDate d2) {
    if (orders_list.empty()) {
        System.out.println("No orders found!");
        return;
    }

    System.out.println("--------------------------------------------------");
    System.out.println("OrderID\tCustomerID\tProductIDs\tTotalPrice\tDate\tStatus");
    System.out.println("--------------------------------------------------");

    orders_list.findFirst();

    while (true) {
        Order o = orders_list.retrieve();

        // التحقق أن تاريخ الطلب بين d1 و d2
        if (o.getOrderDate().compareTo(d1) >= 0 && o.getOrderDate().compareTo(d2) <= 0) {
            o.display(); // أو يمكنك طباعة الخصائص كما تحب
        }

        if (orders_list.last()) {
            break;
        }

        orders_list.findNext();
    }

    System.out.println("--------------------------------------------------");
}


 public static void main(String[] args) {
        E_commerce store = new E_commerce();
        Scanner input = new Scanner(System.in);
        int t = 0;

        do {
            System.out.println("====================================");
            System.out.println("1: Load all files");
            System.out.println("2: Add Product");
            System.out.println("3: Add Customer");
            System.out.println("4: Add Order");
            System.out.println("5: Add Review");
            System.out.println("6: Show all Customers");
            System.out.println("7: Show Top 3 Products by Average Rating");
            System.out.println("8: Display all orders between 2 datas:");
            System.out.println("9: Exit");
            System.out.println("====================================");
            System.out.print("Enter your choice: ");
            t = input.nextInt();

            switch (t) {
                case 1:
                    store.loadAll();
                    break;

                case 2:
                    Product p = new Product(input.nextInt(), input.nextLine(), input.nextDouble(), input.nextLine());
                    store.addProduct(p);
                    break;

                case 3:
           

                    Customer c = new Customer(input.nextInt(), input.next(), input.next());
                    store.addCustomer(c);
                    break;

                case 4:

                    Order o = new Order(input.nextInt(), input.nextInt(), input.next(), input.nextDouble(), LocalDate.parse(input.next(),input.next()), input.next());
                    store.addOrder(o);
                    break;

                case 5:
        
                    Review r = new Review(input.nextInt(), input.nextInt(), input.nextInt(),input.nextInt(), input.next());
                    store.addReview(r);
                    break;

                case 6:
                    allCustomers.displayAll();
                    break;

                case 7:
                    store.displayTop3Products();
                    break;

                case 8:
                    all_Orders.displayAllOrders();
                    break;
                case 9:
                	displayAllOrders_between2dates(LocalDate.of(2025, 2, 2),LocalDate.of(2025, 2, 8));
                    break;
                case 10:
                    System.out.println("Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (t != 10);

        input.close();
    }
 
 
 






