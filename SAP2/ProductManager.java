package SAP.SAP2;



import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class ProductManager {
    private static ArrayList<Product> products = new ArrayList<>();

    public static void addProduct(Scanner scanner) {
        System.out.print("Enter product name: ");
        String name = scanner.next();
        System.out.print("Enter product price: ");
        double price = scanner.nextDouble();
        System.out.print("Is the product available? (true/false): ");
        boolean available = scanner.nextBoolean();
        System.out.print("Enter discount for the product: ");
        double discount = scanner.nextDouble();

        Product product = new Product(name, price, available, discount);
        products.add(product);
        System.out.println("Product added successfully. ID: " + product.getId());
    }

    public static void printProducts() {
        if (products.isEmpty()) {
            System.out.println("No products available.");
            return;
        }

        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static void removeProductById(int id) {
        Iterator<Product> iterator = products.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getId() == id) {
                iterator.remove();
                System.out.println("Product with ID " + id + " removed successfully.");
                return;
            }
        }
        System.out.println("Product with ID " + id + " not found.");
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }
}
