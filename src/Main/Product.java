package Main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import javax.swing.JTextField;

public class Product 
{
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
	
	public Product(int barcode, String deviceName, String deviceType, String brand, String colour, String connectivity, 
			int stockQuantity, double originalCost, double retailPrice, String additionalInfo)
	{
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
	
	public String getFormattedAdditionalInfo() 
	{
		if(this.deviceName.equals("keyboard"))
		{
		  return "Keyboard Type : " + this.deviceType + ", Keyboard Layout : "+ this.additionalInfo;
		} else {
			return "Mouse Type : " + this.deviceType + ", Number of Buttons : "+ this.additionalInfo;
		}
	}
	
	// Sort products by stock quantity
	public static ArrayList<Product> sortProductsByQuantity(ArrayList<Product> products) 
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
	
	// View Stock.txt
	public static ArrayList<Product> getProducts() 
	{
		Scanner fileScanner = null;
		ArrayList<Product> products = new ArrayList<Product>();
		try {
			File stockFile = new File("Stock.txt");
			fileScanner = new Scanner(stockFile);			
				
			while (fileScanner.hasNextLine())
			{
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
		catch (Exception e) 
		{
			e.printStackTrace();
			System.out.println(e.getMessage());
		} 
		finally 
		{
			fileScanner.close();
		}
		return  sortProductsByQuantity(products);
	}
		
	public static ArrayList<Product> getUKLayoutKeyboards() 
	{
		ArrayList<Product> products = getProducts();
		for(Product per : products) 
		{
			if (((Product)per).getAdditionalInfo().contains("UK")) 
			{
				System.out.println(per.toString());
			}
		}
		return products;
	}
		
	/*public ArrayList<Product> getProductsByBrand()
	{
		ArrayList<Product> products = getProducts();
		for(Product per : products) 
		{
			if (((Product)per).getBrand().equals(whatever brand name))
			{
				System.out.println(per.toString());
			}
		}
	}*/
	
	// Add product after validation
	public static void addProductToStock(JTextField txtBarcode, JTextField txtDeviceName, JTextField txtDeviceType, JTextField txtBrand, 
			JTextField txtColour, JTextField txtConnectivity, JTextField txtQuantity, JTextField txtOriginalCost, 
			JTextField txtRetailPrice, JTextField txtAdditionalInfo)
	{
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("Stock.txt", true));
				
			writer.write(txtBarcode.getText() + ", " + txtDeviceName.getText() + ", " + txtDeviceType.getText() + ", " + 
			txtBrand.getText() + ", " + txtColour.getText() + ", " + txtConnectivity.getText() + ", " + txtQuantity.getText() + ", " + 
			txtOriginalCost.getText() + ", " + txtRetailPrice.getText() + ", " + txtAdditionalInfo.getText() + "\n");
				
			writer.close();
				
			System.out.println("Product Added");
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
