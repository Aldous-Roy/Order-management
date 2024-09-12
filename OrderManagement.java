package com.aldousroy;

import java.util.Scanner;

class Item {
    int itemID;
    String itemName;
    double price;
    int availableQuantity;

    public Item(int itemID, String itemName, double price, int availableQuantity) {
        this.itemID = itemID;
        this.itemName = itemName;
        this.price = price;
        this.availableQuantity = availableQuantity;
    }
}

public class OrderManagement {
    private static Item[] items = new Item[4];
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initializeData();

        while (true) {
            System.out.println("1. Place an Order");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                placeOrder();
            } else if (choice == 0) {
                break;
            }
        }
    }

    private static void initializeData() {
        items[0] = new Item(1, "Dove Conditioner", 25.0, 10);
        items[1] = new Item(2, "Pantene Conditioner", 30.0, 10);
        items[2] = new Item(3, "Lux Soap", 15.0, 10);
        items[3] = new Item(4, "Dove Soap", 30.0, 5);
    }

    private static void placeOrder() {
        double totalAmount = 0;
        while (true) {
            System.out.println("Available items:");
            for (Item item : items) {
                System.out.println(item.itemID + ": " + item.itemName + " - " + item.price + " (" + item.availableQuantity + " in stock)");
            }
            System.out.println("Enter item ID to add to cart or 0 to finish:");
            int itemID = scanner.nextInt();
            scanner.nextLine();
            if (itemID == 0) break;

            for (Item item : items) {
                if (item.itemID == itemID) {
                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();
                    if (quantity <= item.availableQuantity) {
                        totalAmount += item.price * quantity;
                        item.availableQuantity -= quantity;
                    } else {
                        System.out.println("Insufficient stock.");
                    }
                    break;
                }
            }
        }
        System.out.println("Order placed successfully! Total amount: " + totalAmount);
    }
}
