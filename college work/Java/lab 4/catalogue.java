// Catalogue.java
class Catalogue {
    FoodProduct[] foodProducts;
    ClothingProduct[] clothingProducts;

    public Catalogue(String[][] foodData, String[][] clothingData) {
        foodProducts = new FoodProduct[foodData.length];
        clothingProducts = new ClothingProduct[clothingData.length];

        for (int i = 0; i < foodData.length; i++) {
            foodProducts[i] = new FoodProduct(foodData[i][0], foodData[i][1], foodData[i][2], foodData[i][3]);
        }

        for (int i = 0; i < clothingData.length; i++) {
            clothingProducts[i] = new ClothingProduct(clothingData[i][0], clothingData[i][1], clothingData[i][2], clothingData[i][3]);
        }
    }

    public Product getProductByName(String name) {
        for (FoodProduct foodProduct : foodProducts) {
            if (foodProduct.getName().equals(name)) {
                return foodProduct;
            }
        }
        for (ClothingProduct clothingProduct : clothingProducts) {
            if (clothingProduct.getName().equals(name)) {
                return clothingProduct;
            }
        }
        return null; // Return null if no product with the given name is found
    }


    public static void main(String[] args) {
        String[][] foodData = {
                {"Apple", "Granny Smith", "0.50", "30"},
                {"Milk", "Whole", "3.00", "10"},
                {"Bread", "Whole Wheat", "2.00", "5"}
        };

        String[][] clothingData = {
                {"T-Shirt", "Cotton", "25.00", "40"},
                {"Jeans", "Denim", "79.99", "30"},
                {"Socks", "Wool", "10.00", "60"}
        };

        Catalogue catalogue = new Catalogue(foodData, clothingData);

        Product apple = catalogue.getProductByName("Apple");
        Product jeans = catalogue.getProductByName("Jeans");
        Product shoes = catalogue.getProductByName("Shoes"); // Not found

        System.out.println(apple); // Output the Product object (toString() will be called)
        System.out.println(jeans); // Output the Product object
        System.out.println(shoes); // Output null

    }
}