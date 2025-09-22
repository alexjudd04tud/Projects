// This goes in ProductList.java
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class ProductList {
    private List<Product> products;

    public ProductList(String filename) {
        try (Stream<String> lines = Files.lines(Paths.get(filename))) {
            products = lines
                // Skip header row
                .skip(1)
                // Map lines to Product objects
                .map(line -> {
                    try {
                        String[] fields = line.split(",");
                        int id;
                        try {
                            id = Integer.parseInt(fields[0]);
                        } catch (NumberFormatException e) {
                            // If ID is invalid, assign -1
                            id = -1;
                        }
                        
                        double price;
                        try {
                            price = Double.parseDouble(fields[4]);
                        } catch (NumberFormatException e) {
                            // Report price error and return null
                            System.err.println("Invalid price for product: " + fields[1]);
                            return null;
                        }
                        
                        return new Product(
                            id, 
                            fields[1], 
                            fields[2], 
                            fields[3], 
                            price
                        );
                    } catch (Exception e) {
                        System.err.println("Error processing product: " + e.getMessage());
                        return null;
                    }
                })
                // Remove null products
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            products = new ArrayList<>();
        }
    }

    // Return a copy of the products list
    public List<Product> getProducts() {
        return new ArrayList<>(products);
    }
}