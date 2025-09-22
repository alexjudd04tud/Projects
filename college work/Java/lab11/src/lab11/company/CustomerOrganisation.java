package lab11.company;

import lab11.company.customers.Customer;
import lab11.company.Organisation;
import lab11.company.EmailSystem;
//Q2e
public class CustomerOrganisation extends Organisation implements Customer {
    private String vatNumber;

    public CustomerOrganisation(String name, String email, String contactName, String vatNumber) {
        super(name, email, contactName);
        this.vatNumber = vatNumber;
    }
    //methods all below here
    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    @Override
    public void sendReceipt(String itemName, double price) {
        double priceExcludingVAT = price * 0.8;
        double vat = price * 0.2;
        EmailSystem.sendEmail(getEmail(), "The VAT Receipt is: " + itemName + ", Price without VAT: " + priceExcludingVAT + ", VAT: " + vat + ", VAT Number: " + vatNumber);
    }
}