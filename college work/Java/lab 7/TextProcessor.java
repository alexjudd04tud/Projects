import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class TextProcessor {
    private final String directoryName;
    private final List<File> fileList = new ArrayList<>();
    private final Map<String, Integer> results = new HashMap<>();

    public TextProcessor(String directoryName) {
        this.directoryName = directoryName;
    }

    public void findFiles(String directoryName, String regex) {
        File dir = new File(directoryName);
        if (!dir.exists() || !dir.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory: " + directoryName);
        }

        Pattern pattern = Pattern.compile(regex);
        fileList.clear();
        fileList.addAll(
            Arrays.stream(Objects.requireNonNull(dir.listFiles()))
                  .filter(file -> pattern.matcher(file.getName()).matches())
                  .collect(Collectors.toList())
        );
    }

    public void run(Predicate<String> predicate, String predicateName) {
        int count = 0;
        for (File file : fileList) {
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    count += Arrays.stream(line.split("\\s+"))
                                   .filter(predicate)
                                   .count();
                }
            } catch (IOException e) {
                System.err.println("Error reading file: " + file.getName());
            }
        }
        results.put(predicateName, count);
    }

    public void saveResults(String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
            for (Map.Entry<String, Integer> entry : results.entrySet()) {
                writer.write(entry.getKey() + ": " + entry.getValue());
                writer.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + fileName);
        }
    }
}
