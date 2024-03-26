package org.example;

import java.util.Scanner;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Warehouse warehouse = new Warehouse();

        while (true) {
            System.out.println("\nInventory Management System Menu:");
            System.out.println("1. Add Product");
            System.out.println("2. Display Stock");
            System.out.println("3. Process Order");
            System.out.println("4. Exit");
            System.out.print("Enter your choice (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String productName = scanner.nextLine();
                    System.out.print("Enter initial quantity: ");
                    int initialQuantity = scanner.nextInt();
                    warehouse.addProduct(productName, initialQuantity);
                    break;
                case 2:
                    warehouse.displayStock();
                    break;
                case 3:
                    System.out.print("Enter product name for order: ");
                    String orderProductName = scanner.nextLine();
                    System.out.print("Enter quantity for order: ");
                    int orderedQuantity = scanner.nextInt();
                    warehouse.processOrder(orderProductName, orderedQuantity);
                    break;
                case 4:
                    System.out.println("Exiting the Inventory Management System. Goodbye!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 4.");
            }
        }
    }
}