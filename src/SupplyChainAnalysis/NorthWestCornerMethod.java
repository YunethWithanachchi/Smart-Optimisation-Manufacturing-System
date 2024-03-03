package SupplyChainAnalysis;

import java.util.Scanner;

public class NorthWestCornerMethod {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input the number of sources (suppliers)
        System.out.print("Enter the number of suppliers: ");
        int numSuppliers = scanner.nextInt();


        // Input the number of destinations (demand points)
        System.out.print("Enter the number of demand points: ");
        int numDemandPoints = scanner.nextInt();


        // Initialize the supply and demand arrays
        int[] supply = new int[numSuppliers];
        int[] demand = new int[numDemandPoints];

        // Input supply values
        System.out.println("Enter the supply values for each supplier:");
        for (int i = 0; i < numSuppliers; i++) {
            System.out.print("Supply from Supplier " + (i + 1) + ": ");
            supply[i] = scanner.nextInt();
        }

        // Input demand values
        System.out.println("Enter the demand values for each demand point:");
        for (int i = 0; i < numDemandPoints; i++) {
            System.out.print("Demand at Demand Point " + (i + 1) + ": ");
            demand[i] = scanner.nextInt();
        }

        // Initialize the cost matrix
        int[][] costMatrix = new int[numSuppliers][numDemandPoints];

        // Input the cost matrix
        System.out.println("Enter the transportation costs :");
        for (int i = 0; i < numSuppliers; i++) {
            for (int j = 0; j < numDemandPoints; j++) {
                System.out.print("Cost from Supplier " + (i + 1) + " to Demand Point " + (j + 1) + ": ");
                costMatrix[i][j] = scanner.nextInt();
            }
        }

        // Apply Northwest Corner Method
        int[][] allocation = new int[numSuppliers][numDemandPoints];
        int supplierIndex = 0;
        int demandIndex = 0;

        while (supplierIndex < numSuppliers && demandIndex < numDemandPoints) {
            int minSupplyDemand = Math.min(supply[supplierIndex], demand[demandIndex]);
            allocation[supplierIndex][demandIndex] = minSupplyDemand;
            supply[supplierIndex] -= minSupplyDemand;
            demand[demandIndex] -= minSupplyDemand;

            if (supply[supplierIndex] == 0) {
                supplierIndex++;
            }
            if (demand[demandIndex] == 0) {
                demandIndex++;
            }
        }

        // Output the allocation matrix
        int totalCost = 0;
        System.out.println("\nAllocation :\n");
        for (int i = 0; i < numSuppliers; i++) {
            for (int j = 0; j < numDemandPoints; j++) {
                if(allocation[i][j] != 0){
                    System.out.println("\nSupply Point : Point no "+i+"\nDemand Point : Point no "+j+"\nUnits Allocated = "+allocation[i][j]);// Print the allocation value
                totalCost += allocation[i][j] * costMatrix[i][j];//Calculate and add the cost
            }
                }
            System.out.println();
        }
        System.out.println("\nTotal Transportation Cost: $" + totalCost);
        System.out.println("\n\n");

    }
}