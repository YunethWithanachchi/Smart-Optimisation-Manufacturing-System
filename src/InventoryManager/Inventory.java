package InventoryManager;

import java.util.Scanner;

public class Inventory {
    public Inventory() {
        options();
    }

    public void options() {
        Scanner sc = new Scanner(System.in);
        boolean flag = true;

        // To enter total storage capacity
        System.out.println("Enter total storage capacity:");
        int totalStorageCapacity = sc.nextInt();
        sc.nextLine(); // Consume newline character

        // Create an instance of InventoryManagement
        InventoryManagement inventoryManagement = new InventoryManagement(totalStorageCapacity);

        // To perform inventory actions
        while (flag) {
            System.out.println("\nChoose an action:");
            System.out.println("1. Add raw material");
            System.out.println("2. Remove raw material");
            System.out.println("3. Add finished goods");
            System.out.println("4. Remove finished goods");
            System.out.println("5. Exit");

            int choice = sc.nextInt();
            sc.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.println("Enter raw material name:");
                    String rawMaterialName = sc.nextLine();
                    System.out.println("Enter quantity:");
                    int rawMaterialQuantity = sc.nextInt();
                    inventoryManagement.addRawMaterial(rawMaterialName, rawMaterialQuantity);
                    break;
                case 2:
                    System.out.println("Enter raw material name:");
                    String rawMaterialToRemove = sc.nextLine();
                    System.out.println("Enter quantity:");
                    int quantityToRemove = sc.nextInt();
                    inventoryManagement.removeRawMaterial(rawMaterialToRemove, quantityToRemove);
                    break;
                case 3:
                    System.out.println("Enter finished goods name:");
                    String finishedGoodsName = sc.nextLine();
                    System.out.println("Enter quantity:");
                    int finishedGoodsQuantity = sc.nextInt();
                    inventoryManagement.addFinishedGoods(finishedGoodsName, finishedGoodsQuantity);
                    break;
                case 4:
                    System.out.println("Enter finished goods name:");
                    String finishedGoodsToRemove = sc.nextLine();
                    System.out.println("Enter quantity:");
                    int quantityToRemoveFinishedGoods = sc.nextInt();
                    inventoryManagement.removeFinishedGoods(finishedGoodsToRemove, quantityToRemoveFinishedGoods);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    flag = false;
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
