package ResourceAllocater;

import java.util.Scanner;

public class ResourceAllocater {
    static Scanner input = new Scanner(System.in);
    static final int numOfMachines=3;

    public ResourceAllocater() {
        userInputs();
    }

    public void userInputs() {
        System.out.print("Enter the number of models to produce: ");
        int numOfModels = input.nextInt();
        System.out.print("Enter number of Raw Materials required: ");
        int numOfRawMaterials = input.nextInt();


        double[] modelsToProduce = new double[numOfModels];
        double[] profitOfModels = new double[numOfModels];
        double[] totalMaterialsAvailable = new double[numOfModels];
        int[][] RawMaterials = new int[numOfModels][numOfRawMaterials];
        double[][] HoursPerUnit = new double[numOfModels][numOfMachines];


        for (int i = 0; i < numOfModels; i++) {
            System.out.print("Enter the number of units to be produce Model " + (i + 1) + ": ");
            modelsToProduce[i] = input.nextDouble();
        }
        System.out.print("\n");
        for (int i = 0; i < numOfModels; i++) {
            System.out.print("Enter the profit of Model " + (i + 1) + ": ");
            profitOfModels[i] = input.nextDouble();
        }
        System.out.print("\n");
        System.out.print("Enter the total materials available : \n");
        for (int i = 0; i < numOfModels; i++) {
            System.out.print("Raw Material "+(i+1)+" : ");
            totalMaterialsAvailable[i] = input.nextDouble();
        }
         for (int i = 0; i < numOfModels; i++) {
             System.out.println("\n\nEnter amount of Raw Materials required for model "+ (i+1)+"\n");
            for (int j=0; j<numOfRawMaterials;j++){
                System.out.print("Raw Material "+(j+1)+" : ");
                RawMaterials[i][j]= input.nextInt();
                System.out.println();
            }
        }
         for (int i = 0; i < numOfModels; i++) {
             System.out.println("Enter number of hours for model "+ (i+1)+"\n");
            for (int j=0; j<numOfMachines;j++){
                System.out.print("Machine "+(j+1)+" : ");
                HoursPerUnit[i][j]= input.nextDouble();
                System.out.println();
            }
        }


        ModelsToProduce mp = new ModelsToProduce(numOfModels,numOfRawMaterials,modelsToProduce,profitOfModels,totalMaterialsAvailable,RawMaterials,HoursPerUnit);
        simplexTable simplexTable = new simplexTable(mp);
    }
}
