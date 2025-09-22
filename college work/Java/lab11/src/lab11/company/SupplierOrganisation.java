package lab11.company;
//Q2d
public class SupplierOrganisation extends Organisation implements Supplier {
    public SupplierOrganisation(String name, String email, String contactName) {
        super(name, email, contactName);
    }

    @Override
    public void sendOrder(String itemName, int quantity) {
        EmailSystem.sendEmail(getEmail(), "Order: " + itemName + ", Quantity: " + quantity + ", Contact: " + getContactName());
    }
}