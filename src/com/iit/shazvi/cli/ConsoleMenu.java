package com.iit.shazvi.cli;

import com.iit.shazvi.ShoppingManager;
import com.iit.shazvi.WestminsterShoppingManager;
import com.iit.shazvi.models.Clothing;
import com.iit.shazvi.models.Electronics;

import java.io.File;
import java.util.Scanner;

public class ConsoleMenu {

    public static void main(String[] args) {
        ShoppingManager shoppingManager = new WestminsterShoppingManager();
        Scanner scanner = new Scanner(System.in);
        String fileName = "Shopping.txt";
        File f = new File(fileName);
        if (f.exists() && !f.isDirectory()) {
            shoppingManager.loadFromFile(fileName);
            consoleSteps(shoppingManager, scanner);
        } else {
            consoleSteps(shoppingManager, scanner);
        }


    }

    private static void consoleSteps(ShoppingManager shoppingManager, Scanner scanner) {
        while (true) {
            System.out.println("1. Add new product");
            System.out.println("2. Delete product");
            System.out.println("3. Print product list");
            System.out.println("4. Save to file");
            System.out.println("5. Load from file");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    // Add new product
                    System.out.print("Enter product type (Electronics/Clothing): ");
                    String productType = scanner.nextLine();
                    System.out.print("Enter product ID: ");
                    String productID = scanner.nextLine();
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter available items: ");
                    int availableItems = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();
                    if (productType.equalsIgnoreCase("Electronics")) {
                    	String category= productType;
                        System.out.print("Enter brand: ");
                        String brand = scanner.nextLine();

                        System.out.print("Enter warranty period (in months): ");
                        int warrantyPeriod = scanner.nextInt();

                        shoppingManager.addProductToSystem(new Electronics(productID, productName, availableItems, price,category, brand, warrantyPeriod));
                    } else if (productType.equalsIgnoreCase("Clothing")) {
                    	String category= productType;
                        System.out.print("Enter size: ");
                        String size = scanner.nextLine();

                        System.out.print("Enter color: ");
                        String color = scanner.nextLine();

                        shoppingManager.addProductToSystem(new Clothing(productID, productName, availableItems, price, category, size, color));
                    } else {
                        System.out.println("Invalid product type.");
                    }
                }
                case 2 -> {
                    // Delete product
                    System.out.print("Enter product ID to delete: ");
                    String deleteProductID = scanner.nextLine();
                    shoppingManager.deleteProductFromSystem(deleteProductID);
                }
                case 3 ->
                    // Print product list
                        shoppingManager.printProductList();
                case 4 -> {
                    // Save to file
                    System.out.print("Enter file name to save: ");
                    String saveFileName = scanner.nextLine();
                    shoppingManager.saveToFile(saveFileName);
                }
                case 5 -> {
                    // Load from file
                    System.out.print("Enter file name to load: ");
                    String loadFileName = scanner.nextLine();
                    shoppingManager.loadFromFile(loadFileName);
                }
                case 6 -> {
                    // Exit
                    System.out.println("Exiting Westminster Shopping Manager. Goodbye!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
