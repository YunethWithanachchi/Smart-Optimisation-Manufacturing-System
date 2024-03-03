package MachineryMaintenance;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class MachineInterface {
    Scanner input = new Scanner(System.in);
    boolean flag = true;
    ArrayList<Machine> machines = new ArrayList<>();

    public MachineInterface() {
        while (flag) {
            display();
        }
    }

    private void display() {
        System.out.println("\t\t\t\t\tMachines");
        System.out.println("A :  Add Machine\t\t\t\t B :  View Machines");
        System.out.println("\nAny other Response will terminate to main menu.... Your response ?");
        char response = input.next().charAt(0);

        switch (response){
            case 'A' :  AddMachine(); break;
            case 'B' : ViewMachines();break;
            default: flag=false;
        }
    }

    private void ViewMachines() {
        try{
             System.out.println("Serial No\t\tBrand\t\tManf. Date\t\t Prev. Service Date\t\t Next Service Date");
            for (Machine machine :machines){
                System.out.println(machine);
            }
            System.out.println("Update Servie Date of any Machine(Y/N)");
            char updateResponse= input.next().charAt(0);
            if (updateResponse=='Y'|| updateResponse=='y'){
                UpdateServiceDate();
            }
        }catch (IndexOutOfBoundsException e){
            System.out.println("The ArrayList is empty or has an issue");
        }

    }

    private void UpdateServiceDate() {
        boolean found = false;
        System.out.println("Enter Serial Number of the machine you wish to update ");
        String seraialToLook = input.next();

        for (Machine machine : machines){
            if (Objects.equals(machine.getSerialNo(), seraialToLook)){
                System.out.println("Serial No : "+ machine.getSerialNo());
                System.out.println("Brand : "+ machine.getBrand());
                System.out.println("Manufactured Date : "+ machine.getManufactureDate());
                System.out.println("Previous Service Date : "+ machine.getPrevServiceDate());
                System.out.println("Next Service Date : "+ machine.getNextServiceDate());

                System.out.print("\n\n Enter Serviced Date\t");
                String servicedDate = input.next();
                System.out.print("\n\n Enter Next Serviced Date\t");
                String NextservicedDate = input.next();

                machine.setPrevServiceDate(servicedDate);
                machine.setNextServiceDate(NextservicedDate);

                System.out.println("Successfully Updated!");
                found= true;
                break;

            }
        }
        if (!found){
            System.out.println("Machine Not found for given Serial Number");
        }
    }

    private void AddMachine() {
        System.out.print("Input Brand\t:");
        String brand = input.next();
        System.out.print("Add Serial Number\t:");
        String serialNo = input.next();
        System.out.print("Add Manufactured Date\t:");
        String mDate =input.next();
        System.out.print("Add Previous Service Date\t:");
        String prevDate =input.next();
        System.out.print("Add Next Service Date\t:");
        String nextDate =input.next();

        machines.add(new Machine(prevDate,nextDate,brand,mDate,serialNo));
    }
}
