public class NumberPrinter {

    //function 1
    private void printFromAtoB(int a, int b) {
        int start = Math.min(a, b);
        int end = Math.max(a, b);

        for (int i = start; i <= end; i++) {
            System.out.println(i);
        }
    }

    // function 2
    public void printYIntegersStartingFromX(int x, int y) {
        // Prints numbers from x to x + y - 1
        printFromAtoB(x, x + y - 1);
    }

    // function 3 
    public void printFromStringInput(String strA, String strB) {
        try {
            int a = Integer.parseInt(strA);
            int b = Integer.parseInt(strB);
            printFromAtoB(a, b);
        } catch (NumberFormatException e) {
            System.out.println("Error: One or both of the inputs could not be converted to an integer.");
        }
    }

    // function 4 
    public void printRandomNumbers() {
        int randomA = (int) (Math.random() * 100); 
        int randomB = (int) (Math.random() * 100); 
        printFromAtoB(randomA, randomB);
    }

    // Public function that takes two integers x and y, prints y integers starting from x
    public void printYIntegersStartingFromX(int x, int y) {
        printFromAtoB(x, x + y - 1);
    }

    public static void main(String[] args) {
        // Create an instance of NumberPrinter
        NumberPrinter printer = new NumberPrinter();

        // Test the functions
        System.out.println("Test: printYIntegersStartingFromX (x=3, y=5)");
        printer.printYIntegersStartingFromX(3, 5);  // Prints 3, 4, 5, 6, 7

        System.out.println("\nTest: printFromStringInput (strA=\"10\", strB=\"15\")");
        printer.printFromStringInput("10", "15");  // Prints 10, 11, 12, 13, 14, 15

        System.out.println("\nTest: printFromStringInput (strA=\"abc\", strB=\"5\")");
        printer.printFromStringInput("abc", "5");  // Error message

        System.out.println("\nTest: printRandomNumbers");
        printer.printRandomNumbers();  // Prints random numbers between two random integers
    }
}
