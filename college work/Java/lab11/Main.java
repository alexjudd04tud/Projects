public class Main {

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
