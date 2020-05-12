package Main;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Product {
	private int barcode;
	private String deviceName;
	private String deviceType;
	private String brand;
	private String colour;
	private String connectivity;
	private int stockQuantity;
	private double originalCost;
	private double retailPrice;
	private String additionalInfo;
	
	
	public Product() {}
	
	public Product(int barcode, String deviceName, String deviceType, String brand, String colour, String connectivity, int stockQuantity, 
			double originalCost, double retailPrice, String additionalInfo){
		this.barcode = barcode;
		this.deviceName = deviceName;
		this.brand = brand;
		this.colour = colour;
		this.connectivity = connectivity;
		this.stockQuantity = stockQuantity;
		this.originalCost = originalCost;
		this.retailPrice = retailPrice;
		this.deviceType = deviceType;
		this.additionalInfo = additionalInfo;
	}
	
	// Getter Methods
	public int getBarcode() {return this.barcode;}
	public String getdeviceName() {return this.deviceName;}
	public String getBrand() {return this.brand;}
	public String getColour() {return this.colour;}
	public String getConnectivity() {return this.connectivity;}
	public int getStockQuantity() {return this.stockQuantity;}
	public double getOriginalCost() {return this.originalCost;}
	public double getRetailPrice() {return this.retailPrice;}
	public String getDeviceName() {return this.deviceType;}
	public String getAdditionalInfo() {return this.additionalInfo;}
	
	public String getFormattedAdditionalInfo() {
		if(this.deviceName.equals("keyboard")) {
		  return "Keyboard Type : " + this.deviceType + ", Keyboard Layout : "+ this.additionalInfo;
		} else {
			return "Mouse Type : " + this.deviceType + ", Number of Buttons : "+ this.additionalInfo;
		}
	}
	
	// View Stock.txt
	public ArrayList<Product> getProducts() {
		Scanner fileScanner = null;
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			File stockFile = new File("Stock.txt");
			fileScanner = new Scanner(stockFile);			
			
				while (fileScanner.hasNextLine()){
					String[] attributes = fileScanner.nextLine().split(",");				
					
					Product product = new Product (
							Integer.parseInt(attributes[0].trim()),
							attributes[1].trim(),
							attributes[2].trim(), 
							attributes[3].trim(), 
							attributes[4].trim(), 
							attributes[5].trim(), 
							Integer.parseInt(attributes[6].trim()), 
							Double.parseDouble(attributes[7].trim()), 
							Double.parseDouble(attributes[8].trim()), 
							attributes[9].trim() 
							);
					products.add(product);
				}			
		}
		catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		finally {
			fileScanner.close();
		}
		return products;
	}
	
	// Sort products by stock quantity
	public ArrayList<Product> sortProductsByQuantity(ArrayList<Product> products) 
	{
		Collections.sort(products, new Comparator<Product>()
		{
		    public int compare(Product p1, Product p2) 
		    {
		        
		    	if (p1.getStockQuantity() > p2.getStockQuantity()) 
		    	{
		            return -1;
		        } 
		    	else if (p1.getStockQuantity() < p2.getStockQuantity()) 
		        {
		            return 1;
		        }
		        return 0;
		    }
		});
		return products;
	}
	
	
}
