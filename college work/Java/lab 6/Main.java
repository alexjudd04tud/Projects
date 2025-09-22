import java.util.ArrayList;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Scanner;

class IdHandler {
    private List<String> ids;

    public IdHandler(String text) {
        this.ids = new ArrayList<>();
        Pattern pattern = Pattern.compile("[XBD]\\d{6}");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            ids.add(matcher.group());
        }
    }

    public List<String> convertIds(Function<String, String> converter) {
        List<String> convertedIds = new ArrayList<>();
        for (String id : ids) {
            convertedIds.add(converter.apply(id));
        }
        return convertedIds;
    }

    public List<String> filterIds(BiPredicate<String, String> filter) {
        List<String> filteredIds = new ArrayList<>();
        for (String id : ids) {
            if (filter.test(id, id.substring(0, 1))) {
                filteredIds.add(id);
            }
        }
        return filteredIds;
    }

    public List<String> filterIdsByLocation(String location) {
        BiPredicate<String, String> filter = (id, prefix) -> {
            switch (prefix) {
                case "D":
                    return location.equalsIgnoreCase("city");
                case "B":
                    return location.equalsIgnoreCase("blanchardstown");
                case "X":
                    return location.equalsIgnoreCase("tallaght");
                default:
                    return false;
            }
        };

        return filterIds(filter);
    }

    public List<String> getIds(){
        return this.ids;
    }
}

class InputReader {
    public String readInput() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder input = new StringBuilder();
        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if (line.equals("[END]")) {
                    break;
                }
                input.append(line).append("\n");
            }
        } finally {
            // Do not close scanner here. Closing System.in is dangerous.
        }
        return input.toString();
    }
}

public class Main {
    public static void main(String[] args) {
        InputReader reader = new InputReader();
        String input = reader.readInput();

        IdHandler idHandler = new IdHandler(input);

        System.out.println("Raw IDs:");
        for (String id : idHandler.getIds()) {
            System.out.println(id);
        }

        System.out.println("\nLocations and Numbers:");
        Function<String, String> converter = id -> {
            String prefix = id.substring(0, 1);
            String number = id.substring(1);
            switch (prefix) {
                case "D":
                    return "City " + number;
                case "B":
                    return "Blanchardstown " + number;
                case "X":
                    return "Tallaght " + number;
                default:
                    return "Unknown " + number;
            }
        };
        for (String convertedId : idHandler.convertIds(converter)) {
            System.out.println(convertedId);
        }

        System.out.println("\nIDs filtered by location 'city':");
        for (String filteredId : idHandler.filterIdsByLocation("city")) {
            System.out.println(filteredId);
        }
    }
}