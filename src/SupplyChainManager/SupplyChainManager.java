package SupplyChainManager;

import java.io.*;
import java.util.Scanner;
public class SupplyChainManager {
	public SupplyChainManager() throws IOException {
		view();
	}
	public void view() throws IOException {
			Scanner scanner = new Scanner(System.in);
			boolean flag =true;

			while (flag) {
				System.out.println("1. Search Supplier");
				System.out.println("2. Add Supplier");
				System.out.println("3. Remove Supplier");
				System.out.println("4. Add Product to Supplier");
				System.out.println("5. Remove Product from Supplier");
				System.out.println("6. Display Suppliers");
				System.out.println("7. Exit");

				System.out.print("Enter your choice: ");
				int choice = scanner.nextInt();
				scanner.nextLine();  // consume newline

				switch (choice) {
					case 1:
						System.out.print("Enter supplier name: ");
						String supplierName = scanner.nextLine();
						searchSupplier(supplierName);
						break;
					case 2:
						System.out.print("Enter supplier name to add: ");
						String supplier = scanner.nextLine();
						addSupplier(supplier);
						break;
					case 3:
						System.out.print("Enter supplier name to remove: ");
						String supplierToRemove = scanner.nextLine();
						removeSupplier(supplierToRemove);
						break;
					case 4:
						System.out.print("Enter supplier name to add product: ");
						String supplierToAddProduct = scanner.nextLine();
						System.out.print("Enter product name: ");
						String productName = scanner.nextLine();
						System.out.print("Enter product price: ");
						double productPrice = scanner.nextDouble();
						System.out.print("Enter product quantity: ");
						int productQuantity = scanner.nextInt();
						addProductToSupplier(supplierToAddProduct, new Product(productName,productPrice, productQuantity));
						break;
					case 5:
						System.out.print("Enter supplier name to remove product: ");
						String supplierToRemoveProduct = scanner.nextLine();
						System.out.print("Enter product name to remove: ");
						String productToRemove = scanner.nextLine();
						// Here you might need to fetch product details based on the name
						removeProductFromSupplier(supplierToRemoveProduct, new Product(productToRemove, 0, 0));
						break;
					case 6:
						displaySuppliers();
						try {
							File myObj = new File("src/suppliers.txt");
							Scanner myReader = new Scanner(myObj);
							while (myReader.hasNextLine()) {
								String data = myReader.nextLine();
								System.out.println(data);
							}
							myReader.close();
						} catch (FileNotFoundException e) {
							System.out.println("An error occurred.");
							e.printStackTrace();
						}
						break;

					case 7:
						System.out.println("Exiting...");
						flag =false;
						break;
					default:
						System.out.println("Invalid choice. Please enter a number between 1 and 8.");
				}
			}
		}

   
    public void addSupplier(String name) {
    	try {
			FileWriter fw = new FileWriter("src/suppliers.txt", true);
			BufferedWriter bw = new BufferedWriter(fw);
			PrintWriter pw = new PrintWriter(bw);
			
			pw.println(name);
			pw.flush();
			System.out.println("Supplier Added Successfully!\n");
			
			pw.close();
			bw.close();
			fw.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    }

    public void removeSupplier(String name) throws IOException {
		
			File originalFile = new File("src/suppliers.txt");
			File tempFile = new File("src/tempFile.txt");
			BufferedReader br = new BufferedReader(new FileReader(originalFile));
			PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
			String line = null;
			boolean flag = false;
			
			while((line = br.readLine()) != null) {
				if(line.equalsIgnoreCase(name)) {
					flag = true;
					continue;
				}
				
				pw.println(line);
				pw.flush();				
				
			}
			if(flag)
				System.out.println("Supplier Removed Successfully!\n");
			else
				System.out.println("Wrong Name!		Try Again,\n");

			pw.close();
			br.close();
		
		// Delete the original file
        if (!originalFile.delete()) {
            System.out.println("Could not delete file");
            return;
        }

        // Rename the new file to the filename the original file had.
        if (!tempFile.renameTo(originalFile))
            System.out.println("Could not rename file");
    }

    public void addProductToSupplier(String supplierName, Product product) throws IOException {
    	FileWriter fw = new FileWriter("src/product.txt", true);
    	BufferedWriter bw = new BufferedWriter(fw);
    	PrintWriter pw = new PrintWriter(bw);
    	FileReader fr = new FileReader("src/suppliers.txt");
		BufferedReader br = new BufferedReader(fr);
		String name;
		boolean flag = false;
		
		while((name = br.readLine()) != null) {
			if(name.equalsIgnoreCase(supplierName)) {
				flag = true;
				continue;
			}
		}
    	
		if(flag) {
	    	String line = supplierName + "|" + product.getName() + "|" + Double.toString(product.getPrice()) + "|" + Integer.toString(product.getQuantity());
	    	
	    	pw.println(line);
			pw.flush();
			System.out.println("Product Added Successfully!\n");
			
			pw.close();
			bw.close();
			fw.close();
		} else {
			System.out.println("Supplier not found!");
		}
    }

	public void removeProductFromSupplier(String supplierToRemoveProduct, Product product) throws IOException {
		File originalFile = new File("src/product.txt");
		File tempFile = new File("src/tempFile.txt");
		BufferedReader br = new BufferedReader(new FileReader(originalFile));
		PrintWriter pw = new PrintWriter(new FileWriter(tempFile));
		String line = null;
		boolean flag = false;
		
		while((line = br.readLine()) != null) {
			
			String supName = line.substring(0, line.indexOf("|"));
			String rest = line.substring(line.indexOf("|")+1, line.lastIndexOf("|"));
			String proName = rest.substring(0, rest.indexOf("|"));
			
			if(supName.equalsIgnoreCase(supplierToRemoveProduct) && proName.equalsIgnoreCase(product.getName())) {
				flag = true;
				continue;
			}
			
			pw.println(line);
			pw.flush();				
			
		}
		if(flag)
			System.out.println("Product Removed Successfully!\n");
		else
			System.out.println("Wrong Supplier or Product Name!		Try Again,\n");

		pw.close();
		br.close();
	
		// Delete the original file
	    if (!originalFile.delete()) {
	        System.out.println("Could not delete file");
	        return;
	    }
	
	    // Rename the new file to the filename the original file had.
	    if (!tempFile.renameTo(originalFile))
	        System.out.println("Could not rename file");
		
	}

    public void displaySuppliers() throws IOException {
    	BufferedReader suppliers = new BufferedReader(new FileReader("src/suppliers.txt"));
    	String supLine;
    	String proLine;
    	
    	while((supLine = suppliers.readLine()) != null) {
			BufferedReader products = new BufferedReader(new FileReader("src/product.txt"));
    		Boolean flag = false;
    		System.out.println(supLine);
    		
    		while((proLine = products.readLine()) != null) {
    			String supName = proLine.substring(0, proLine.indexOf("|"));
    			String rest = proLine.substring(proLine.indexOf("|")+1, proLine.lastIndexOf("|"));
    			String proName = rest.substring(0, rest.indexOf("|"));
    			
    			if(supName.equalsIgnoreCase(supLine)) {
    				System.out.println("\t- " + proName);
    				flag = true;
    			}
    		}
			products.close();
    		if(!flag)
    			System.out.println("\tThis supplier don't have any product to view!");

    		System.out.println("");
    	}
    }

    public void searchSupplier(String keyword) throws IOException {
    	BufferedReader suppliers = new BufferedReader(new FileReader("src/suppliers.txt"));
    	BufferedReader products = new BufferedReader(new FileReader("src/product.txt"));
    	String supLine;
    	String proLine;
    	boolean nameflag = false;
    	
    	while((supLine = suppliers.readLine()) != null) {
	    		boolean flag = false;
	    		
	    		if(supLine.equalsIgnoreCase(String.valueOf(suppliers))) {
	    			nameflag = true;
		    		System.out.println(supLine);
		    		
		    		while((proLine = products.readLine()) != null) {
		    			String supName = proLine.substring(0, proLine.indexOf("|"));
		    			String rest = proLine.substring(proLine.indexOf("|")+1, proLine.lastIndexOf("|"));
		    			String proName = rest.substring(0, rest.indexOf("|"));
		    			
		    			if(supName.equalsIgnoreCase(supLine)) {
		    				System.out.println("\t- " + proName);
		    				flag = true;
		    			}
		    		}
		    		if(!flag)
		    			System.out.println("\tThis supplier don't have any product to view!");
    		}
    	} 
    	if(!nameflag)
    		System.out.println("Wrong Name!		Try Again,");

		System.out.println("");
    }
}
