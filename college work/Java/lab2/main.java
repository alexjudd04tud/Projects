public class Main {

    public static void main(String[] args) {
        NumberPrinter printer = new NumberPrinter();

        System.out.println("Calling function printYIntegersStartingFromX with arguments 3 and 5. Expected output: 3 4 5 6 7");
        printer.printYIntegersStartingFromX(3, 5);

        System.out.println("\nCalling function printYIntegersStartingFromX with arguments 10 and 3. Expected output: 10 11 12");
        printer.printYIntegersStartingFromX(10, 3);

        System.out.println("\nCalling function printFromStringInput with arguments '10' and '15'. Expected output: 10 11 12 13 14 15");
        printer.printFromStringInput("10", "15");

        System.out.println("\nCalling function printFromStringInput with arguments 'abc' and '5'. Expected output: Error message");
        printer.printFromStringInput("abc", "5");

        System.out.println("\nCalling function printRandomNumbers. Expected output: Random numbers between two random values.");
        printer.printRandomNumbers();
    }
}

class NumberPrinter {

    private void printFromAtoB(int a, int b) {
        int start = Math.min(a, b);
        int end = Math.max(a, b);

        for (int i = start; i <= end; i++) {
            System.out.println(i);
        }
    }

    public void printYIntegersStartingFromX(int x, int y) {
        printFromAtoB(x, x + y - 1);
    }

    public void printFromStringInput(String strA, String strB) {
        try {
            int a = Integer.parseInt(strA);
            int b = Integer.parseInt(strB);
            printFromAtoB(a, b);
        } catch (NumberFormatException e) {
            System.out.println("Error: One or both of the inputs could not be converted to an integer.");
        }
    }

    public void printRandomNumbers() {
        int randomA = (int) (Math.random() * 100);
        int randomB = (int) (Math.random() * 100);
        printFromAtoB(randomA, randomB);
    }
}
