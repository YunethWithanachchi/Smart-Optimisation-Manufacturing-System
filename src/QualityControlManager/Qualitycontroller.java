package QualityControlManager;

public class Qualitycontroller {
    public static void main(int args) {
        Qualitycontroldetails Q1 = new Qualitycontroldetails();
        Q1.getDataFromResourceAllocator();
        Q1.getUserInputForDefectedItems();
        Q1.calculateImpactOnTotalProduct();
        Q1.productionControl();

    }
}
