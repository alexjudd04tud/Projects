import java.util.function.Predicate;

public class Main {
    private static Predicate<String> getRegExpPredicate(String regex) {
        return word -> word.matches(regex);
    }

    public static void main(String[] args) {
        String directory = "text_files"; // Change this to your actual directory
        TextProcessor processor = new TextProcessor(directory);

        try {
            // Find files that start with "science"
            processor.findFiles(directory, "^science.*");

            // Count words starting with 'h' and 'x'
            processor.run(getRegExpPredicate("^h.*"), "Words starting with 'h'");
            processor.run(getRegExpPredicate("^x.*"), "Words starting with 'x'");

            // Save results
            processor.saveResults("results.txt");

            System.out.println("Processing complete. Results saved in results.txt.");
        } catch (IllegalArgumentException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
