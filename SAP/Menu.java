package SAP;

import java.util.Scanner;

public class Menu {
    public static int getMenuChoice(Scanner scanner) {
        System.out.println("Меню:");
        System.out.println("1. Въвеждане на продукт");
        System.out.println("2. Принтиране на продуктите");
        System.out.println("3. Записване на продуктите във файл");
        System.out.println("4. Четене на продукти от файл");
        System.out.println("5. Изход");

        System.out.print("Изберете опция: ");
        return scanner.nextInt();
    }
}


