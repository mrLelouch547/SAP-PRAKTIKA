package SAP;


import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private static final String FILENAME = "products.txt";

    public static void saveToFile(ArrayList<Product> products) {
        // why the print writer in is the try clause!!!
        // try-with-resource!!!
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILENAME))) {
            for (Product product : products) {
                writer.println(product.getName() + "," + product.getPrice());
            }
            System.out.println("Продуктите са записани успешно във файл.");
        } catch (IOException e) {
            System.out.println("Грешка при запис на файл: " + e.getMessage());
        }
    }

    public static ArrayList<Product> readFromFile() {
        ArrayList<Product> products = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILENAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String name = parts[0];
                double price = Double.parseDouble(parts[1]);
                products.add(new Product(name, price));
            }
            System.out.println("Продуктите са прочетени успешно от файл.");
        } catch (IOException e) {
            System.out.println("Грешка при четене от файл: " + e.getMessage());
        }
        return products;
    }
}

