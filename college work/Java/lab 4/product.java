class Product {
    String name;
    String description;
    Float rrp;
    int catalogueId;

    private static int nextId = 1;

    private static int generateId() {
        return nextId++;
    }

    public Product(String name, String description, String rrpString, String... args) {
        this.name = name;
        this.description = description;
        try {
            this.rrp = Float.parseFloat(rrpString);
        } catch (NumberFormatException e) {
            this.rrp = 0.0f;
        }
        this.catalogueId = generateId();
    }

    public String getName() { return name; }
    public String getDescription() { return description; }
    public Float getRrp() { return rrp; }
    public int getCatalogueId() { return catalogueId; }

    @Override
    public String toString() {
        return "Product{" + "name='" + name + '\'' + ", description='" + description + '\'' + ", rrp=" + rrp + ", catalogueId=" + catalogueId + '}';
    }
}

class FoodProduct extends Product {
    int timeToExpiry;

    public FoodProduct(String name, String description, String rrpString, String timeToExpiryString, String... args) {
        super(name, description, rrpString, args);
        try {
            this.timeToExpiry = Integer.parseInt(timeToExpiryString);
        } catch (NumberFormatException e) {
            this.timeToExpiry = 0;
        }
    }

    public int getTimeToExpiry() { return timeToExpiry; }

    @Override
    public String toString() {
        return "FoodProduct{" + "name='" + getName() + '\'' + ", description='" + getDescription() + '\'' + ", rrp=" + getRrp() + ", catalogueId=" + getCatalogueId() + ", timeToExpiry=" + timeToExpiry + '}';
    }
}

public class ClothingProduct extends Product {
    int washTemperature;

    public ClothingProduct(String name, String description, String rrpString, String washTemperatureString, String... args) {
        super(name, description, rrpString, args);
        try {
            this.washTemperature = Integer.parseInt(washTemperatureString);
        } catch (NumberFormatException e) {
            this.washTemperature = 0;
        }
    }

    public int getWashTemperature() { return washTemperature; }

    @Override
    public String toString() {
        return "ClothingProduct{" + "name='" + getName() + '\'' + ", description='" + getDescription() + '\'' + ", rrp=" + getRrp() + ", catalogueId=" + getCatalogueId() + ", washTemperature=" + washTemperature + '}';
    }
}

public class Main {
    public static void main(String[] args) {
        Product p = new Product("Shirt", "Blue Shirt", "29.99");
        FoodProduct fp = new FoodProduct("Milk", "Fresh Milk", "3.50", "7");
        ClothingProduct cp = new ClothingProduct("Jeans", "Denim Jeans", "79.99", "30");

        System.out.println(p);
        System.out.println(fp);
        System.out.println(cp);
    }
}