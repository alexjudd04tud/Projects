// This goes in InvalidPriceException.java
class InvalidPriceException extends Exception {
    public InvalidPriceException(int id) {
        super("Invalid price for product with ID: " + id);
    }
}