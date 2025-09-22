package lab11.company;

import lab11.customers.Customer;
import lab11.customers.Customers;
import lab11.suppliers.Supplier;
import lab11.suppliers.Suppliers;
import lab11.customers.CustomerPerson;
import lab11.customers.CustomerOrganisation;
import lab11.suppliers.SupplierOrganisation;

public class Company {
    private Customers customers;
    private Suppliers suppliers;
    private final String vatNumber = "IE22233345"; // Constant VAT number

    public Company() {
        this.customers = new Customers();
        this.suppliers = new Suppliers();
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void addCustomerPerson(String name, String email) {
        customers.addCustomer(new CustomerPerson(name, email));
    }

    public void addCustomerOrganisation(String name, String email, String contactName, String vatNumber) {
        customers.addCustomer(new CustomerOrganisation(name, email, contactName, vatNumber));
    }

    public void addSupplierOrganisation(String name, String email, String contactName) {
        suppliers.addSupplier(new SupplierOrganisation(name, email, contactName));
    }

    public void sendCustomerReceipt(int customerId, String itemName, double price) {
        Customer customer = customers.getCustomer(customerId);
        if (customer != null) {
            customer.sendReceipt(itemName, price);
        } else {
            System.out.println("Customer with ID " + customerId + " not found.");
        }
    }

    public void sendSupplierOrder(int supplierId, String itemName, int quantity) {
        Supplier supplier = suppliers.getSupplier(supplierId);
        if (supplier != null) {
            supplier.sendOrder(itemName, quantity);
        } else {
            System.out.println("Supplier with ID " + supplierId + " not found.");
        }
    }

    public static void main(String[] args) {
        Company company = new Company();

        // Adding customers
        company.addCustomerPerson("Joe Bloggs", "jb@gm.com");
        company.addCustomerPerson("Jane Cloggs", "jc@hy.ie");
        company.addCustomerOrganisation("Cards", "mm@cards.com", "Minnie Moggs", "IE987654321");

        // Adding suppliers
        company.addSupplierOrganisation("WoodCo", "bb@wood.com", "Bobby Briggs");
        company.addSupplierOrganisation("Glue", "info@glue.com", "Maxie Maggs");

        // Sending receipts
        company.sendCustomerReceipt(1, "Card 100 10x15", 7);
        company.sendCustomerReceipt(2, "Card 100 10x15", 7);
        company.sendCustomerReceipt(3, "Card 1000 10x15", 50);

        // Sending orders
        company.sendSupplierOrder(4, "Wood 1x3", 10);
        company.sendSupplierOrder(5, "Glue 5l", 2);
    }
}