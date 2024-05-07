package SAP.SAP2;



import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            int choice = Menu.getMenuChoice(scanner);
            switch (choice) {
                case 1:
                    ProductManager.addProduct(scanner);
                    break;
                case 2:
                    ProductManager.printProducts();
                    break;
                case 3:
                    FileManager.saveToFile(ProductManager.getProducts());
                    break;
                case 4:
                    ArrayList<Product> readProducts = FileManager.readFromFile();
                    if (!readProducts.isEmpty()) {
                        System.out.println("Products read from file:");
                        for (Product product : readProducts) {
                            System.out.println(product);
                        }
                    }
                    break;
                case 5:
                    System.out.println("Goodbye!");
                    System.exit(0);
                case 6:
                    System.out.print("Enter product ID to remove: ");
                    int id = scanner.nextInt();
                    ProductManager.removeProductById(id);
                    break;
                default:
                    System.out.println("Invalid option. Please choose again.");
            }
        }
    }
}
