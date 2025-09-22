package lab11.company;

import lab11.customers.Customer;

public class CustomerPerson extends Person implements Customer {
    public CustomerPerson(String name, String email) {
        super(name, email);
    }

    @Override
    public void sendReceipt(String itemName, double price) {
        EmailSystem.sendEmail(getEmail(), "Receipt: " + itemName + ", Price: " + price);
    }
}