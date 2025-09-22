// This goes in Product.java
import java.util.Objects;

record Product(int id, String name, String category, String subcat, double price) {
    // Canonical constructor with price validation
    public Product {
        if (price < 0) {
            throw new RuntimeException(new InvalidPriceException(id));
        }
    }
}