package projectDs;

import java.io.File;
import java.util.Scanner;
import java.util.LinkedList;

public class Customers {

    private LinkedList<Customer> customers;

    // Constructor 1: Initializes empty list
    public Customers() {
        customers = new LinkedList<>();
    }

    // Constructor 2: Initializes with existing list
    public Customers(LinkedList<Customer> input_customers) {
        customers = input_customers;
    }

    // Getter
    public LinkedList<Customer> get_customers() {
        return customers;
    }

    // Search by ID
    public Customer searchById(int id) {
        if (customers.isEmpty())
            return null;

        for (Customer c : customers) {
            if (c.getCustomerId() == id)
                return c;
        }
        return null;
    }

    // Add a new customer
    public void addCustomer(Customer c) {
        if (searchById(c.getCustomerId()) == null) {
            customers.addLast(c);
            System.out.println("✓ Added customer: " + c.getName());
        } else {
            System.out.println("X Customer with ID " + c.getCustomerId() + " already exists!");
        }
    }

    // Display all customers
    public void displayAll() {
        if (customers.isEmpty()) {
            System.out.println("No customers found!");
            return;
        }

        System.out.println("== All Customers ==");
        for (Customer c : customers) {
            c.display();
        }
    }

    // Convert line to Customer
    public static Customer convert_String_to_Customer(String line) {
        String[] a = line.split(",");
        return new Customer(
            Integer.parseInt(a[0].trim()),
            a[1].trim(),
            a[2].trim()
        );
    }

    // Load customers from file
    public void loadCustomers(String fileName) {
        try {
            File f = new File(fileName);
            Scanner read = new Scanner(f);
            System.out.println("Reading file: " + fileName);
            System.out.println("-----------------------");
            // Skip header line if exists
            if (read.hasNextLine()) read.nextLine();

            while (read.hasNextLine()) {
                String line = read.nextLine().trim();
                if (line.isEmpty()) continue;

                Customer c = convert_String_to_Customer(line);
                customers.addLast(c);
            }

            read.close();
            System.out.println("-----------------------");
            System.out.println("✓ Customers loaded successfully!\n");

        } catch (Exception e) {
            System.out.println("X Error loading customers: " + e.getMessage());
        }
    }
}
