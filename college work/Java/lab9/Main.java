import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        try {
            // Get the current working directory and construct the full path
            Path currentDir = Paths.get("").toAbsolutePath();
            Path inputFile = currentDir.resolve("lab9_products.csv");

            // Create ProductList from the input file
            ProductList productList = new ProductList(inputFile.toString());

            // Convert prices from Euro to USD and write to CSV
            try (PrintWriter writer = new PrintWriter("converted_products.csv")) {
                // Write header to CSV file
                writer.println("id,name,category,subcat,price");

                productList.getProducts().stream()
                    // Convert price from Euro to USD (1 Euro = 1.1 USD)
                    .map(p -> new Product(p.id(), p.name(), p.category(), p.subcat(), p.price() * 1.1))
                    // Convert to CSV line
                    .map(p -> String.format("%d,%s,%s,%s,%.2f", 
                        p.id(), p.name(), p.category(), p.subcat(), p.price()))
                    // Write each line to file
                    .forEach(writer::println);
            }

            // Calculate average prices by category
            Map<String, Double> avgPriceByCategory = productList.getProducts().stream()
                .collect(Collectors.groupingBy(
                    Product::category, 
                    Collectors.averagingDouble(Product::price)
                ));

            // Sort and print average prices by category
            System.out.println("Average Prices by Category:");
            avgPriceByCategory.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEach(entry -> System.out.printf("%s: €%.2f%n", entry.getKey(), entry.getValue()));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}