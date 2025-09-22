package lab11.company;

import java.util.ArrayList;
import java.util.List;

public class Customers {
    private List<Customer> customerList;

    public Customers() {
        this.customerList = new ArrayList<>();
    }

    public void addCustomer(Customer customer) {
        customerList.add(customer);
    }

    public Customer getCustomer(int id) {
        for (Customer customer : customerList) {
            if (((InvolvedParty) customer).getId() == id) {
                return customer;
            }
        }
        return null;
    }
}