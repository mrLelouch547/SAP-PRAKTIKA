package SAP.SAP2;


import java.util.Scanner;

public class Menu {
    public static int getMenuChoice(Scanner scanner) {
        System.out.println("Menu:");
        System.out.println("1. Add a product");
        System.out.println("2. Print products");
        System.out.println("3. Save products to file");
        System.out.println("4. Read products from file");
        System.out.println("5. Exit");
        System.out.println("6. Remove a product by ID");

        System.out.print("Choose an option: ");
        return scanner.nextInt();
    }
}
