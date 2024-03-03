package SupplyChainAnalysis;

import java.util.Scanner;
public class SupplyChainAnalysis {
    public SupplyChainAnalysis() {
        Options();
    }
    public void Options() {
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        int choice;

        while (flag) {
            System.out.println("1. View Product Movement");
            System.out.println("2. Minimum Transportation Cost");
            System.out.println("3. Exit");

            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Product ID: ");
                    String productID = scanner.nextLine();

                    ProductMovement productMovement = new ProductMovement(
                            101, "Factory", 100,
                            "Truck", 500.0, "Delivered", 2, 0
                    );
                    // Display the details
                    productMovement.displayDetails();
                    break;
                case 2:
                    System.out.println("\tMinimum Transportaion Cost");
                    String minTransportation = scanner.nextLine();
                    NorthWestCornerMethod.main(new String[0]);
                    break;
                case 3:
                    System.out.println("Exiting program...");
                    flag= false;

                    return; // Exit the program
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                    break;
            }
        }
    }
}