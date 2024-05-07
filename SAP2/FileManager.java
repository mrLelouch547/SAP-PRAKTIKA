package SAP.SAP2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;

public class FileManager {
    private static final String FILENAME = "products.json";

    public static void saveToFile(ArrayList<Product> products) {
        try (Writer writer = new FileWriter(FILENAME)) {
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            gson.toJson(products, writer);
            System.out.println("Products saved to " + FILENAME + " successfully.");
        } catch (IOException e) {
            System.out.println("Error saving products: " + e.getMessage());
        }
    }

    public static ArrayList<Product> readFromFile() {
        ArrayList<Product> products = new ArrayList<>();
        try (Reader reader = new FileReader(FILENAME)) {
            Gson gson = new Gson();
            Product[] productsArray = gson.fromJson(reader, Product[].class);
            for (Product product : productsArray) {
                products.add(product);
            }
            System.out.println("Products loaded from " + FILENAME + " successfully.");
        } catch (IOException e) {
            System.out.println("Error reading products: " + e.getMessage());
        }
        return products;
    }
}
