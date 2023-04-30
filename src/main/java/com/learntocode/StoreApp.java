package com.learntocode;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class StoreApp {
    public static void main(String[] args) {
        // Initialize variables
        ArrayList<Product> inventory = new ArrayList<Product>();
        ArrayList<Product> cart = new ArrayList<Product>();
        double totalAmount = 0.0;

        // Load inventory from CSV file
        loadInventory("inventory.csv");


        // Create scanner to read user input
        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        // Display menu and get user choice until they choose to exit
        while (choice != 3) {
            System.out.println("Welcome to the Online Store!");
            System.out.println("1. Show Products");
            System.out.println("2. Show Cart");
            System.out.println("3. Exit");
            System.out.println("Enter your choice (1-3): ");

            choice = scanner.nextInt();
            scanner.nextLine();

            // Call the appropriate method based on user choice
            switch (choice) {
                case 1:
                    displayProducts(inventory, cart, scanner);
                    break;
                case 2:
                    displayCart(cart, scanner, totalAmount);
                    break;
                case 3:
                    System.out.println("Thank you for shopping with us!");
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }
    }



    public static void loadInventory(String inventory) {
        String file = "inventory.csv";
        BufferedReader reader = null;
        String line = "";

        try {
            reader = new BufferedReader(new FileReader(file));
            while((line = reader.readLine()) != null) {

                String[] row = line.split(",");
                for(String index : row) {
                    System.out.printf("%-10s", index);
                }
                System.out.println();
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }





        public static void displayProducts(ArrayList<Product> inventory, ArrayList<Product> cart, Scanner scanner) {
        System.out.println("Available Books");
        System.out.println("-------------------");
        for (Product product : inventory) {
            if (!product.checkOut) {
                System.out.println("Id: " + product.getId() + ", name: " + product.getName() + ", price: " + product.getPrice());
            }
        }
        System.out.println("-------------------");
        System.out.println("Enter the Id of the product you want to check out or press X to exit to store home screen: ");
        int productId = scanner.nextInt();
        scanner.nextLine();

        if (productId == 0) {
            return;
        }else if ((productId < 1) || (productId > inventory.size())){
            System.out.println("Invalid product Id");
            return;
        }

        System.out.println("Enter your name: ");
        String name = scanner.nextLine();

        Product selectedProduct = inventory.get(productId - 1);

        selectedProduct.checkOut(name);
        System.out.println("Thank you, " + name + " You have successfully checked out this book!" + selectedProduct.getName() + ".");

    }


    public static void displayCart(ArrayList<Product> cart, Scanner scanner, double totalAmount) {
        // This method should display the items in the cart ArrayList, along
        // with the total cost of all items in the cart. The method should
        // prompt the user to remove items from their cart by entering the ID
        // of the product they want to remove, and the quantity they want to
        // remove. The method should update the cart ArrayList and totalAmount
        // variable accordingly.
    }

    public static void checkOut(ArrayList<Product> cart, double totalAmount) {
        // This method should calculate the total cost of all items in the cart,
        // and display a summary of the purchase to the user. The method should
        // prompt the user to confirm the purchase, and deduct the total cost
        // from their account if they confirm.
    }

    public static Product findProductById(String id, ArrayList<Product> inventory) {
        // This method should search the inventory ArrayList for a product with
        // the specified ID, and return the corresponding Product object. If
        // no product with the specified ID is found, the method should return
        // null.
        return null;
    }
}
