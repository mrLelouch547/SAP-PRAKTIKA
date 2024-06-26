package SAP_Eren;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.Serializable;

public class UserManagement {
    public static final String FILENAME = "users.dat";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<User> users = new ArrayList<>();

        
        System.out.println("Въведете потребители (за край въведете празен ред):");
        while (true) {
            System.out.print("Потребителско име: ");
            String username = scanner.nextLine();

            
            if (username.equalsIgnoreCase("stop") || username.equalsIgnoreCase("quit")) {
                System.out.println("Прекратяване на въвеждането на потребители.");
                break;
            }

            
            if (!isValidUsername(username)) {
                System.out.println("Грешка: Потребителското име не може да бъде празно.");
                continue;
            }

            System.out.print("Парола: ");
            String password = scanner.nextLine();

        
            if (!isValidPassword(password)) {
                System.out.println("Грешка: Паролата трябва да бъде непразна.");
                continue;
            }

            UserRole role;
            while (true) {
                System.out.print("Роля (ADMIN/USER): ");
                String roleInput = scanner.nextLine().toUpperCase();
                if (roleInput.equals("ADMIN") || roleInput.equals("USER")) {
                    role = UserRole.valueOf(roleInput);
                    break;
                } else {
                    System.out.println("Грешка: Моля, въведете валидна роля (ADMIN/USER).");
                }
            }

            users.add(new User(username, password, role));
        }

        
        System.out.println("\nПотребители:");
        for (User user : users) {
            System.out.println(user);
        }

        
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(FILENAME))) {
            outputStream.writeObject(users);
            System.out.println("\nПотребителите са запазени успешно във файл: " + FILENAME);
        } catch (IOException e) {
            System.err.println("Грешка при запазване на потребителите: " + e.getMessage());
        }


        
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(FILENAME))) {
            List<User> savedUsers = (List<User>) inputStream.readObject();
            System.out.println("\nПотребителите, прочетени от файл:");
            for (User user : savedUsers) {
                System.out.println(user);
            }
        } catch (FileNotFoundException e) {
            System.err.println("Файлът " + FILENAME + " не е намерен. Създаване на нов файл...");
            try {
            
                File file = new File(FILENAME);
                if (file.createNewFile()) {
                    System.out.println("Създаден е нов файл: " + FILENAME);
                    
                    try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(file))) {
                        outputStream.writeObject(users);
                        System.out.println("Потребителите са запазени успешно в новия файл.");
                    } catch (IOException ex) {
                        System.err.println("Грешка при запазване на потребителите в новия файл: " + ex.getMessage());
                    }
                } else {
                    System.err.println("Неуспешно създаване на нов файл: " + FILENAME);
                }
            } catch (IOException ex) {
                System.err.println("Грешка при създаване на нов файл: " + ex.getMessage());
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Грешка при четене на потребителите от файл: " + e.getMessage());
        }
    }


    private static boolean isValidUsername(String username) {
        return !username.trim().isEmpty();
    }

    
    private static boolean isValidPassword(String password) {
        return !password.isEmpty();
    }
}
