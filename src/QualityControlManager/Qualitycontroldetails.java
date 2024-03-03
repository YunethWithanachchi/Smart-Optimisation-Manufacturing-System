package QualityControlManager;

import java.util.Scanner;
public class Qualitycontroldetails {


    int numofModels = 3;
    double[] resourcesAllocated=new double[]{1000,2000,3000};
    double[] defectedItems;
    double[] defectRatio = new double[numofModels];
    double[] defectPercentage = new double[numofModels];
    final double standardPercentage = 5.00; //When the defect rate is more than 5%, the production is unsuccesful.

    public void getDataFromResourceAllocator() {
        System.out.println("Number of Models in Manufacturing Process : " + numofModels);
        System.out.println("\n");
        System.out.println("Number of Units Produced : ");
        for(int i = 0; i< numofModels; i++) {
            System.out.println("model["+i+"] : " + resourcesAllocated[i]);
        }
    }

    public void getUserInputForDefectedItems() {
        Scanner scanner= new Scanner(System.in);
        defectedItems = new double[numofModels];
        System.out.println("\n");
        System.out.println("Enter weekly defected items per model");
        for (int i = 0; i < numofModels; i++) {
            System.out.print("model "+(i+1)+" : ");
            defectedItems[i] = scanner.nextInt();
        }
    }

    public void calculateImpactOnTotalProduct() {
        System.out.println("\n");
        System.out.println("Impact on Total Production :");
        for (int i = 0; i < numofModels; i++){
            defectRatio[i] =defectedItems[i] / resourcesAllocated[i];
            defectPercentage[i] = defectRatio[i] * 100;
            System.out.println("model["+(i+1)+"]:"+ defectPercentage[i]);
        }
    }

    public void productionControl() {
        for(int i=0; i<numofModels;i++) {
            if (defectPercentage[i] >= standardPercentage) {
                System.out.println("Production of MODEL ["+(i+1)+"] is unsuccessful due to high defect percentage!");
            } else {
                System.out.println("Production of MODEL ["+(i+1)+"] is successful!");
            }
        }
    }


}
