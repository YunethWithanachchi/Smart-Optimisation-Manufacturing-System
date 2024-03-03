package ResourceAllocater;

public class simplexTable {

    static ModelsToProduce mp2;
    static int numOfModels;
    static final int numOfMachines=3;
    static int numOfRawMaterial;
    static double[] modelsToProduce;
    static int[][] rawMaterials;
    double[][] hoursPerUnit;
    static double[] totalMaterialsAvailable;
    double[] profitOfModels;
    public simplexTable(ModelsToProduce mp2) {
        this.mp2 = mp2;
        numOfModels = mp2.getNumOfModels();
        numOfRawMaterial = mp2.getNumofRawMaterials();
        modelsToProduce = mp2.getModelsToProduce();
        rawMaterials = mp2.getRawMaterials();
        totalMaterialsAvailable = mp2.getTotalMaterialsAvailable();
        profitOfModels = mp2.getProfitOfModels();
        hoursPerUnit=mp2.getHoursPerUnit();

        valuesFixing();
    }

    public void valuesFixing(){

        /*modelsToProduce[0] = 2000;
        modelsToProduce[1] = 1500;
        modelsToProduce[2] = 2000;

        rawMaterials[0] = new int[]{10, 5, 3};
        rawMaterials[1] = new int[]{8, 4, 3};
        rawMaterials[2] = new int[]{7, 6, 4};

        double[][] hoursPerUnit = new double[numOfModels][numOfMachines];
        hoursPerUnit[0] = new double[]{0.6, 0.15, 0.4};
        hoursPerUnit[1] = new double[]{0.4, 0, 0.5};
        hoursPerUnit[2] = new double[]{0, 0.5, 0.01};*/

        double[] totalWorkHoursOfMachine = new double[numOfMachines];
        totalWorkHoursOfMachine[0] = 2000;
        totalWorkHoursOfMachine[1] = 1500;
        totalWorkHoursOfMachine[2] = 1000;

        //totalMaterialsAvailable = new double[]{19000, 9000, 15000};

        int numOfRow = numOfMachines + numOfRawMaterial + numOfModels + 1;
        int numOfColumn = 2*numOfModels + numOfMachines + numOfRawMaterial + 2;
        double[][] table = new double[numOfRow][numOfColumn];

        for (int row = 0; row < numOfRow -1; row++) {
            table[row + 1][1] = 0;
        }
        table[0][0] = 1.0;

        for (int row = 0; row < numOfMachines; row++) {
            for (int column = 0; column < numOfModels; column++) {
                table[row + 1][column + 1] = hoursPerUnit[column][row];
            }
        }

        for (int row = 0; row < numOfRawMaterial; row++) {
            for (int column = 0; column < numOfModels; column++) {
                table[row + numOfMachines +1][column + 1] = rawMaterials[column][row];
            }
        }

        for (int row = 0; row < numOfRawMaterial; row++) {
            table[row][0] = 0;
            for (int column = 0; column < numOfModels; column++) {
                if (column > numOfModels) {
                    table[0][column] = 0;
                } else {
                    table[0][column + 1] = (profitOfModels[column] * (-1));
                }
            }

        }
        for (int row2 = 1; row2 < numOfRow; row2++) {
            for (int column = numOfModels + 1 ; column < numOfColumn; column++) {
                if (row2  == column - numOfModels) {
                    table[row2][column] = 1;
                } else{
                    table[row2][column] = 0;
                }
            }
        }
        for (int row4 = numOfRow - numOfModels; row4 < numOfRow; row4++) {
            for (int column = 1 ; column < numOfModels +1; column++) {
                if (row4 == column + numOfRawMaterial + numOfMachines) {
                    table[row4][column] = 1;
                } else{
                    table[row4][column] = 0;
                }
            }
        }

        for (int row3 = 0; row3 < numOfRow-1; row3++) {
            if (row3 < numOfMachines) {
                table[row3+1][numOfColumn-1] = totalWorkHoursOfMachine[row3];
            } else if(row3 >= numOfMachines && row3 < numOfMachines + numOfRawMaterial) {
                table[row3+1][numOfColumn-1] = totalMaterialsAvailable[row3-numOfMachines]/4;
            }else{
                table[row3+1][numOfColumn-1] = modelsToProduce[row3-numOfMachines-numOfRawMaterial];
            }
        }

        solve(table);

    }



