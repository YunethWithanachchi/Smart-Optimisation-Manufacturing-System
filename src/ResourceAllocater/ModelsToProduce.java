package ResourceAllocater;

import java.util.Arrays;

public class ModelsToProduce {
    private int numOfModels;
    private int numofRawMaterials;
    private double[] modelsToProduce ;
    private double[] profitOfModels;
    private double[] totalMaterialsAvailable ;
    private int[][] RawMaterials ;
    private double[][] HoursPerUnit ;

    public ModelsToProduce(int numOfModels, int numofRawMaterials, double[] modelsToProduce, double[] profitOfModels, double[] totalMaterialsAvailable, int[][] rawMaterials, double[][] hoursPerUnit) {
        this.numOfModels = numOfModels;
        this.numofRawMaterials = numofRawMaterials;
        this.modelsToProduce = modelsToProduce;
        this.profitOfModels = profitOfModels;
        this.totalMaterialsAvailable = totalMaterialsAvailable;
        RawMaterials = rawMaterials;
        HoursPerUnit = hoursPerUnit;
    }

    public int getNumOfModels() {
        return numOfModels;
    }

    public void setNumOfModels(int numOfModels) {
        this.numOfModels = numOfModels;
    }
    public int getNumofRawMaterials() {
        return numofRawMaterials;
    }

    public void setNumofRawMaterials(int numofRawMaterials) {
        this.numofRawMaterials = numofRawMaterials;
    }

    public double[] getModelsToProduce() {
        return modelsToProduce;
    }

    public void setModelsToProduce(double[] modelsToProduce) {
        this.modelsToProduce = modelsToProduce;
    }

    public double[] getProfitOfModels() {
        return profitOfModels;
    }

    public void setProfitOfModels(double[] profitOfModels) {
        this.profitOfModels = profitOfModels;
    }

    public double[] getTotalMaterialsAvailable() {
        return totalMaterialsAvailable;
    }

    public void setTotalMaterialsAvailable(double[] totalMaterialsAvailable) {
        this.totalMaterialsAvailable = totalMaterialsAvailable;
    }

    public int[][] getRawMaterials() {
        return RawMaterials;
    }

    public void setRawMaterials(int[][] rawMaterials) {
        RawMaterials = rawMaterials;
    }

    public double[][] getHoursPerUnit() {
        return HoursPerUnit;
    }

    public void setHoursPerUnit(double[][] hoursPerUnit) {
        HoursPerUnit = hoursPerUnit;
    }

    @Override
    public String toString() {
        return "ModelsToProduce{" +
                "numOfModels=" + numOfModels +
                ", numofRawMaterials=" + numofRawMaterials +
                ", modelsToProduce=" + Arrays.toString(modelsToProduce) +
                ", profitOfModels=" + Arrays.toString(profitOfModels) +
                ", totalMaterialsAvailable=" + Arrays.toString(totalMaterialsAvailable) +
                ", RawMaterials=" + Arrays.toString(RawMaterials) +
                ", HoursPerUnit=" + Arrays.toString(HoursPerUnit) +
                '}';
    }
}