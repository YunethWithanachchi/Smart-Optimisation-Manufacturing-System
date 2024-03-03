import InventoryManager.Inventory;
import MachineryMaintenance.MachineInterface;
import QualityControlManager.Qualitycontroller;
import ResourceAllocater.ResourceAllocater;
import SupplyChainAnalysis.SupplyChainAnalysis;
import SupplyChainManager.SupplyChainManager;

import java.io.IOException;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Start {
    static ResourceAllocater resourceAllocater;
    static MachineInterface machineInterface;
    static SupplyChainManager supplyChainManager;
    static Inventory inventory;
    static SupplyChainAnalysis supplyChainAnalysis;
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("\t\t\t\t\t\t\t\t\t^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^\n\t\t\t\t\t\t\t\t\t<<<<<<\t\tSMART OPTIMISATION MANUFACTURING SYSTEM\t\t>>>>>>\n\t\t\t\t\t\t\t\t\t^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^");
            System.out.println("\n\n");
            System.out.println("\t\t\t\t\tA) Machinery Maintenance\t\t\t\t\t\t\t\t\t\tB) Resource Allocator\n\t\t\t\t\t" +
                    "C) Quality Control Manager\t\t\t\t\t\t\t\t\t\tD) Supply Chain Management\n\t\t\t\t\t" +
                    "E) Inventory Management\t\t\t\t\t\t\t\t\t\t\tF) Supply Chain Analysis\n\n\n\n");
            System.out.println("Any Other Input will terminate the software \n");
            System.out.print("Your Choice ?   :    ");
            char choice = input.next().charAt(0);
            switch (choice) {
                case 'A': machineInterface = new MachineInterface();
                    break;
                case 'B': resourceAllocater = new ResourceAllocater();
                    break;
                case 'C':
                    Qualitycontroller.main(0);
                    break;
                case 'D': supplyChainManager = new SupplyChainManager();
                    break;
                case 'E': inventory = new Inventory();
                    break;
                case 'F': supplyChainAnalysis = new SupplyChainAnalysis();
                    break;
                default: System.exit(0);
            }
        }

    }
}
