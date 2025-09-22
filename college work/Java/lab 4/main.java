// Main.java
public class Main {
    public static void main(String[] args) {
        // Create a catalogue
        String[][] foodData = {
                {"Apple", "Granny Smith", "0.50", "30"},
                {"Milk", "Whole", "3.00", "10"},
                {"Bread", "Whole Wheat", "2.00", "5"}
        };

        String[][] clothingData = {
                {"T-Shirt", "Cotton", "25.00", "40"},
                {"Jeans", "Denim", "79.99", "30"},
                {"Socks", "Wool", "10.00", "60"}
        };

        Catalogue catalogue = new Catalogue(foodData, clothingData);

        // Create a shop
        Shop shop = new Shop();

        // Add products to the shop from the catalogue
        Product apple = catalogue.getProductByName("Apple");
        Product milk = catalogue.getProductByName("Milk");
        Product tShirt = catalogue.getProductByName("T-Shirt");
        Product jeans = catalogue.getProductByName("Jeans");

        if (apple != null) {
            shop.addProduct(apple, 10);
        }
        if (milk != null) {
            shop.addProduct(milk, 5);
        }
        if (tShirt != null) {
            shop.addProduct(tShirt, 2);
        }
        if (jeans != null) {
            shop.addProduct(jeans, 3);
        }

        // Demonstrate Shop methods
        System.out.println("Products in shop:");
        for (StoredProduct sp : shop.storedProducts) {
            if (sp != null) {
                System.out.println(sp);
            }
        }

        System.out.println("\nClothing Products:");
        shop.printProducts("clothing");

        System.out.println("\nFood Products:");
        shop.printProducts("food");

        System.out.println("\nTotal Value of Products: $" + shop.currentValue());
    }
}