    public static void solve(double[][] table) {
        int m = table.length - 1;  // Number of constraints
        int n = table[0].length - 1;  // Number of variables

        while (!optimal(table)) {
            int pivotColumn = pivotColumn(table);
            int pivotRow = findPivotRow(table, pivotColumn);

            // Perform pivot operation
            pivot(table, pivotRow, pivotColumn);

        }


        // Print final solution
        System.out.println("Optimal Solution:");
        double[] forupdate = new double[numOfModels];
        int count =0;
        for (int i = 1; i <= numOfModels; i++) {
            int index = BasicVariableIndex(table, i);

            if (index != -1) {
                System.out.println("model" + i + " = " + Math.floor(table[index][n]));
                if (count<numOfModels){
                    forupdate[count]=table[index][n];
                    count++;
                }
            } else {
                double[] pritnSolution = new double[numOfModels];
                pritnSolution[i-1] = modelsToProduce[i-1] * 0.2;
                System.out.println("model" + i + " = " + pritnSolution[i-1]);
                if (count<numOfModels){
                    forupdate[count]=0;
                    count++;
                }
            }
        }

        Update(table, forupdate);

    }

    private static void Update(double [][] table,double []forupdate) {
        System.out.println("Num of Units to Produce by Model:");
        for(int i=0;i<numOfModels;i++) {
            if (forupdate[i] == 0) {
                forupdate[i] = modelsToProduce[i] * 0.2;
            }
            modelsToProduce[i] = modelsToProduce[i] - forupdate[i];
            System.out.println("Model[" + i + "] =" + Math.floor(modelsToProduce[i]));

        }
        System.out.println("Total Raw Material Available:");
        for(int i=0;i<numOfRawMaterial;i++) {
            totalMaterialsAvailable[i] -= forupdate[i]*rawMaterials[i][numOfRawMaterial-1];
            System.out.println("Raw Material[" + i + "] ="+ totalMaterialsAvailable[i]);
        }
    }


    private static boolean optimal(double[][] table) {
        for (double val : table[0]) {
            if (val < 0) {
                return false;
            }
        }
        return true;
    }

    private static int pivotColumn(double[][] table) {
        int pivotColumn = 1;
        double minVal = table[0][pivotColumn];

        for (int i = 2; i < table[0].length - 1; i++) {
            if (table[0][i] < minVal) {
                minVal = table[0][i];
                pivotColumn = i;
            }
        }
        return pivotColumn;
    }

    private static int findPivotRow(double[][] table, int pivotColumn) {
        int pivotRow = 1;
        double minRatio = Double.MAX_VALUE;

        for (int i = 1; i < table.length; i++) {
            if (table[i][pivotColumn] > 0) {
                double ratio = table[i][table[0].length - 1] / table[i][pivotColumn];
                if (ratio < minRatio) {
                    minRatio = ratio;
                    pivotRow = i;
                }
            }
        }
        return pivotRow;
    }

    private static void pivot(double[][] table, int pivotRow, int pivotColumn) {
        int m = table.length;
        int n = table[0].length;

        // Make the pivot element 1
        double pivotElement = table[pivotRow][pivotColumn];
        for (int j = 1; j < n; j++) {
            table[pivotRow][j] /= pivotElement;
        }

        // Make other elements in the pivot column 0
        for (int i = 0; i < m; i++) {
            if (i != pivotRow) {
                double ratio = table[i][pivotColumn];
                for (int j = 1; j < n; j++) {
                    table[i][j] -= ratio * table[pivotRow][j];
                }
            }
        }
    }

    private static int BasicVariableIndex(double[][] table, int column) {
        int m = table.length;
        for (int i = 1; i < m; i++) {
            if (table[i][column] == 1 && columnZero(table, column, i)) {
                return i;
            }
        }
        return -1;
    }

    private static boolean columnZero(double[][] table, int column, int excludeRow) {
        int m = table.length;
        for (int i = 1; i < m; i++) {
            if (i != excludeRow && table[i][column] != 0) {
                return false;
            }
        }
        return true;
    }

}













