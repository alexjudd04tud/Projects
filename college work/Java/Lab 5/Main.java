
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        int[] wholeNums = { 1, 2, 2, 1, 1, 3, 3, 3 };
        List<ObjectContainer<Integer>> list = new ArrayList<>();

        for (int num : wholeNums) {
            list.add(new ObjectContainer<>(num));
        }

        // Print out the list of numbers
        System.out.println("List of Numbers:");
        for (ObjectContainer<Integer> container : list) {
            System.out.print(container.get() + " ");
        }
        System.out.println();

        // Creating and printing the set
        Set<ObjectContainer<Integer>> set = new HashSet<>(list);

        System.out.println("Set of Numbers:");
        for (ObjectContainer<Integer> container : set) {
            System.out.print(container.get() + " ");
        }
        System.out.println();

        // Print the read count
        System.out.println("Read count: " + ObjectContainer.getReadCount());

        // Testing dictionary functionality
        Map<String, String> dictionary = new HashMap<>();
        String[][] entries = {
            { "apple", "A popular fruit" },
            { "applet", "A type of Java program that runs in a browser, now obsolete" },
            { "app", "An application, usually for a mobile device" },
            { "ball", "A round object used in sports" },
            { "cat", "A popular low-maintenance pet" }
        };

        for (String[] entry : entries) {
            dictionary.put(entry[0], entry[1]);
        }

        System.out.println("Dictionary entries:");
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("Lookup 'app': " + dictionary.get("app"));
        System.out.println("Lookup 'ball': " + dictionary.get("ball"));
    }
}