package SAP;


import java.util.ArrayList;
import java.util.Scanner;

public class ProductManager {
    private static ArrayList<Product> products = new ArrayList<>();

    public static void addProduct(Scanner scanner) {
        System.out.print("Въведете име на продукта: ");
        String name = scanner.next();
        System.out.print("Въведете цена на продукта: ");
        double price = scanner.nextDouble();

        Product product = new Product(name, price);
        products.add(product);
        System.out.println("Продуктът е добавен успешно.");
    }

    public static void printProducts() {
        if (products.isEmpty()) {
            System.out.println("Няма налични продукти.");
            return;
        }

        for (Product product : products) {
            System.out.println(product);
        }
    }

    public static ArrayList<Product> getProducts() {
        return products;
    }
}

